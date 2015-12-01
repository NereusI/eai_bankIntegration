package ch.fhnw.eai.jd;


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
public class JDKontokorent {

    javax.xml.ws.Holder<java.lang.String> vorname = new Holder<>("*");
    javax.xml.ws.Holder<java.lang.String> nachname = new Holder<>("");
    javax.xml.ws.Holder<java.lang.String> adresse = new Holder<>("");
    javax.xml.ws.Holder<java.lang.String> land = new Holder<>("");
    javax.xml.ws.Holder<java.lang.Integer> ranking = new Holder<>(0);
    javax.xml.ws.Holder<java.lang.String> ibanKontonummer = new Holder<>("");
    javax.xml.ws.Holder<java.lang.Float> kontostand = new Holder<>();
    javax.xml.ws.Holder<java.lang.String> bic = new Holder<>("");

    public Holder<String> getVorname() {
        return vorname;
    }

    public void setVorname(Holder<String> vorname) {
        this.vorname = vorname;
    }

    public Holder<String> getNachname() {
        return nachname;
    }

    public void setNachname(Holder<String> nachname) {
        this.nachname = nachname;
    }

    public Holder<String> getAdresse() {
        return adresse;
    }

    public void setAdresse(Holder<String> adresse) {
        this.adresse = adresse;
    }

    public Holder<String> getLand() {
        return land;
    }

    public void setLand(Holder<String> land) {
        this.land = land;
    }

    public Holder<Integer> getRanking() {
        return ranking;
    }

    public void setRanking(Holder<Integer> ranking) {
        this.ranking = ranking;
    }

    public Holder<String> getIbanKontonummer() {
        return ibanKontonummer;
    }

    public void setIbanKontonummer(Holder<String> ibanKontonummer) {
        this.ibanKontonummer = ibanKontonummer;
    }

    public Holder<Float> getKontostand() {
        return kontostand;
    }

    public void setKontostand(Holder<Float> kontostand) {
        this.kontostand = kontostand;
    }

    public Holder<String> getBic() {
        return bic;
    }

    public void setBic(Holder<String> bic) {
        this.bic = bic;
    }

    @Override
    public String toString() {
        return "JDSparkonto{" + "vorname=" + vorname.toString() + ", nachname=" 
                + nachname.toString() + ", adresse=" + adresse.toString() + ", land=" 
                + land.toString() + ", ranking=" + ranking.toString() +
                ", ibanKontonummer=" + ibanKontonummer.toString() + ", kontostand=" + kontostand.toString() + ", bic=" + bic.toString() + '}';
    }

  
    
    
    

}
