package ch.fhnw.eai.vct;


import ch.fhnw.eai.Konto;
import ch.fhnw.eai.Kunde;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


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
    public static void main(String[] args) {

        String csvFile = "C:\\EAI_Project\\EAI Project\\semesteraufgabe\\Bank-VCT\\Account.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        int iteration = 0;
        Konto konto = new Konto();
        Kunde kunde = new Kunde();
        NameSplitter ns = new NameSplitter();
        
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while((line = br.readLine()) != null){
                String[] content = line.split(csvSplitBy);
                if(iteration == 0) {
                    iteration++;  
                    continue;
                }
                else{
                        if(!(content[6]).contains("Firma")){
                        konto.setKid(0);
                        konto.setIban(content[9], content[7]);
                        konto.setKontoart(1);
                        konto.setKontostand((int) Math.round(Double.parseDouble(content[8])));      
                        System.out.println(konto.toString());

                        kunde.setKid(Integer.parseInt(content[0]));
                        String[] name= ns.splitter(content[1]);
                        kunde.setVorname(name[0]);
                        kunde.setNachname(name[1]);
                        kunde.setAdresse(content[2], content[3], content[4], content[5]);
                        kunde.setLaendercode(content[5]);
                        kunde.setStatus((int) Math.round(Double.parseDouble(content[8])));
                        System.out.println(kunde.toString());
                        }else{
                            System.out.println("Firmenkonten dürfen nicht migriert werden");
                        }
                    }
             
                }
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ex) {
		ex.printStackTrace();
	}finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
            }
        }
    System.out.println("Done"); 
}
}