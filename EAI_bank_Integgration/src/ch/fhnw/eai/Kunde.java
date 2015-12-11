package ch.fhnw.eai;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void setAdresse(String strassenname, String plz, String stadt, String land) {
        StringBuilder sb = new StringBuilder(); // content[2] = Strassenname, content[3] =  PLZ, content[4] =  Stadt, content[5] =  Land,
        sb.append(strassenname);
        sb.append(", ");
        sb.append(plz);
        sb.append(" ");
        sb.append(stadt);
        sb.append(" ");
        sb.append(land);
        String adresse = sb.toString();
        this.adresse = adresse;
    }

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
        if (laendercode.contains("Deutschland") || laendercode.contains("Germany")) {
            this.laendercode = 2;
        } else if (laendercode.contains("Fra")) {
            this.laendercode = 3;
        } else if (laendercode.contains("Neth") || laendercode.contains("Nied") || laendercode.contains("Holl")|| laendercode.contains("NL")) {
            this.laendercode = 4;
        } else if (laendercode.contains("Ital")) {
            this.laendercode = 5;
        } else  if (laendercode.contains("Switzerland") || laendercode.contains("Schweiz") || laendercode.contains("Suisse") || laendercode.contains("Svizzera")|| laendercode.contains("CH")) {
            this.laendercode = 1;
        } else{
            this.laendercode = -1;
        }

    }

    /**
     * @param status the status to set
     */
    public void setStatus(int kontostand) {
        int intMultiplikator=100;
        String status = "not set";
          if (kontostand > 250000*intMultiplikator) {
            status = "gold";
        } else if (kontostand > 100000*intMultiplikator && kontostand < 250000*intMultiplikator) {
            status = "silber";
        } else {
            status = "bronze";
        }
        
        this.status = status;
    }

    public void setStatus(String status) {
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
     *
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

    
    public String[] splitter(String fullName) {
        String[] parts = fullName.split(" ");
        ArrayList<String> partsList = new ArrayList<String>(Arrays.asList(parts));
        String[] nameSplited = new String[2];
        nameSplited[0] = "";
        nameSplited[1] = "";

        //Move the title of a person to the family Name and short the Array list.
        for (int position = 0; position < partsList.size(); position++) {
            if (partsList.get(position).contains("Dr.") | partsList.get(position).contains("Prof")) {
                nameSplited[1] += partsList.get(position);
                partsList.remove(position);

            }
        }
        nameSplited[0] = partsList.get(0)+" ";
        if (partsList.size() == 2) {
            nameSplited[1] += partsList.get(1);
        } else if (partsList.get(1).contains(("von")) || partsList.get(1).contains(("van"))) {
            nameSplited[1] += partsList.get(1);
            nameSplited[1] += partsList.get(2);
        } else if (partsList.get(1).matches(".\\.")) { //z.B. F. --> first name
            nameSplited[0] += partsList.get(1);
            nameSplited[1] += partsList.get(2);
        } else {
            nameSplited[0] += partsList.get(1);
            for (int x = 2; x < partsList.size(); x++) {
                nameSplited[1] += partsList.get(x) +" ";
            }
            System.out.println("Following name couldn’t be split correctly: " + nameSplited[0] + "; " + nameSplited[1]);
        }
        
        vorname = nameSplited[0];
        nachname = nameSplited[1];
        return nameSplited;
    }
}
