package no.hvl.dat102.MengdeMedlem;

import java.util.Iterator;
import java.util.Scanner;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;

public class Tekstgrensesnitt {

	// Hvis du vil lage meny, kan du også legge det inn i Tekstgrensesnitt
	// leser opplysningene om et medlem fra tastatur
	public static Medlem lesMedlem() {

		Scanner inskriv = new Scanner(System.in);

		System.out.println("Skriv inn navn: ");
		String navn = inskriv.nextLine();

		System.out.println("Skriv inn hobbyer: ");
		String hobbyInn = inskriv.nextLine();
		// MengdeADT<Hobby> hobbyer= getHobbyNavn(hobbyInn);
		String[] hobbyListe = hobbyInn.split(" ");
		KjedetMengde<Hobby> mengde = new KjedetMengde<>();
		
		for(String s : hobbyListe) {
			mengde.leggTil(new Hobby(s));
		}
		
		return new Medlem(navn, mengde);

	//	System.out.println("Skriv inn statusindeks: ");
	//	int statusIndeks = Integer.parseInt(inskriv.nextLine());

	//	Medlem medlem = new Medlem();
	//	return medlem;

		// f.eks. bruke Scanner.
	}
	// Skriver ut hobbylisten for et medlem

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene ");
		System.out.println(medlem.getHobbyer().toString());
	}

	public static void skrivParListe(Datakontakt arkiv) {
		Medlem[] listen = arkiv.getMedlemstabell();
		int antallPar = 0;
		
		System.out.format("%-20s %s%n", "PARNAVN", "HOBBYER");
		for(int i = 0; i < arkiv.getAntall(); i++) {
			if(listen[i].getStatusIndeks() != -1 && listen[i].getStatusIndeks() > i) {
				int partnerIndex = listen[i].getStatusIndeks();
				System.out.format("%-20s", listen[i].getNavn() + " og " + listen[partnerIndex].getNavn());
				System.out.format(" %s%n", "<" + listen[i].getHobbyer().toString() + ">");
				antallPar++;
			}
		}
		System.out.println("Antall par funnet: " + antallPar);
	}

	/**	KjedetMengde<Integer> par = new KjedetMengde<Integer>();
		int partnerIndex = -1;
		int antallPar = 0;
		for (int i = 0; i < arkiv.getAntall(); i++) {
			partnerIndex = arkiv.getMedlemstabell()[i].getStatusIndeks();
			if (partnerIndex > -1 && !par.inneholder(i) && arkiv.getMedlemstabell()[i] != null) {
				par.leggTil(i);
				par.leggTil(partnerIndex);
				antallPar++;
			}
		}
		System.out.printf("%15s%15s%n", "Par: (Antall: " + antallPar + ")", "Interesser:");

		Iterator<Integer> teller = par.iterator();
		Integer id1;
		Integer id2;
		for (int i = 0; i < antallPar; i++) {
			id1 = teller.next().intValue();
			id2 = teller.next().intValue();
			System.out.printf("%-20s",
					arkiv.getMedlemstabell()[id1].getNavn() + " og " + arkiv.getMedlemstabell()[id2].getNavn());

			// Hobbyer for id1 og id2 vil være like
			System.out.printf("%15s%n", arkiv.getMedlemstabell()[id1].getHobbyer());

		}*/
	}
	/*
	 * skriver ut på skjermen en oversikt over medlemmer som er koblet til hverandre
	 * i medlemstabellen til enhver tid. Et slikt par skal kun vises én gang på
	 * utskriftlisten. Metoden skriver også ut antall par som er funnet. Eksempel på
	 * utskrift: PARNAVN HOBBYER Erna og Jonas <ski, musikk, politikk> Eva og Adam <
	 * epleplukking, paradishopping> ……………………. Antall par funnet: 12
	 */

}
