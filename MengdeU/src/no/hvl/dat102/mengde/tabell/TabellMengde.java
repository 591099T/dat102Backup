package no.hvl.dat102.mengde.tabell;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;


public class TabellMengde<T> implements MengdeADT<T> {
	// ADT-en Mengde implementert som tabell
	//
	private final static Random tilf = new Random();
	private final static int STDK = 100;
	private int antall;
	private T[] tab;

	public TabellMengde() {
		this(STDK);
	}

	public TabellMengde(int start) {
		antall = 0;
		tab = (T[]) (new Object[start]);
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == tab.length) {
				utvidKapasitet();
			}
			tab[antall] = element;
			antall++;
		}
	}
	
	@Override
	public void leggTilAlle(MengdeADT<T> m2) {
		Iterator<T> teller = m2.iterator();
		while (teller.hasNext())
			leggTil(teller.next());
	}

	private void utvidKapasitet() {
		T[] hjelpetabell = (T[]) (new Object[2 * tab.length]);
		for (int i = 0; i < tab.length; i++) {
			hjelpetabell[i] = tab[i];
		}
		tab = hjelpetabell;
	}

	@Override
	public T fjernTilfeldig() {
		if (erTom())
			throw new EmptyCollectionException("mengde");

		T svar = null;
		int indeks = tilf.nextInt(antall);
		svar = tab[indeks];
		tab[indeks] = tab[antall - 1];
		tab[antall-1]= null;
		antall--;

		return svar;
	}

	@Override
	public T fjern(T element) {
	
		// S�ker etter og fjerner element. Returnerer null-ref ved ikke-funn

		if (erTom())
			throw new EmptyCollectionException("mengde");

		
		T svar = null;
		for(int i = 0; (i < antall && svar == null);i++) {
			if(tab[i].equals(element)) {
				svar = tab[i];
				for(int j = i; j<antall-1;i++) {
					tab[j] = tab[j+1];
				}antall--;
				
				//tab[antall-1] = null;
			
			
				
			}
		}
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		boolean funnet = false;
		for (int i = 0; (i < antall) && (!funnet); i++) {
			if (tab[i].equals(element)) {
				funnet = true;
			}
		}
		return (funnet);
	}
	
	/*
	 * N�r vi overkj�rer (override) equals- meteoden er det anbefalt at vi ogs�
	 * overkj�rer hascode-metoden da en del biblioterker burker hascode sammen med
	 * equals. Vi kommer tilbake til forklaring og bruk av hascode senere i faget.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + antall;
		result = prime * result + Arrays.deepHashCode(tab);
		return result;
	}

	@Override
	public boolean equals(Object m2) {
		//TODO
		boolean likeMengder = true;
		T element;	
		 if (this == m2) {
			return true;
		}
		if (m2 == null) {
			return false;
		}
		if (getClass() != m2.getClass()) {
			return false;
		}	
		MengdeADT<T> m3 = (TabellMengde<T>) m2;
		if (this.antall != m3.antall()) {
			likeMengder = false;
		} else {
			Iterator<T> teller = m3.iterator();

			while (teller.hasNext() && likeMengder) {
				element = teller.next();
				if (!this.inneholder(element)) {
					likeMengder = false;
				}
			}
		} return likeMengder;
	}

	

	/*
	 * Denne versjonen av unionen er lite effektiv
	 * 
	 * @Override public MengdeADT<T> union(MengdeADT<T> m2) { 
	 * TabellMengde<T> begge = new TabellMengde<T>(); 
	 * for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); 
	 * } 
	 * Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { 
	 * begge.leggTil(teller.next()); 
	 * } 
	 * return(MengdeADT<T>)begge; 
	 * }
	 */
	@Override

	public MengdeADT<T> union(MengdeADT<T> m2) { // fylt ut
		//TODO - Lage en mer effektiv kode
		MengdeADT<T> begge = new TabellMengde<T>();
		for (int i=0; i<antall; i++) {
			((TabellMengde<T>) begge).settInn(tab[i]);
		}
		Iterator<T> p = m2.iterator();
		while(p.hasNext()) {
			begge.leggTil(p.next());
		}
		/*
		 * ...for (int i = 0; i < antall; i++) {
	 * begge.leggTil(tab[i]); } Iterator<T> teller = m2.oppramser();
	 * 
	 * while (teller.hasNext()) { begge.leggTil(teller.next()); } return
	 * (MengdeADT<T>)begge; }
		 * 
		 */
		return begge;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> m2) { // Fylt ut
		MengdeADT<T> snittM = new TabellMengde<T>();
	
		Iterator<T> m1 = iterator();
		Iterator<T> p = m2.iterator();
		while (p.hasNext()) {
			((TabellMengde<T>) snittM).settInn(m1.next());
		}
		while(p.hasNext()) {
			((TabellMengde<T>) snittM).settInn(p.next());
		}
		
		
	/**	for (int i=0; i<antall;i++) {
		 	if(m2.inneholder(tab[i])){
		 	snittM.settInn(tab[i]);
		 		
		 }
		}*/
		
		 
		return snittM;
	}

	@Override
	public MengdeADT<T> differens(MengdeADT<T> m2) {  // fylt ut
		
		MengdeADT<T> differensM = new TabellMengde<T>();
		Iterator<T> p = this.iterator();
		T element;
		while(p.hasNext()) {
			element = p.next();
			if(!differensM.inneholder(element)) {
				((TabellMengde<T>) differensM).settInn(element);
			}
		}
		/*
		 * Map<Integer, Integer> teller = new HashMap<>();
		 * for(int value : m2) {
		 * 	int aktuell = teller.
		 * }
		 * 
		 * if (!m2.inneholder(element)) ((TabellMengde<T>) differensM).settInn(element);
		 */
		
	/**	for(int i = 0; i<antall; i++) {
			if(!m2.inneholder(tab[i])) {
				differensM.leggTil(tab[i]);
			}
		}
		if(union(m2) == snitt(m2)) {
			break;
		}
		else if(union(m2) != snitt(m2)) {
			while(snitt(m2) != null && tab[m2].inneholder(m2)) {
				
			}
			differensM = union(m2).fjern(snitt(m2));
		}*/
		
		

		return differensM;
	}

	@Override
	public boolean undermengde(MengdeADT<T> m2) {  // fylt ut
		boolean erUnderMengde = false;
		for(int i = 0; i<antall && erUnderMengde == false;i++) {
			if(tab[i].equals(m2)) {
				erUnderMengde = true;
			}
		}
		return erUnderMengde;
	}

	
	
	@Override
	public Iterator<T> iterator() {
		return new TabellIterator<T>(tab, antall);
	}

	private void settInn(T element) {
		if (antall == tab.length) {
			utvidKapasitet();
		}
		tab[antall] = element;
		antall++;
	}
	
	@Override
	public String toString(){// For klassen
		
	
		String resultat = " ";
		
		for(int i =0; i <= antall; i++ ) {
			resultat += tab[i].toString() + "/t";
			antall--;
		}
		return resultat;
		}

	

}// class
