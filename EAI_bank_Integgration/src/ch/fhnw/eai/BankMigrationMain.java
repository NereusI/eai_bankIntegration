package ch.fhnw.eai;

import ch.fhnw.eai.jd.BankJDGetter;
import ch.fhnw.eai.vct.ReadCSV;
import java.util.ArrayList;

//import sun.swing.BakedArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Loïc
 */
public class BankMigrationMain {

    ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    ArrayList<Konto> kontos = new ArrayList<Konto>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start");
        //  BankJDGeter.getData();

        BankJDGetter bJD = new BankJDGetter();
        bJD.getKontoKorent(BankJDGetter.kontoArt.KontoKorent);
        bJD.getKontoKorent(BankJDGetter.kontoArt.SparKonto);

        //TODO 1. Call VCT
        //TODO 2. Set Kundenstatus
        //TODO 3. Create / Save DB
        // ?output
        ReadCSV bankVCT = new ReadCSV();
        BankMigrationMain main = new BankMigrationMain();

        ArrayList<Kunde> kundenVCT = bankVCT.holeKunden();
        ArrayList<Konto> kontenVCT = bankVCT.holeKonten();
        main.zusamenführenKontoKunde(kundenVCT, kontenVCT);
        ArrayList<Kunde> kundenJDKK = bJD.getKundeKK();
        ArrayList<Konto> kontosJDKK = bJD.getKontoKK();
        main.zusamenführenKontoKunde(kundenJDKK, kontosJDKK);
        ArrayList<Kunde> kundenJDSpar = bJD.getKundeSpar();
        ArrayList<Konto> kontosJDSpar = bJD.getKontoSpar();
        main.zusamenführenKontoKunde(kundenJDSpar, kontosJDSpar);

        for (Kunde kund : main.kunden) {
            int guthaben = 0;
            for (Konto kont : main.kontos) {
                if (kont.getKid() == kund.getKid()) {
                    guthaben += kont.getKontostand();
                }
            }
            kund.setStatus(guthaben);
        }
        
        
        
        for (Kunde kunde : main.kunden) {
            System.out.println(kunde);
        }
        System.out.println("********************");

        for (Konto kunde : main.kontos) {
            System.out.println(kunde);
        }

    }

    private void zusamenführenKontoKunde(ArrayList<Kunde> newKunden, ArrayList<Konto> newKonten) {
        for (int i = 0; i < newKunden.size(); i++) {
            Kunde kunde = newKunden.get(i);
            Konto konto = newKonten.get(i);
            int kundeID = -1;
            boolean newKunde = false;

            for (Kunde k : kunden) { //
                kundeID = k.kundeExistiert(kunde);     //Existirt der Kunde Bereits
                if (kundeID >= 0) {    // Ja, konto an den Kunden Knüpfen
                    konto.setKid(kundeID);
                    break;
                }
                if (kundeID < 0) {
                    kundeID = kunden.size() + 1;
                    kunde.setKid(kundeID);
                    newKunde = true;

                    konto.setKid(kundeID);
                }
            }

            if (kunden.size() < 1) {
                kundeID = kunden.size() + 1;
                kunde.setKid(kundeID);
                kunden.add(kunde);
                konto.setKid(kundeID);
            }
            if (newKunde) {
                kunden.add(kunde);
            }
            kontos.add(konto);
        }
    }

}
