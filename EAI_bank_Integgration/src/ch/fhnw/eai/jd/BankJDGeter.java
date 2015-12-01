package ch.fhnw.eai.jd;

import ch.fhnw.eai.Konto;
import ch.fhnw.eai.Kunde;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Holder;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Loïc
 */
public class BankJDGeter {

    public enum kontoArt {
        KontoKorent, SparKonto
    }



    public void getKontoKorent(ArrayList<Kunde> kunden, ArrayList<Konto> kontos, kontoArt ka) {
        List<String> nachname = listeSparkontoNachname();
        if (ka == kontoArt.KontoKorent) {
            nachname = listeKontokorrentNachname();
        }
        Kunde kunde = new Kunde();
        Konto konto = new Konto();

        for (String name : nachname) {
            if (ka == kontoArt.KontoKorent) {
                holeKontoKorrent("", name, kunde, konto);
            } else {
                holeSparkonto("", name, kunde, konto);
            }
            int kundeID;
            for (Kunde k : kunden) {
                kundeID = k.kundExistirt(kunde);     //Existirt der Kunde Bereits
                if (kundeID >= 0) {    // Ja, konto an den Kunden Knüpfen
                    konto.setKid(kundeID);
                    break;
                }
                if (kundeID < 0) {
                    int newKundenID = kunden.size() + 1;
                    kunde.setKid(newKundenID);
                    kunden.add(kunde);
                    konto.setKid(newKundenID);
                }
            }
            kontos.add(konto);
        }
    }

    /**
     * funktion by WSDL
     *
     * @return nur nachname
     */
    private static java.util.List<java.lang.String> listeKontokorrentNachname() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeKontokorrentNachname();
    }

    private static void holeKontoKorrent(java.lang.String queryVorname, java.lang.String queryNachname, Kunde kunde, Konto konto) {//, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> adresse, javax.xml.ws.Holder<java.lang.String> land, javax.xml.ws.Holder<java.lang.Integer> ranking, javax.xml.ws.Holder<java.lang.String> ibanKontonummer, javax.xml.ws.Holder<java.lang.Float> kontostand, javax.xml.ws.Holder<java.lang.String> bic) {
        javax.xml.ws.Holder<java.lang.String> vorname = new Holder<>("*");
        javax.xml.ws.Holder<java.lang.String> nachname = new Holder<>("");
        javax.xml.ws.Holder<java.lang.String> adresse = new Holder<>("");
        javax.xml.ws.Holder<java.lang.String> land = new Holder<>("");
        javax.xml.ws.Holder<java.lang.Integer> ranking = new Holder<>(0);
        javax.xml.ws.Holder<java.lang.String> ibanKontonummer = new Holder<>("");
        javax.xml.ws.Holder<java.lang.Float> kontostand = new Holder<>();
        javax.xml.ws.Holder<java.lang.String> bic = new Holder<>("");

        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.holeKontoKorrent(queryVorname, queryNachname, vorname, nachname, adresse, land, ranking, ibanKontonummer, kontostand, bic);

    }

    private static void printKontokorrent() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.printKontokorrent();
    }




    private static java.util.List<java.lang.String> listeSparkontoNachname() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeSparkontoNachname();
    }
    private void holeSparkonto(String queryVorname, String queryNachname, Kunde kunde, Konto konto) {

        javax.xml.ws.Holder<java.lang.String> vorname = new Holder<>("");
        javax.xml.ws.Holder<java.lang.String> nachname = new Holder<>("");
        javax.xml.ws.Holder<java.lang.String> strasse = new Holder<>("");
        javax.xml.ws.Holder<java.lang.String> plzOrt = new Holder<>("");
        javax.xml.ws.Holder<java.lang.Float> zinsen = new Holder<>(0.0f);
        javax.xml.ws.Holder<java.lang.Long> kontonummer = new Holder<>();
        javax.xml.ws.Holder<java.lang.Long> kontostand = new Holder<>();

        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.holeSparkonto(queryVorname, queryNachname, vorname, nachname, strasse, plzOrt, zinsen, kontonummer, kontostand);

        //TODO von query in kunde / konto schreiben.
        
    }
    
    
    
    
        // TO delet
    private static void printSparkonto() {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.printSparkonto();
    }

}
