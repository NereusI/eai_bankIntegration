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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Start");
        //  BankJDGeter.getData();
        System.out.println("End");

        ArrayList<Kunde> kundenJD = new ArrayList<Kunde>();
        ArrayList<Konto> kontosJD = new ArrayList<Konto>();
        BankJDGetter bJD = new BankJDGetter();
        bJD.getKontoKorent(kundenJD, kontosJD, BankJDGetter.kontoArt.KontoKorent);
        bJD.getKontoKorent(kundenJD, kontosJD, BankJDGetter.kontoArt.SparKonto);

        //TODO 1. Call VCT
        //TODO 2. Set Kundenstatus
        //TODO 3. Create / Save DB
        // ?output
        
        ArrayList<Kunde> kundenVCT = new ArrayList<Kunde>();
        ArrayList<Konto> kontenVCT = new ArrayList<Konto>();       
        ReadCSV bankVCT = new ReadCSV();
        kontenVCT = bankVCT.holeKonten();
        kundenVCT = bankVCT.holeKunden();
        
        for (Kunde kunde : kundenVCT) {
	    System.out.println(kunde);
	}
      
    
        
        
        
    }

}
