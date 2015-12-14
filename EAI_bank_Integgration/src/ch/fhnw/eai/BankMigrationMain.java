package ch.fhnw.eai;

import ch.fhnw.eai.jd.BankJDGetter;
import ch.fhnw.eai.vct.ReadCSV;
import java.util.ArrayList;


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
        
        //Prepare the information in the different instance.
        BankJDGetter bJD = new BankJDGetter();
        bJD.getKontoKorent(BankJDGetter.kontoArt.KontoKorrent);
        bJD.getKontoKorent(BankJDGetter.kontoArt.SparKonto);
        ReadCSV bankVCT = new ReadCSV();
        BankMigrationMain main = new BankMigrationMain();

        //Pull the information out of the instance and merge them together 
        ArrayList<Kunde> kundenVCT = bankVCT.holeKunden();
        ArrayList<Konto> kontenVCT = bankVCT.holeKonten();
        main.zusamenführenKontoKunde(kundenVCT, kontenVCT);
        ArrayList<Kunde> kundenJDKK = bJD.getKundeKK();
        ArrayList<Konto> kontosJDKK = bJD.getKontoKK();
        main.zusamenführenKontoKunde(kundenJDKK, kontosJDKK);
        ArrayList<Kunde> kundenJDSpar = bJD.getKundeSpar();
        ArrayList<Konto> kontosJDSpar = bJD.getKontoSpar();
        main.zusamenführenKontoKunde(kundenJDSpar, kontosJDSpar);

        //Write each table in a CSV
        WriteIntoCSV w = new WriteIntoCSV();
        w.generateCsvFileForAccounts("./konten.csv", main.kontos);
        w.generateCsvFileForClients("./kunden.csv", main.kunden);

       //Print additionally the customer and the accounts in the console 
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

    /**
     * Add the customer and his/her account to the list of existing customer.
     * If the costumer already exists. In the account the customer ID will be adapted whiteout creating a new costumer.
     * @param newKunden List of new costumer, the algorithm to make shore the costumer dose not already exist is in the Class Kunde.
     * @param newKonten The accounts must be placed in the list in the same order (size) then the costumer
     */
    private void zusamenführenKontoKunde(ArrayList<Kunde> newKunden, ArrayList<Konto> newKonten) {
        for (int i = 0; i < newKunden.size(); i++) {
            Kunde kunde = newKunden.get(i);
            Konto konto = newKonten.get(i);
            int kundeID = -1;
            boolean newKunde = false;

            for (Kunde k : kunden) { //
                kundeID = k.kundeExistiert(kunde);     //Existiert der Kunde bereits?
                if (kundeID >= 0) {    // Ja, Konto an den Kunden knüpfen
                    konto.setKid(kundeID);
                    break;
                }

            }
            if (kundeID < 0) {
                kundeID = kunden.size() + 1;
                kunde.setKid(kundeID);
                newKunde = true;
                konto.setKid(kundeID);
            }

            if (newKunde) {
                kunden.add(kunde);
            }
            kontos.add(konto);
        }
    }

}
