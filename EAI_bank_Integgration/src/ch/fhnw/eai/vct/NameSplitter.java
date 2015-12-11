package ch.fhnw.eai.vct;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Diese ist noch nicht endgültig PS!!!! Hinkelman to lower Case!!!
 *
 * @author Loïc
 */
public class NameSplitter {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] names = new String[8];
        names[0] = "Roger Mueller";
        names[1] = "Aldo von Wangenheim";
        names[2] = "F. van Harmelen";
        names[3] = "M. M. Richter";
        names[4] = "Otthein Herzog";
        names[5] = "Dr. Oliver Bendel";
        names[6] = "Stella Gatziu Grivas";
        names[7] = "Knut HINKELMANN";
        NameSplitter ns = new NameSplitter();
        for (String name : names) {
            String nameSplite[] = ns.splitter(name);
           System.out.println("vor. " + nameSplite[0] + "; Nachname: " + nameSplite[1]);
        }
       
    }

    /*  public String[] splitter(String fullName) {
        String[] parts = fullName.split(" ");

        boolean splitKorekt = true;

        int splitNr = splitAt(fullName);
        System.out.println(splitNr);
        System.out.println(fullName);
        //do the actual spliting
        String[] result = new String[2];
        return result;
    }*/

    private String[] splitter(String fullName) {
        String[] parts = fullName.split(" ");
        ArrayList<String> partsList = new ArrayList<String>(Arrays.asList(parts));
        String[] nameSplited = new String[2];
        nameSplited[0] = "";
        nameSplited[1] = "";

        //Move the title of a person to the family Name and short the Array list.
        for (int position = 0; position < partsList.size(); position++) {
            if (partsList.get(position).contains("Dr.")|partsList.get(position).contains("Prof")) {
                nameSplited[1] += partsList.get(position);
                partsList.remove(position);

            }
        }

        nameSplited[0] = partsList.get(0);
        if (partsList.size() == 2) {
            nameSplited[1] += partsList.get(1);
        } else if (partsList.get(1).contains(("von"))||partsList.get(1).contains(("van"))) {
            nameSplited[1] += partsList.get(1);
            nameSplited[1] += partsList.get(2);
        } else if (partsList.get(1).matches(".\\.")) { //z.B. F. --> first name
            nameSplited[0] += partsList.get(1);
            nameSplited[1] += partsList.get(2);
        } else {
            nameSplited[0] += partsList.get(1);
            for (int x = 2; x < partsList.size(); x++) {
                nameSplited[1] += partsList.get(x);
            }
            System.out.println("Following name couldn’t be split correctly: " + nameSplited[0] + "; " + nameSplited[1]);

        }

        /* 
       int length = parts.length;
        int splitAt = 1;
        if (parts.length == 2) { // could be deleted
            splitAt = 1;
        } else if (parts.length == 3) { // alle länger den zwei
            for (int x = 0; x < length - 1; x++) {
                if (parts[x].contains("Dr.") || parts[x].contains("Prof")) {
                    splitAt++;
                } else if (x < 0 && parts[x].matches(".\\.")) { //TODO Probleme
                    splitAt++;
                    System.out.println("split at ..");
                } else if (parts[x].contains("v.n")) {
                    //TODO shorly a family name, was one befor?

                    return x - 1;
                }

            }
            //TODO split failed?

        }*/
        return nameSplited;
    }

}
