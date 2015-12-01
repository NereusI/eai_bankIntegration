package ch.fhnw.eai;


import ch.fhnw.eai.jd.BankJDGeter;
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
        
        ArrayList<Kunde> kunden = new ArrayList<Kunde>();
        ArrayList<Konto> kontos = new ArrayList<Konto>();
        BankJDGeter bJD = new BankJDGeter();
        bJD.getKontoKorent(kunden, kontos, BankJDGeter.kontoArt.KontoKorent);
        bJD.getKontoKorent(kunden, kontos, BankJDGeter.kontoArt.SparKonto);
        
        //TODO 1. Call VCT
        
        //TODO 2. Set Kundenstatus
        
        //TODO 3. Create / Save DB
        
        // ?autput
        
        
    }
    
}
