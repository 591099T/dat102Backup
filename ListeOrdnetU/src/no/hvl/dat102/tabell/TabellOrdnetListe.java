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
		resultat = liste[bak-1];
		bak--;
	/**	for (int i = 0; i <bak;i++) {
			liste[bak] = liste[i+1];
		}*/
		
		return resultat;
	}

	@Override
	public T fjernFoerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;
		// ... Fyll ut
		resultat = liste[0];
		bak--;
		for (int i = 0; 1<bak; i++) {
			liste[i] = liste[i+1];
		}
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = liste[0];
		return resultat;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		
		T resultat = liste[bak-1];
		

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
		
		int i;
		for(i=0; i<liste.length-1;i++) {
			if(liste[i]>element.getElement()) {
				break;
			}
			for(int k= i; k< liste.length-1;k++) {
				liste[k+1]=liste[k];
				liste[i]=element;
				
			}
		}
		/**
		
		boolean funnet = false;
		for(int i = 0; i< bak && IKKE_FUNNET; i++) {
			if(liste[i]> element.getElement()) {
				funnet = true;
				for(int j = antall; j> i; j--) {
					liste[j] = liste[j-1];
				}
				liste[i]=element;

		// ...Fyll ut
		int i = 0;
		
		while(i< bak && element.compareTo(liste[i]) > 0 ) {
			i++;
		}
		int j = bak;
		while(i < j) {
			liste[j]=liste[i];
			j--;
		}
		element = liste[i];
			*/
	}

	@Override
	public boolean inneholder(T element) {
		return (finn(element) != IKKE_FUNNET);
		}
		
		
	/**	int i = 0;
		boolean resultat = false;
		if(!erTom()) {
			while(i < bak && element.compareTo(liste[i]) > 0) {
				i++;
			}
			if(i < bak && element.compareTo(liste[i]) == 0) {
				resultat = true;
			}
		}return resultat;   */
	

	@Override
	public T fjern(T element) {
		
		
		 if(erTom())
			throw new EmptyCollectionException("ordnet liste");
			
			 T resultat = null;
			 int indeks = finn(element);
			 
			 if(indeks != IKKE_FUNNET) {
			 	resultat = liste[indeks];
			 	bak--;
			 	for(int i =indeks; i < bak; i++) {
			 		liste[i] = liste[i+1];
			 	}
			 	liste[bak]=null;
			 }
			 return resultat;
		
		
		
			// ...Fyll ut
				/**if(erTom())
					throw new EmptyCollectionException("ordnet liste");
				boolean funnet = false;
				T resultat = null;
				
				for(int i = 0; (i < bak && !funnet);i++) {
					if(liste[i].equals(element)) {
						resultat = liste[i];
						liste[i] = liste[bak-1];
						//tab[antall-1] = null;
						bak--;
						funnet = true;
						
					}    
				}return resultat; */
			 
		/**LinearNode<T> forrige=null, denne=foerste;
		while(denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if(denne != null && element.equals(denne.getElement())) {
			antall--;
			svar = denne.getElement();
			if(forrige == null) {
				foerste = foerste.getNeste();
				if(foerste==null) {
					siste = null;
				}else {
					forrige.setNeste(denne.getNeste());
					if(denne==siste) {
						siste = forrige;
					}
				}
			}return svar;*/
		}
		/**int indks = finn(element);
		
		if(indeks != IKKE_FUNNET) {
			resultat = liste[indeks];
			bak--;
			// skifter elementene etter det vi fjernet en plass opp 
			for(int i = indeks; i < bak; i++) {
				liste[i] = liste[i + 1];
				
			}
			liste[bak] = null;
		}return resultat;
		return element; */

	

	private int finn(T el) {
		int i = 0, resultat = IKKE_FUNNET;
		// ...Fyll ut
		//int i = 0, resultat = -1;
		if(!erTom()) {
			while  (i < bak && el.compareTo(liste[i]) > 0) {
				i++;
			}
			if (i < bak && el.compareTo(liste[i]) == 0) {
				resultat = i;
			}
		}
		
		
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
