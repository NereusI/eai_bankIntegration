package ch.fhnw.eai.vct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  Diese ist noch nicht endgültig
 * PS!!!! Hinkelman to lower Case!!!
 * @author Loïc
 */
public class NameSplitter {
    

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String[]  names =  new String [8];
		//names[0] ="Roger Mueller";
		//names[1] ="Aldo von Wangenheim";
		//names[2] ="F. van Harmelen";
		//names[3] ="M. M. Richter";
		//names[4] ="Otthein Herzog";
		//names[5] ="Dr. Oliver Bendel";
		//names[6] ="Stella Gatziu Grivas";
		//names[7] ="Knut HINKELMANN";

		//NameSplitter ns = new NameSplitter();
		
		//for ( String name : names){
			 
			//String nameSplite[] =ns.splitter(name);
			
			
			
		//	System.out.println("vor. "+nameSplite[0]+". Nachname: "+nameSplite[1]);
		//}
		
		

	//}
	
	public String[] splitter (String fullName){
		String[] parts = fullName.split(" ");
		
		boolean splitKorekt =true;
		
		int splitNr =splitAt(parts);
		System.out.println(splitNr);
		System.out.println(fullName);
		//do the actual spliting
		String[] result = new String[2];
		return result;
	}
	
	
	private int splitAt (String parts[]){
		int length = parts.length;
		int splitAt = 1;
		if (parts.length== 2){ // could be deleted
			splitAt=1;
		}else if (parts.length== 3){ // alle länger den zwei
			for (int x=0; x < length-1; x++ ){
				if ( parts[x].contains("Dr.") ||parts[x].contains( "Prof")){
					splitAt++;
				}else if ( x<0 && parts[x].matches(".\\.")){ //TODO Probleme
					splitAt++;
					System.out.println("split at ..");
				}else if ( parts[x].contains("v.n")){
					//TODO shorly a family name, was one befor?
					
					return x-1;
				}
				
			}
			//TODO split failed?
		
		

		}
		
		return splitAt;
	}
    
}
