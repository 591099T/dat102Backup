package no.hvl.dat102.MengdeMedlem;

import java.util.Arrays;

public class Datakontakt extends Medlem {

	private Medlem[] medlemstabell;
	private int antallMedlemmer;
	private static int STDK = 100;

	public Datakontakt(Medlem[] medlem, int antall) {

		medlemstabell = new Medlem[STDK];
		medlemstabell = medlem;
		antallMedlemmer = antall;

	}

	public Datakontakt() {
		// TODO Auto-generated constructor stub
	}

	public static int getSTDK() {
		return STDK;
	}

	public static void setSTDK(int stdk) {
		STDK = stdk;
	}

	public Medlem[] getMedlemstabell() {
		return medlemstabell;
	}

	public void setMedlemstabell(Medlem[] medlemstabell) {
		this.medlemstabell = medlemstabell;
	}

	public int getAntall() {
		return antallMedlemmer;
	}

	public void setAntall(int antall) {
		this.antallMedlemmer = antall;
	}

	public void leggTilMedlem(Medlem person) {

		if (antallMedlemmer == medlemstabell.length) {
			utvid();
		}
		medlemstabell[antallMedlemmer] = person;
		antallMedlemmer++;

		/**
		 * boolean laTil = false; for (int i = 0; i<medlemstabell.length; i++){
		 * if(medlemstabell[i] == null || medlemstabell[i].equals(person)) {
		 * medlemstabell[i] = person; laTil = true; break; } } if (!laTil) { utvid();
		 * leggTilMedlem(person); }
		 */
	}

	private void utvid() {
		Medlem[] utvid = new Medlem[medlemstabell.length * 2];
		for (int i = 0; i < medlemstabell.length; i++) {
			utvid[i] = medlemstabell[i];
		}
		medlemstabell = utvid;
	}

	public boolean erTom() {
		return (antallMedlemmer == 0);
	}

	public int finnMedlemsIndeks(String medlemsnavn) {

		int indeks = 0;
		for (int i = 0; i < medlemstabell.length && indeks == 0; i++) {
			if (medlemsnavn.equals(medlemstabell[i].getNavn())) {
				indeks = i;
			}

		}
		return indeks;
		/**
		 * Medlem[] indeks = new Medlem[0]; for (Medlem index : medlemstabell) { if
		 * (index != null && index.getNavn().contains(medlemsnavn)) { indeks =
		 * Arrays.copyOf(indeks, indeks.length+1); indeks[indeks.length-1] = index;
		 * }else { indeks = -1; } } return indeks;
		 */
		// *************************************************
		/**
		 * Medlem indeks = null; for (int i = 0; i<medlemstabell.length; i++) {
		 * if(medlemstabell[i] != null && medlemstabell[i].getNavn() == medlemsnavn) {
		 * indeks= medlemstabell[i]; }else {
		 * 
		 * indeks= medlemstabell[-1]; } }return indeks;
		 */
	}

	public int finnPartnerFor(String medlemsnavn) {

		int indeks = finnMedlemsIndeks(medlemsnavn);
		int par = -1;
		for (int i = 0; i < medlemstabell.length && par < 0; i++) {
			if (medlemstabell[indeks].passerTil(medlemstabell[i])) {
				indeks = i;
				medlemstabell[indeks].setStatusIndeks(par);
				medlemstabell[par].setStatusIndeks(indeks);
			}
		}
		return par;

		/**
		 * Medlem indeks = null; Medlem indeks2 = null; for (int i = 0;
		 * i<medlemstabell.length; i++) { if(medlemstabell[i].getStatusIndeks()== -1 &&
		 * medlemstabell[i].getNavn() == medlemsnavn) { indeks2= medlemstabell[i]; //
		 * indeks.setStatusIndeks(i); Gjøre dette når eg har funnet eit anna par.
		 * for(int j = 0; j< medlemstabell.length;j++) {
		 * if(medlemstabell[j].getStatusIndeks() == -1 &&
		 * medlemstabell[j].passerTil(indeks2) ) { indeks2.setStatusIndeks(i);
		 * indeks.setStatusIndeks(j); } }
		 * 
		 * }else {
		 * 
		 * indeks= medlemstabell[-1]; } }return indeks;
		 */
	}

	public void tilbakesillStatusIndeks(String medlemsnavn) {

		int indeks = finnMedlemsIndeks(medlemsnavn);
		int par = finnPartnerFor(medlemsnavn);

		if (par > -1 && indeks > -1) {
			medlemstabell[indeks].setStatusIndeks(-1);
			medlemstabell[par].setStatusIndeks(-1);
		}

	}
	/**
	 * private int finn() { int i = 0, resultat = -1; // ...Fyll ut //int i = 0,
	 * resultat = -1; if(!erTom()) {
	 * 
	 * while (i < bak && el.compareTo(liste[i]) > 0) { i++; } if (i < bak &&
	 * el.compareTo(liste[i]) == 0) { resultat = i; } }
	 * 
	 * 
	 * return resultat; }
	 */

	public void tilbakestillStausIndeks(String medlemsnavn) {
		int indeks = finnMedlemsIndeks(medlemsnavn);
		int par = finnPartnerFor(medlemsnavn);

		if (par > -1 && indeks > -1) {
			medlemstabell[indeks].setStatusIndeks(-1);
			medlemstabell[par].setStatusIndeks(-1);
		}
		
	}

	

}
