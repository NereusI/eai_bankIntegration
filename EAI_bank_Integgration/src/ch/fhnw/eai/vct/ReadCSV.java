package ch.fhnw.eai.vct;

import ch.fhnw.eai.Konto;
import ch.fhnw.eai.Kunde;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tobias
 */
public class ReadCSV {

    //String csvFile = "C:\\EAI_Project\\EAI Project\\semesteraufgabe\\Bank-VCT\\Account.csv";
    String csvFile = "src/ch/fhnw/eai/vct/Account.csv"; //All Files	
    BufferedReader br = null;
    String line = "";
    String csvSplitBy = ",";

    int kontoID = 1;

    public ArrayList<Konto> holeKonten() {
        ArrayList<Konto> alleKontenVCT = new ArrayList<Konto>();
        int iteration = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] content = line.split(csvSplitBy);
                if (iteration == 0) {
                    iteration++;
                    continue;
                } else if (!(content[6]).contains("Firma")) {
                    Konto konto = new Konto();
                    konto.setKid(kontoID);
                    konto.setIban(content[9], content[7]);
                    konto.setKontoart(1);
                    konto.setKontostand((int) Math.round(Double.parseDouble(content[8])));
                    alleKontenVCT.add(konto);
                } 
//                else {
//                    System.out.println("Firmenkonten dürfen nicht migriert werden");
//                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return alleKontenVCT;
    }

    public ArrayList<Kunde> holeKunden() {
        ArrayList<Kunde> alleKundenVCT = new ArrayList<Kunde>();
        int iter = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                String[] content = line.split(csvSplitBy);
                if (iter == 0) {
                    iter++;
                    continue;
                } else if (!(content[6]).contains("Firma")) {
                    Kunde kunde = new Kunde();
                    kunde.setKid(1);
                    String[] name = kunde.splitter(content[1]);
                    kunde.setVorname(name[0]);
                    kunde.setNachname(name[1]);
                    kunde.setAdresse(content[2], content[3], content[4], content[5]);
                    kunde.setLaendercode(content[5]);
                    kunde.setStatus((int) Math.round(Double.parseDouble(content[8])));
                    alleKundenVCT.add(kunde);
                    kontoID++;
                } 
//                else {
//                    System.out.println("Firmenkonten dürfen nicht migriert werden");
//                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return alleKundenVCT;
    }

}
