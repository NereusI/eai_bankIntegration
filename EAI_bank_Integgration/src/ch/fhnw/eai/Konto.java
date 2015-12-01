package ch.fhnw.eai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tobias
 */
public class Konto 
{   
    private int kid;
    private String iban;
    private int kontostand;
    private int kontoart; 

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
     * @param kontostand the kontostand to set
     */
    public void setKontostand(int kontostand) {
        this.kontostand = kontostand;
    }

    /**
     * @param kontoart the kontoart to set
     */
    public void setKontoart(int kontoart) {
        this.kontoart = kontoart;
    }

    @Override
    public String toString() {
        return "Konto{" + "kid=" + kid + ", iban=" + iban + ", kontostand=" + kontostand + ", kontoart=" + kontoart + '}';
    }
    
}
