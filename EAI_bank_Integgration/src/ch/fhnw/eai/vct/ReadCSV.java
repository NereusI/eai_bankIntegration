package ch.fhnw.eai.vct;


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
/*
	ch.sic.ibantool.Main ibanclass = new ch.sic.ibantool.Main();
        ch.sic.ibantool.RecordIban recordiban;
        
        String csvFile = "C:\\EAI_Project\\EAI Project\\semesteraufgabe\\Bank-VCT\\Account.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        int iteration = 0;
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while((line = br.readLine()) != null){
                //CSV erste Linie ignorieren
                if(iteration == 0) {
                    iteration++;  
                    continue;
                }else{
                String[] content = line.split(csvSplitBy);
                
                
                String kontonr = content[7];
                String clearing = content[9];
                // Method call with RecordIban class
                recordiban = new ch.sic.ibantool. RecordIban ();
                recordiban.BCPC = new StringBuffer(clearing);
                recordiban.KoZe = new StringBuffer(kontonr);
                recordiban = ibanclass.IBANConvert(recordiban);
                
              // System.out.println("BC:".concat(recordiban.BCZeFi.toString()));
             //  System.out.println("PC:".concat(recordiban.PCZeFi.toString()));
            //   System.out.println("IBAN: ".concat(recordiban.Iban.toString()));
             //  System.out.println("Flag:".concat(recordiban.VFlag.toString()));
                
                //saldo double werte in integer werte umwandeln
                int kontostand = (int) Math.round(Double.parseDouble(content[8]));        
                int kontoart = 0;
                
                Konto konto = new Konto(recordiban.Iban.toString(), kontostand, kontoart);
                System.out.println(konto.toString());
                
                int kid = Integer.parseInt(content[0]);
                String vorname = content[1];
                String nachname = content[1];
                StringBuilder sb = new StringBuilder(); // content[2] = Strassenname, content[3] =  PLZ, content[4] =  Stadt, content[5] =  Land,
                sb.append(content[2]);
                sb.append(", ");
                sb.append(content[3]);
                sb.append(" ");
                sb.append(content[4]);
                //sb.append(" ");
                //sb.append(content[5]);  // in KontokorentAdresse nicht vorhanden Ländercode macht es überflüsig
                String adresse = sb.toString();
                
                String country = content[5];
                int laendercode = 0;
                
                // Ersetzen durch kunde.setLaendercode(String)
                String[] s = {"Schweiz","Switzerland","Suisse"};
                String[] n = {"The Netherlands","Holland","Niederlande"};
                String[] g = {"Deutschland","Germany"};
                
                for(int i=0; i < s.length; i++){
                    if(country.equals(s[i])){
                        laendercode = 1;
                        break;
                    }
                }
                for(int j=0; j < n.length; j++){
                     if(country.equals(n[j])){
                        laendercode = 2;
                        break;
                    }
                }
                for(int k=0; k < g.length; k++){
                    if(country.equals(g[k])){
                        laendercode = 3;
                        break;
                    }
                }
               
                
                int st = (int) Math.round(Double.parseDouble(content[8]));
                String status = "not set";
                if(st < 100000){
                    status = "bronze";
                }else if(st > 100000 && st < 250000){
                    status = "silber";
                }else{
                    status = "gold";
                }
               
                Kunde kunde = new Kunde(kid, vorname, nachname, adresse, laendercode, status);
                System.out.println(kunde.toString());
                
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
    System.out.println("Done"); //*/
}
}