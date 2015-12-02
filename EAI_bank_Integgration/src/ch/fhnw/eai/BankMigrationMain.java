package ch.fhnw.eai;

import ch.fhnw.eai.jd.BankJDGetter;
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
        BankJDGetter bJD = new BankJDGetter();
        bJD.getKontoKorent(kunden, kontos, BankJDGetter.kontoArt.KontoKorent);
        bJD.getKontoKorent(kunden, kontos, BankJDGetter.kontoArt.SparKonto);

        //TODO 1. Call VCT
        //TODO 2. Set Kundenstatus
        //TODO 3. Create / Save DB
        // ?output
    }

}
