package no.hvl.dat102.MengdeADTTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class MengdeADTTest {
	
	
	private TabellMengde object;
	
	// test data
	private Object e0 = 1;
	private Object e1 = 2;
	private Object e2 = 3;
	private Object e3 = 4;
	private Object e4 = 5;
	private Object e5 = 6;
	
	protected abstract MengdeADT reset();

	/**
	 * Hent en ny stabel for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		object = reset();
	}

	/**
	 * Test på at en ny stabel er tom.
	 */
	@Test
	public void nyStabelErTom() {
		assertTrue(object.erTom());
	}
	
	
	
	
}
