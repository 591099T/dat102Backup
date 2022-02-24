package no.hvl.dat102.KjedetMengde;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.MengdeADT.MengdeADTTest;
import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class KjedetMengdeTest extends MengdeADTTest {
	public KjedetMengde<Integer> reset() {
		return new KjedetMengde<Integer>();
	}
	
}
