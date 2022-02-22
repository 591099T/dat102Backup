package no.hvl.dat102.MengdeMedlem;


import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Tekstgrensesnitt {
	
	//Hvis du vil lage meny, kan du også legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem(){

		Scanner inskriv = new Scanner(System.in);
		
		System.out.println("Skriv inn navn: "); 
		  String navn = inskriv.nextLine();
		  
		  System.out.println("Skriv inn hobbyer: ");
		 
		  String hobbyer = inskriv.nextLine();
		  MengdeADT<Hobby> hobbyerr= TabellMengde<Hobby>inskriv.nextLine());
		  
		  System.out.println("Skriv inn statusindeks: ");
		  int statusIndeks = Integer.parseInt(inskriv.nextLine());
		  
		 
		  Medlem medlem = new Medlem(navn, hobbyer, statusIndeks);
		  return medlem;
		
	//f.eks. bruke Scanner.
	}
	// Skriver ut hobbylisten for et medlem
	
	public static void skrivHobbyListe(Medlem medlem) { 
		System.out.println("Alle hobbyene "); 
		System.out.println(medlem.getHobbyer().toString());
	}
	 
	public static void skrivParListe (Datakontakt arkiv){
	
		for(int i = 0; i<medlemstabell.length;i++) {
			
		}
		
	} 
	/* skriver ut på skjermen en oversikt over medlemmer som er koblet
	til hverandre i medlemstabellen til enhver tid.
	Et slikt par skal kun vises én gang på utskriftlisten. Metoden
	skriver også ut antall par som er funnet.
	Eksempel på utskrift:
	PARNAVN HOBBYER
	Erna og Jonas <ski, musikk, politikk>
	Eva og Adam < epleplukking, paradishopping>
	…………………….
	Antall par funnet: 12
	*/

}
