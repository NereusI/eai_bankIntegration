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
        } else if (laendercode.contains("Neth") || laendercode.contains("Nied") || laendercode.contains("Holl") || laendercode.contains("NL")) {
            this.laendercode = 4;
        } else if (laendercode.contains("Ital")) {
            this.laendercode = 5;
        } else if (laendercode.contains("Switzerland") || laendercode.contains("Schweiz") || laendercode.contains("Suisse") || laendercode.contains("Svizzera") || laendercode.contains("CH")) {
            this.laendercode = 1;
        } else {
            this.laendercode = -1;
        }

    }

    /**
     * Set Status depending the amount the bank customer owns. The value where delved by the customer
     * As the customer would like to have the account as int (  *100) it has to be taken in count when the evaluation is set.
     * @param status The total amount of money a customer has. The real value will not be saved at this point.
     */
    public void setStatus(int kontostand) {
        int intMultiplikator = 100;
        String status = "not set";
        if (kontostand > 250000 * intMultiplikator) {
            status = "gold";
        } else if (kontostand > 100000 * intMultiplikator && kontostand < 250000 * intMultiplikator) {
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
     * All could be extended/ Adapted with a algorithm with calculate the distance (difference) of two string
     * @author LL
     * @param obj
     * @return ID von existierenden Kunde
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
        // Cheek if in one case first and family name are exchanged 
        if (!Objects.equals(this.vorname.substring(0, 1).toLowerCase(), other.vorname.substring(0, 1).toLowerCase())) {
            if (!(this.nachname.contains(other.vorname) || other.nachname.contains(this.vorname))) {
                return -1;
            }
        }
        if (!(this.nachname.contains(other.nachname) || other.nachname.contains(this.nachname))) {
            if (!(this.vorname.contains(other.nachname) || other.vorname.contains(this.nachname))) {
                return -1;
            }
        }

        // Split the address in street and town.
        String[] partsThisAdress = this.adresse.split(",");
        String[] partsOtherAdress = other.adresse.split(",");
        // Check for missing information in street
        if (!(partsOtherAdress[0].contains(partsThisAdress[0]) || partsThisAdress[0].contains(partsOtherAdress[0]))) {
            return -1;
        }

        ////Compare only the PLZ (number)
        if (partsOtherAdress[1].length() > 4) {
            if (!Objects.equals(partsThisAdress[1].substring(0, 5), partsOtherAdress[1].substring(0, 5))) {
                return -1;
            }
        }
        return kid;
    }

    /**
     * 
     * @param fullName
     * @return In the first element the first name is saved, in the second element the Last name with their titles.
     */
    public String[] splitter(String fullName) {
        String[] parts = fullName.split(" ");
        ArrayList<String> partsList = new ArrayList<String>(Arrays.asList(parts));
        String[] nameSplited = new String[2];
        nameSplited[0] = "";
        nameSplited[1] = "";
      
        //Move the title of a person to the family name and short the Array list.
        for (int position = 0; position < partsList.size(); position++) {
            if (partsList.get(position).contains("Dr.") | partsList.get(position).contains("Prof")) {
                nameSplited[1] += partsList.get(position);
                partsList.remove(position);

            }
        }
        nameSplited[0] = partsList.get(0) + " ";
        if (partsList.size() == 2) {
            nameSplited[1] += partsList.get(1);
        } else if (partsList.get(1).contains(("von")) || partsList.get(1).contains(("van"))) {
            nameSplited[1] += partsList.get(1) + " ";
            nameSplited[1] += partsList.get(2);
        } else if (partsList.get(1).matches(".\\.")) { //z.B. F. --> first name
            nameSplited[0] += partsList.get(1);
            nameSplited[1] += partsList.get(2);
        } else {
            nameSplited[0] += partsList.get(1);
            for (int x = 2; x < partsList.size(); x++) {
                nameSplited[1] += partsList.get(x) + " ";
            }
            System.out.println("Following name couldn’t be split correctly: " + nameSplited[0] + "; " + nameSplited[1]);
            WriteIntoCSV writeIntoCSV = new WriteIntoCSV();
            writeIntoCSV.generateCsvFileForNamspiltErrors("./namenUeberpruefen.csv", nameSplited[0] + "; " + nameSplited[1]);
        }

        vorname = nameSplited[0];
        nachname = nameSplited[1];
        return nameSplited;

    }
}
