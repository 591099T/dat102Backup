package no.hvl.dat102;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.kjedet.KjedetKoe;


public class KoeADTTest {

	// Referanse til stabel
		private KoeADT<Character> koe;


		// Testdata
		private Character e0 = 1;
		private Character e1 = 2;
		private Character e2 = 3;
		private Character e3 = 4;
		private Character e4 = 5;

		/**
		 * Test på at en stabel med noen elementer ikke er tom.
		 */
		@Test
		public final void erIkkeTom() {
			koe.innKoe(e0);
			koe.innKoe(e1);
			assertFalse(koe.erTom());
		}

		/**
		 * Test på at en ny stabel er tom.
		 */
		@Test
		public final void nyStabelErTom() {
			assertTrue(koe.erTom());
		}

		/**
		 * Forsøk på pop av en tom stabel skal gi "underflow excepton" *
		 *
		 */
		@Test
		public final void popFromEmptyIsUnderflowed() {
			Assertions.assertThrows(EmptyCollectionException.class, () -> {
				koe.utKoe();
			});
		}

		/**
		 * Test på push and pop.
		 */
		@Test
		public final void pushOgPop() {

			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.innKoe(e2);
			koe.innKoe(e3);

			try {
				assertEquals(e3, koe.utKoe());
				assertEquals(e2, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e0, koe.utKoe());
			} catch (EmptyCollectionException e) {
				fail("pop feilet uventet " + e.getMessage());
			}
		}

		/**
		 * Test på push og pop med duplikate verdier.
		 */
		@Test
		public final void pushOgPopMedDuplikater() {

			koe.innKoe(e0);
			koe.innKoe(e1);
			koe.innKoe(e1);
			koe.innKoe(e2);

			try {
				assertEquals(e2, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e1, koe.utKoe());
				assertEquals(e0, koe.utKoe());
			} catch (EmptyCollectionException e) {
				fail("pop feilet uventet " + e.getMessage());
			}
		}

		/**
		 * Test på at en stabel med null elementer er tom.
		 */
		@Test
		public final void innUtKoeErTom() {
			try {
				koe.innKoe(e0);
				koe.utKoe();
				assertTrue(koe.erTom());

			} catch (EmptyCollectionException e) {
				fail("push eller pop feilet uventet " + e.getMessage());
			}
		}

		/**
		 * Testing på peek.
		 */
		@Test
		public final void innUtInnInnUtFoerste() {
			try {
				koe.innKoe(e2);
				koe.utKoe();
				koe.innKoe(e3);
				koe.innKoe(e4);
				koe.utKoe();
				assertEquals(e3, koe.foerste());

			} catch (EmptyCollectionException e) {
				fail("pop eller peek feilet uventet " + e.getMessage());
			}
		}



		/**
		 * Hent en ny stabel for hver test.
		 */
		@BeforeEach
		public final void setup() {
			koe = new KjedetKoe<>();
		}
}
