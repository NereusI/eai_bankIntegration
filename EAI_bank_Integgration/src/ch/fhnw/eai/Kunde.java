package ch.fhnw.eai;

import java.util.Objects;


/**
 *
 * @author Tobias
 */
public class Kunde {

    private int kid;
    private String vorname;
    private String nachname;
    private String adresse;
    private int laendercode;
    private String status;

    public Kunde(int kid, String vorname, String nachname, String adresse, int laendercode, String status) {
        this.kid = kid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.laendercode = laendercode;
        this.status = status;
    }

    public Kunde() {

    }

    /**
     * @return the kid
     */
    public int getKid() {
        return kid;
    }

    /**
     * @return the vorname
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * @return the nachname
     */
    public String getNachname() {
        return nachname;
    }

    /**
     * @return the adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * @return the laendercode
     */
    public int getLaendercode() {
        return laendercode;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param kid the kid to set
     */
    public void setKid(int kid) {
        this.kid = kid;
    }

    /**
     * @param vorname the vorname to set
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * @param nachname the nachname to set
     */
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    /**
     * @param adresse the adresse to set
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @param laendercode the laendercode to set
     */
    public void setLaendercode(int laendercode) {
        this.laendercode = laendercode;
    }

    /**
     * @author LL
     * @param laendercode the laendercode to set
     */
    public void setLaendercode(String laendercode) {
        if (laendercode.contains("Switzerland") || laendercode.contains("Schweiz")|| laendercode.contains("Suisse") || laendercode.contains("Svizzera")){
            this.laendercode = 1;
        } else if (laendercode.contains("Deutschland") || laendercode.contains("Germamny")) {
            this.laendercode = 2;
        } else if (laendercode.contains("Fra")) {
            this.laendercode = 3;
        } else if (laendercode.contains("Neth")||laendercode.contains("Nied")||laendercode.contains("Holl")) {
            this.laendercode = 4;
        } else if (laendercode.contains("Ital")) {
            this.laendercode = 5;
        } else {
            this.laendercode = -1;
        }

    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
       /**
     * @param status the status to set
     */
    public void setStatus(int totalBalanc) {
        //TODO
        this.status = status;
    }

    @Override
    public String toString() {
        return "Kunde{" + "kid=" + kid + ", vorname=" + vorname + ", nachname=" + nachname + ", adresse=" + adresse + ", laendercode=" + laendercode + ", status=" + status + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * Abgeleitet von Equals
     * @author LL
     * @param obj
     * @return ID von existirenden Kunde
     */
    public int kundeExistiert(Object obj) {
        if (this == obj) {
            return -1;
        }
        if (obj == null) {
            return -1;
        }
        if (getClass() != obj.getClass()) {
            return -1;
        }
        final Kunde other = (Kunde) obj;
        if (!Objects.equals(this.vorname, other.vorname)) {
            return -1;
        }
        if (!Objects.equals(this.nachname, other.nachname)) {
            return -1;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return -1;
        }
        return kid;
    }

}
