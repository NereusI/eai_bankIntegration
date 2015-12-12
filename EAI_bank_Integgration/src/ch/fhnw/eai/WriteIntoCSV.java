/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.fhnw.eai;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Tobias
 */
public class WriteIntoCSV {

    public static void generateCsvFileForAccounts(String filename, ArrayList<Konto> konten) {
        try {
            FileWriter writer = new FileWriter(filename);

            writer.append("KID");
            writer.append(',');
            writer.append("IBAN");
            writer.append(',');
            writer.append("Kontostand");
            writer.append(',');
            writer.append("Kontoart");
            writer.append(',');

            writer.append('\n');

            ArrayList<Konto> konti = konten;
            for (int i = 0; i < konti.size(); i++) {
                writer.append(konti.get(i).getKid() + "");
                writer.append(',');
                writer.append(konti.get(i).getIban());
                writer.append(',');
                writer.append(konti.get(i).getKontostand() + "");
                writer.append(',');
                writer.append(konti.get(i).getKontoart() + "");
                writer.append('\n');

            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateCsvFileForClients(String filename, ArrayList<Kunde> kunden) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.append("KID");
            writer.append(',');
            writer.append("Vorname");
            writer.append(',');
            writer.append("Nachname");
            writer.append(',');
            writer.append("Adresse");
            writer.append(',');
            writer.append("Ländercode");
            writer.append(',');
            writer.append("Status");
            writer.append('\n');

            //generate whatever data you want
            ArrayList<Kunde> clients = kunden;
            for (int i = 0; i < clients.size(); i++) {
                writer.append(clients.get(i).getKid() + "");
                writer.append(',');
                writer.append(clients.get(i).getVorname() + "");
                writer.append(',');
                writer.append(clients.get(i).getNachname() + "");
                writer.append(',');
                writer.append(clients.get(i).getAdresse());
                writer.append(',');
                writer.append(clients.get(i).getLaendercode() + "");
                writer.append(',');
                writer.append(clients.get(i).getStatus() + "");
                writer.append('\n');
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateCsvFileForNamspiltErrors(String filename, String name) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.append(name + '\n');
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
