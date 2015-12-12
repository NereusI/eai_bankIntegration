package ch.fhnw.eai;

/**
 *
 * @author Tobias
 */
public class Konto {

    private int kid;
    private String iban;
    private int kontostand;
    private int kontoart; // IDs 1: Kontokorrent, 2:Sparkonto, 3:Depotkonto

    public Konto(String iban, int kontostand, int kontoart) {
        this.iban = iban;
        this.kontostand = kontostand;
        this.kontoart = kontoart;
    }

    public Konto() {

    }

    /**
     * @return the kid
     */
    public int getKid() {
        return kid;
    }

    /**
     * @return the iban
     */
    public String getIban() {
        return iban;
    }

    /**
     * @return the kontostand
     */
    public int getKontostand() {
        return kontostand;
    }

    /**
     * @return the kontoart
     */
    public int getKontoart() {
        return kontoart;
    }

    /**
     * @param kid the kid to set
     */
    public void setKid(int kid) {
        this.kid = kid;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String iban) {
        this.iban = iban;
    }

    /**
     * @param iban the iban to set
     */
    public void setIban(String clearing, String kontonr) {
        ch.sic.ibantool.Main ibanclass = new ch.sic.ibantool.Main();
        ch.sic.ibantool.RecordIban recordiban;
        recordiban = new ch.sic.ibantool.RecordIban();
        recordiban.BCPC = new StringBuffer(clearing);
        recordiban.KoZe = new StringBuffer(kontonr);
        recordiban = ibanclass.IBANConvert(recordiban);
        this.iban = recordiban.Iban.toString();
    }

    /**
     * @param kontostand the kontostand to set
     */
    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    /**
     * @param kontoart the kontoart to set; 1: Kontokorrent, 2:Sparkonto,
     * 3:Depotkonto
     */
    public void setKontoart(int kontoart) {
        this.kontoart = kontoart;
    }

    @Override
    public String toString() {
        return "Konto{" + "kid=" + kid + ", iban=" + iban + ", kontostand=" + kontostand + ", kontoart=" + kontoart + '}';
    }

}
