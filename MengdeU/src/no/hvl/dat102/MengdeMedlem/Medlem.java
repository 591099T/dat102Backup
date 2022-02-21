package no.hvl.dat102.MengdeMedlem;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {

		private String navn;
		private MengdeADT<Hobby> hobbyer;
		private int statusIndeks;
		//� Konstrukt�r
		
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
		
		
		passerTil(Medlem medlem2) {
			
		}
		//� Andre metoder
		}


