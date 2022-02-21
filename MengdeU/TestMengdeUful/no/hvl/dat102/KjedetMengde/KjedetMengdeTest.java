package no.hvl.dat102.KjedetMengde;


import no.hvl.dat102.MengdeADTTest.MengdeADTTest;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KjedetMengdeTest extends MengdeADTTest{
	
	@Override
	protected MengdeADT<T> reset() {
		return new KjedetMengde<T>();
	}	
}
