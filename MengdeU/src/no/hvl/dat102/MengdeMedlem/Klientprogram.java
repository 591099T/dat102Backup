package no.hvl.dat102.MengdeMedlem;
import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Klientprogram {
	
public static void main(String[] args) {
		
		
		Datakontakt arkiv = new Datakontakt();
		Meny(arkiv);
}
	
	public static void Meny(Datakontakt arkiv) {
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("---   HOVEDMENY   ---\t");
			System.out.println("1) Legg til ett medlemm");
			System.out.println("2) Skriv ut hobbyliste til et medlem");
			System.out.println("3) Skriv ut alle par");
			System.out.println("4) Finn partner til en person");
			System.out.println("5) Nullstill partner til en person");
			System.out.println("9) Avslutt programmet");
			int valg = sc.nextInt();
			sc.nextLine();
			
			if(valg == 1) {
				Medlem medlem = Tekstgrensesnitt.lesMedlem();
				arkiv.leggTilMedlem(medlem);
			}
			else if(valg == 2) {
				System.out.println("Hva heter medlemmet?");
				String navn = sc.nextLine();
				int pos = arkiv.finnMedlemsIndeks(navn);
				Medlem[] liste = arkiv.getMedlemstabell();
				Tekstgrensesnitt.skrivHobbyListe(liste[pos]);
			}
			else if(valg == 3) {
				Tekstgrensesnitt.skrivParListe(arkiv);
			}
			else if(valg == 4) {
				System.out.println("Hva heter personen du vil matche?");
				String navn = sc.nextLine();
				int pos = arkiv.finnPartnerFor(navn);
				if(pos == -1) {
					System.out.println(navn + " matchet ikke med noen");
				}
				else {
					Medlem[] liste = arkiv.getMedlemstabell();
					System.out.println(navn + " matchet med " + liste[pos].getNavn());
				}
			}
			else if(valg == 5) {
				System.out.println("Hvem vil du nullstille?");
				String medlemsnavn = sc.nextLine();
				arkiv.tilbakestillStausIndeks(medlemsnavn);
			}
			else if(valg == 9) {
				run = false;
				System.out.println("Avslutter programmet");
			}
		}
	}

	
		
//		MengdeADT<Hobby> male = new TabellMengde<Hobby>() ;
//		MengdeADT<Hobby> danse = new TabellMengde<Hobby>();
//		MengdeADT<Hobby> sprint = new TabellMengde<Hobby>();
//		MengdeADT<Hobby> spille = new TabellMengde<Hobby>();
//		
//		String b1 = new Medlem("Trygve Jenssen", male);
//		Medlem b2 = new Medlem("Trygve Jenssen", danse);
//		Medlem b3 = new Medlem("Trygve Jenssen", sprint);
//		Medlem b4 = new Medlem("Trygve Jenssen", spille);
//		
//		
//		b1.setHobbyer(spille);
//		b1.setHobbyer(danse);
//		b1.setHobbyer(sprint);
//		b2.setHobbyer(spille);
//		b2.setHobbyer(male);
//		b3.setHobbyer(male);
//		b3.setHobbyer(spille);
//		
//		int pos = Datakontakt.finnMedlemsIndeks(b1);
//		Medlem[] liste = Datakontakt.getMedlemstabell();
//		Tekstgrensesnitt.skrivHobbyListe(liste[pos]);
//		
//		b1.toString();
//		b2.toString();
//		b3.toString();
//		b4.toString();	
			
		
	}


