package no.hvl.dat102.TabellMengde;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hvl.dat102.MengdeADT.MengdeADTTest;


public  class TabellMengdeTest extends MengdeADTTest{
	public TabellMengde<Integer> reset() {
		return new TabellMengde<Integer>();
	}
	
}



