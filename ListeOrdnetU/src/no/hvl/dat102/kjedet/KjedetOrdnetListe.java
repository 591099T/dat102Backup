package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.OrdnetListeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.mengde.kjedet.LinearNode;

/**
 * 
 * @param <T> elementypen
 */
public class KjedetOrdnetListe<T extends Comparable<T>> implements OrdnetListeADT<T> {
	private int antall;
	private LinearNode<T> foerste, siste;

	/**
	 * Lager en ny tom liste.
	 */
	public KjedetOrdnetListe() {
		antall = 0;
		foerste = null;
		siste = null;
	}

	@Override
	public T fjernFoerste() {// ...Fyllt ut
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = null;

		resultat = foerste.getElement();
		foerste = foerste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T fjernSiste() {// ...Fyll ut
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		/**
		 * LinearNode<T> node = foerste; LinearNode<T> prev = null; for (
		 * node.getNeste() != null; prev = node, node = node.getNeste());
		 */
		// ***************************
		T resultat = null;

		resultat = siste.getElement();
		siste = siste.getNeste();
		antall--;
		return resultat;
	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");
		T svar = foerste.getElement();

		return svar;
	}

	@Override
	public T siste() {
		if (erTom())
			throw new EmptyCollectionException("ordnet liste");

		T resultat = siste.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return antall == 0;
	}

	@Override
	public int antall() {
		return antall;
	}

	@Override
	public void leggTil(T element) {

		if (!(inneholder(element))) {
			LinearNode<T> nyNode = new LinearNode<T>(element);
			LinearNode<T> aktuell = foerste;

			while (element.compareTo(aktuell.getElement()) > 0) {
				aktuell = aktuell.getNeste();

			}
			nyNode.setNeste(aktuell);
			aktuell = nyNode;
			antall++;
		}
		/**
		 * LinearNode<T> nyNode = new LinearNode<T>(element); LinearNode<T> aktuell =
		 * foerste.getNeste(); while ((element.compareTo(aktuell.getElement()) > 0)) {
		 * aktuell = aktuell.getNeste(); } nyNode = aktuell.getNeste(); aktuell =
		 * nyNode; boolean funnet = false; for(int i = 0; i< antall && !funnet; i++) {
		 * if(liste[i]> element.getElement()) { funnet = true; for(int j = antall; j> i;
		 * j--) { liste[j] = liste[j-1]; } liste[i]=element; antall++; } }
		 */

		/**
		 * if (!(inneholder(element))) { LinearNode<T> nyNode = new
		 * LinearNode<T>(element); LinearNode<T> aktuell = foerste.getNeste();
		 * while(element.compareTo(aktuell.getElement()) >0) { aktuell=
		 * aktuell.getNeste();
		 * 
		 * } nyNode.setNeste(aktuell); aktuell = node; antall++; }
		 */

		/**
		 * int i = 0; if(i < siste && element.compareTo()) { i++; } LinearNode<T> nyNode
		 * = new LinearNode<T>(element); nyNode.setNeste(foerste); foerste = nyNode;
		 * antall++;
		 */
	}

	@Override
	public T fjern(T element) {
		T svar = null;
		LinearNode<T> forrige = null, denne = foerste;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			forrige = denne;
			denne = denne.getNeste();
		}
		if (denne != null && element.equals(denne.getElement())) { // funnet
			antall--;
			svar = denne.getElement();
			if (forrige == null) { // Første element
				foerste = foerste.getNeste();
				if (foerste == null) { // Tom liste
					siste = null;
				}
			} else { // Inni listen eller bak
				forrige.setNeste(denne.getNeste());
				if (denne == siste) { // bak
					siste = forrige;
				}
			}
		} // ikke-funn
		return svar;
	}

	@Override
	public boolean inneholder(T element) {
		LinearNode<T> denne = foerste;
		boolean resultat = false;
		while (denne != null && element.compareTo(denne.getElement()) > 0) {
			denne = denne.getNeste();
		}
		if (denne != null) {
			if (element.equals(denne.getElement())) {
				resultat = true;
			}
		} // ikke-funn
		return resultat;
	}

}// class
