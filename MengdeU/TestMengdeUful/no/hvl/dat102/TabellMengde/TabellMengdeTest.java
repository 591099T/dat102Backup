package no.hvl.dat102.TabellMengde;


import no.hvl.dat102.KjedetMengde.MengdeADT;
import no.hvl.dat102.KjedetMengde.T;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class TabellMengdeTest extends MengdeADT{
	
	@Override
	protected MengdeADT<T> reset() {
		return new TabellMengde<T>();
	}
}



