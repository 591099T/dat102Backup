package no.hvl.dat102.MengdeMedlem;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {

	
	
		private String navn;
		private MengdeADT<Hobby> hobbyer;
		private int statusIndeks =-1;
		//… Konstruktør
		
		public Medlem() {
			
		}
		
		public Medlem (String navn, MengdeADT<Hobby> hobbyer, int statusIndeks) {
			this.navn = navn;
			this.hobbyer = hobbyer;
			this.statusIndeks = statusIndeks;
		}
		
		public String getNavn() {
			return navn;
		}
		public MengdeADT<Hobby> getHobbyer() {
			return hobbyer;
		}
		public int getStatusIndeks() {
			return statusIndeks;
		}
		
		public void setNavn(String navn) {
			this.navn = navn;
		}
		public void setHobbyer(MengdeADT<Hobby> hobbyer) {
			this.hobbyer = hobbyer;
		}
		public void setStatusIndeks(int statusIndeks) {
			this.statusIndeks = statusIndeks;
		}
		
		
		public  boolean  passerTil(Medlem medlem2) {
			//Har dei nøyaktig samme hobbyane. 
			//(Like mengder)
			boolean passer= false;
			MengdeADT<Hobby> midler = this.getHobbyer();
			MengdeADT<Hobby> midler2 = medlem2.getHobbyer();
			if (midler == midler2) {
				passer= true;
			}
			if (midler2 == null ) {
				passer= false;
			}
			if (midler.getClass() != midler2.getClass()) {
				passer= false;
			}return passer;
		}
		
		//… Andre metoder
		
		@Override
		public String toString() {
			return "Medlem [navn=" + navn + ", hobbyer=" + hobbyer + ", statusIndeks="
					+ statusIndeks  + "]";
		
		}
		  
		}


