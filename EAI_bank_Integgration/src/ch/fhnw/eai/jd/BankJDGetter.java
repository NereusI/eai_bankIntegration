package ch.fhnw.eai.jd;

import ch.fhnw.eai.Konto;
import ch.fhnw.eai.Kunde;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.Holder;

/**
 *
 * @author Loïc
 */
public class BankJDGetter {

    public enum kontoArt {
        KontoKorent, SparKonto
    }

    private ArrayList<Kunde> kundeKK = new ArrayList<>();
    private ArrayList<Konto> kontoKK = new ArrayList<>();
    private ArrayList<Kunde> kundeSpar = new ArrayList<>();
    private ArrayList<Konto> kontoSpar = new ArrayList<>();
    private static double wechselKurs = 1.1;

    /**
     *
     * Liest die daten aus de WSDL Datei und schreibt diese in die übergebene
     * arrays (call bay referance)
     *
     * @param ka enum KontoKorent, SparKonto
     */
    public void getKontoKorent(kontoArt ka) {
        try {

            List<String> nachname = listeSparkontoNachname();
            if (ka == kontoArt.KontoKorent) {
                nachname = listeKontokorrentNachname();
            }

            for (String name : nachname) {
                Kunde kunde = new Kunde();
                Konto konto = new Konto();
                if (ka == kontoArt.KontoKorent) {
                    holeKontoKorrent("", name, kunde, konto);
                    kundeKK.add(kunde);
                    kontoKK.add(konto);
                } else {
                    holeSparkonto("", name, kunde, konto);
                    kundeSpar.add(kunde);
                    kontoSpar.add(konto);
                }
            }
        } catch (Exception e) {
            System.out.println("!!!Pleas Start first the VCT Server!!!\n"
                    + "!!!Bitte Starten Sie zuerst den VCT Server!!!");
            return;
           
        }
        //printKontokorrent();
    }

    private static void printKontokorrent() throws Exception {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.printKontokorrent();
    }

    /**
     * funktion by WSDL
     *
     * @return nur nachname / private static java.util.List<java.lang.String>
     * listeKontokorrentNachname() { ch.fhnw.wi.eai.bankjd.BankJDService service
     * = new ch.fhnw.wi.eai.bankjd.BankJDService(); ch.fhnw.wi.eai.bankjd.BankJD
     * port = service.getBankJDPort(); printKontokorrent(); printSparkonto();
     * return port.listeKontokorrentNachname(); } //
     */
    private static void holeKontoKorrent(java.lang.String queryVorname, java.lang.String queryNachname, Kunde kunde, Konto konto) throws Exception {//, javax.xml.ws.Holder<java.lang.String> vorname, javax.xml.ws.Holder<java.lang.String> nachname, javax.xml.ws.Holder<java.lang.String> adresse, javax.xml.ws.Holder<java.lang.String> land, javax.xml.ws.Holder<java.lang.Integer> ranking, javax.xml.ws.Holder<java.lang.String> ibanKontonummer, javax.xml.ws.Holder<java.lang.Float> kontostand, javax.xml.ws.Holder<java.lang.String> bic) {
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

        // Save the kustumer & Client
        kunde.setKid(-1);
        kunde.setVorname(vorname.value);
        kunde.setNachname(nachname.value);
        kunde.setAdresse(adresse.value);
        kunde.setLaendercode(land.value);

        konto.setKid(-1);
        konto.setIban(ibanKontonummer.value);
        konto.setKontostand((int) (kontostand.value * 100 * wechselKurs)); //Float to int
        konto.setKontoart(1);

    }

    private static java.util.List<java.lang.String> listeSparkontoNachname() throws Exception {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeSparkontoNachname();
    }

    /**
     *
     * @param queryVorname
     * @param queryNachname
     * @param kunde
     * @param konto
     */
    private void holeSparkonto(String queryVorname, String queryNachname, Kunde kunde, Konto konto) throws Exception {
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

        kunde.setKid(-1);
        kunde.setVorname(vorname.value);
        kunde.setNachname(nachname.value);
        kunde.setAdresse(strasse.value + ", " + plzOrt.value);
        kunde.setLaendercode("CH");
        kunde.setStatus("");

        konto.setKid(-1);
        konto.setIban(206 + "", kontonummer.value + "");
        konto.setKontostand((int) (kontostand.value * (1 + zinsen.value) * 100 * wechselKurs)); //Zins Anrechnen; Long to int
        konto.setKontoart(2);

    }

    private static void printSparkonto() throws Exception {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        port.printSparkonto();
    }

    private static java.util.List<java.lang.String> listeKontokorrentNachname() throws Exception {
        ch.fhnw.wi.eai.bankjd.BankJDService service = new ch.fhnw.wi.eai.bankjd.BankJDService();
        ch.fhnw.wi.eai.bankjd.BankJD port = service.getBankJDPort();
        return port.listeKontokorrentNachname();
    }

    public ArrayList<Kunde> getKundeKK() {
        return kundeKK;
    }

    public ArrayList<Konto> getKontoKK() {
        return kontoKK;
    }

    public ArrayList<Kunde> getKundeSpar() {
        return kundeSpar;
    }

    public ArrayList<Konto> getKontoSpar() {
        return kontoSpar;
    }

}
