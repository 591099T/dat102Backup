package no.hvl.dat102.tabell;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.kjedet.LinearNode;

public class TabellOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {

	private final static int STDK = 100;
	private final static int IKKE_FUNNET = -1;
	private int bak;
	private T[] liste;

	public TabellOrdnetListe() {
		this(STDK);
	}

	public TabellOrdnetListe(int startKapasitet) {
		bak = 0;
		liste = (T[]) (new Comparable[startKapasitet]);
	}

	@Override
	public T fjernSiste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ... Fyll ut
		if(!erTom()) {
		resultat = liste[bak - 1];
		liste[bak-1] = null;
		bak--;
		/**
		 * for (int i = 0; i <bak;i++) { liste[bak] = liste[i+1]; }
		 */
		}
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		//... Fyll ut
		if(!erTom()) {
			resultat = liste[0];
			bak--;
			//Flytter alle elementer ett hakk nedover i listen
			for(int i = 0; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = null;
		if (!erTom()){
			resultat = liste[0];
		}
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[bak - 1];

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (bak == 0);
	}

	@Override
	public int antall() {
		return bak;
	}

	@Override
	public void leggTil(T element) {
		
		if(bak == liste.length) {
    		utvid();
    	}
    	int i = 0;
    	//Finner hvor elementet skal
    	while(i < bak && element.compareTo(liste[i]) > 0) {
    		i++;
    	}
    	int j = bak;
    	while(j > i) {
    		liste[j] = liste[j-1];
    		j--;
    	}
    	liste[i] = element;
    	bak++;
		/**
		 * 
		 * if(liste.length == bak) { utvidKapasiteten(); } if(forste == bak){
		 * 
		 * } for (int i =1;i<forste; i++){
		 * 
		 * 
		 * }
		 */
		// ***************************************************
		/**
		 * for (int i = foerste(liste[]); i <= bak; i++) { T temp = liste[i]; int j =
		 * i-1; boolean ferdig = false; while (!ferdig || j < 0) {
		 * if(temp.compareTo(liste[j]) < 0) { liste[j+1]=liste[j]; j--; }else { ferdig =
		 * true; } } liste[j+1]=temp; }
		 */

		// **************************************************

		/**
		 * if (bak == liste.length && liste.length >0 ) { utvid(); } if(liste.length ==
		 * 0) { liste[bak] = element; bak++; } for(int i=0; i<liste.length; i++) { int
		 * aktuell = liste[i]; int j = i-1; while((j>-1) && (liste[j] > aktuell)) {
		 * liste[j+1]=liste[j]; j--; } liste[j+1] = aktuell; }
		 */

		// **********************************************

		// int indeks = finn(element);
		/**int i;
		if (bak == liste.length && liste.length == 0) {
			utvid();
		}

		for (i = 1; i < liste.length; i++) {
			T aktuell = liste[i];
			int j = i - 1;
			while ((i > -1) && (liste[i].compareTo(aktuell)) == 1) {
				liste[j + 1] = liste[j];
				j--;
			}
			liste[j + 1] = aktuell;
			bak++;*/
		//*************************************************
			// if(indeks >bak && indeks < finn(liste[i]))
			/**
			 * if(element.compareTo(liste[i])>0) {
			 * 
			 * break; } if(element.compareTo(liste[i])==0) {
			 * 
			 * } for(int k= i; k< liste.length-1;k++) { liste[k+1]=liste[k];
			 * liste[i]=element;
			 * 
			 * }bak++;
			 */
		}
		// *****************************************************
		/**
		 * 
		 * boolean funnet = false; for(int i = 0; i< bak && IKKE_FUNNET; i++) {
		 * if(liste[i]> element.getElement()) { funnet = true; for(int j = antall; j> i;
		 * j--) { liste[j] = liste[j-1]; } liste[i]=element;
		 * 
		 * // ...Fyll ut int i = 0;
		 * 
		 * while(i< bak && element.compareTo(liste[i]) > 0 ) { i++; } int j = bak;
		 * while(i < j) { liste[j]=liste[i]; j--; } element = liste[i];
		 */
	

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
	}

	/**
	 * int i = 0; boolean resultat = false; if(!erTom()) { while(i < bak &&
	 * element.compareTo(liste[i]) > 0) { i++; } if(i < bak &&
	 * element.compareTo(liste[i]) == 0) { resultat = true; } }return resultat;
	 */

	@Override
	public T fjern(T element) {
		
		int index = finn(element);
		
		if(index != -1) {
			bak--;
			//Flytter alle elementer ett hakk nedover i listen
			for(int i = index; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
		}
		else {
			element = null;
		}
		return element;

		/**if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		int indeks = finn(element);

		if (indeks != IKKE_FUNNET) {
			resultat = liste[indeks];
			bak--;
			for (int i = indeks; i < bak; i++) {
				liste[i] = liste[i + 1];
			}
			// liste[bak]=null;
		}
		return resultat;*/

		// ...Fyll ut
		/**
		 * if(erTom()) throw new EmptyCollectionException("ordnet liste"); boolean
		 * funnet = false; T resultat = null;
		 * 
		 * for(int i = 0; (i < bak && !funnet);i++) { if(liste[i].equals(element)) {
		 * resultat = liste[i]; liste[i] = liste[bak-1]; //tab[antall-1] = null; bak--;
		 * funnet = true;
		 * 
		 * } }return resultat;
		 */

		// **************************************************************

		/**
		 * LinearNode<T> forrige=null, denne=foerste; while(denne != null &&
		 * element.compareTo(denne.getElement()) > 0) { forrige = denne; denne =
		 * denne.getNeste(); } if(denne != null && element.equals(denne.getElement())) {
		 * antall--; svar = denne.getElement(); if(forrige == null) { foerste =
		 * foerste.getNeste(); if(foerste==null) { siste = null; }else {
		 * forrige.setNeste(denne.getNeste()); if(denne==siste) { siste = forrige; } }
		 * }return svar;
		 */
	}

	// *******************************************************************************
	/**
	 * int indks = finn(element);
	 * 
	 * if(indeks != IKKE_FUNNET) { resultat = liste[indeks]; bak--; // skifter
	 * elementene etter det vi fjernet en plass opp for(int i = indeks; i < bak;
	 * i++) { liste[i] = liste[i + 1];
	 * 
	 * } liste[bak] = null; }return resultat; return element;
	 */

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		// ...Fyll ut
		// int i = 0, resultat = -1;
		if (!erTom()) {
			while(resultat == -1 && i < bak) {
				if(liste[i].equals(el)) {
					resultat = i;
				}
				else {
					i++;
				}
		}}

		return resultat;
	}

	public String toString() {
		String resultat = "";

		for (int i = 0; i < bak; i++) {
			resultat = resultat + liste[i].toString() + "\n";
		}
		return resultat;
	}

	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Comparable[liste.length * 2]);

		for (int i = 0; i < liste.length; i++) {
			hjelpeTabell[i] = liste[i];
		}

		liste = hjelpeTabell;
	}

}// class
