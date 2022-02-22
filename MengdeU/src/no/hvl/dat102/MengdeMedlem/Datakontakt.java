package no.hvl.dat102.MengdeMedlem;

import java.util.Arrays;



public class Datakontakt extends Medlem{
	
	private Medlem[] medlemstabell;
	private int antallMedlemmer;
	private int startnr = 100;
	
	public Datakontakt(Medlem[] medlem, int antall) {
		
		medlemstabell = new Medlem[startnr];
		medlemstabell = medlem;
		antallMedlemmer = antall;
		
	}
	
	public void leggTilMedlem (Medlem person) {
		
		boolean laTil = false;
		for (int i = 0; i<medlemstabell.length; i++){
			if(medlemstabell[i] == null || medlemstabell[i].equals(person)) {
				medlemstabell[i] = person;
				laTil = true;
				break;
			}
		} 
		if (!laTil) {
			utvid();
			leggTilMedlem(person);
		}
	}
	private void utvid() {
		Medlem[] utvid = new Medlem[medlemstabell.length*2];
		for (int i = 0; i<medlemstabell.length; i++) {
			utvid[i] = medlemstabell[i];
		}
		medlemstabell = utvid;
	}
	
	public boolean erTom() {
		return (antallMedlemmer == 0);
	}
	
	
	public Medlem finnMedlemsIndeks (String medlemsnavn) {
		/**Medlem[] indeks = new Medlem[0];
		for (Medlem index : medlemstabell) {
			if (index != null && index.getNavn().contains(medlemsnavn)) {
				indeks = Arrays.copyOf(indeks, indeks.length+1);
				indeks[indeks.length-1] = index;
			}else {
				indeks = -1;
			}
		}
		return indeks; */
		//*************************************************
		Medlem indeks = null;
		for (int i = 0; i<medlemstabell.length; i++) {
			if(medlemstabell[i] != null && medlemstabell[i].getNavn() == medlemsnavn) {
				indeks= medlemstabell[i];
			}else {
				
				indeks= medlemstabell[-1];
			}
		}return indeks;
	}
	
	public Medlem finnPartnerFor (String medlemsnavn) {
		Medlem indeks = null;
		Medlem indeks2 = null;
		for (int i = 0; i<medlemstabell.length; i++) {
			if(medlemstabell[i].getStatusIndeks()!= -1 && medlemstabell[i].getNavn() == medlemsnavn) {
				indeks= medlemstabell[i];
				for(int j = 0; j< medlemstabell.length;j++) {
					if() {
						
					}
				}
				medlemstabell[passerTil(indeks)].setStatusIndeks();
				boolean medlem2 = passerTil(indeks);
				medlemstabell[i].setStatusIndeks();
			}else {
				
				indeks= medlemstabell[-1];
			}
		}return indeks;
	}
	
	public void tilbakesillStatusIndeks (String medlemsnavn) {
		
		for(int i = 0;i< medlemstabell.length; i++ ) {
			if(medlemstabell[i].getStatusIndeks() != -1 && medlemstabell[i].getNavn() == medlemsnavn ) {
				
				medlemstabell[i].setStatusIndeks(-1);
				finnPartnerFor(medlemsnavn).setStatusIndeks(-1);
				medlemstabell[i].setStatusIndeks(-1);
			
			}
		}
		
		
	}
	/**private int finn() {
		int i = 0, resultat = -1;
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
	} */

}
