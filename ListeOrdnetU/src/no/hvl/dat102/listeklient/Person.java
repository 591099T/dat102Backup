package no.hvl.dat102.listeklient;

public class Person implements Comparable<Person> {

	private String fornavn;
	private String etternavn;
	private int foedselsaar;

	// Konstruktører

	public Person() {
		this("", "", 0);

	}

	public Person(String fornavn, String etternavn, int foedselsaar) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.foedselsaar = foedselsaar;

	}

	public void setFoedselsaar(int foedselsaar) {
		this.foedselsaar = foedselsaar;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	int getFoedselsaar() {
		return foedselsaar;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public String toString() {
		return (foedselsaar + "\t" + etternavn + ", " + fornavn);
	}

	public int compareTo(Person denAndrePersonen) {
		int resultat = 0;
		int f1 = this.foedselsaar;
		int f2 = denAndrePersonen.getFoedselsaar();
		String etternavn1 = this.etternavn;
		String etternavn2 = denAndrePersonen.getEtternavn();
		String fornavn1 = this.fornavn;
		String fornavn2 = denAndrePersonen.getFornavn();
		switch(denAndrePersonen) {
		case denAndrePersonen.
		}
		
		if (f1 > f2) {
			resultat = -resultat;
		}
		if (f1 < f2) {
			resultat = resultat+1;
		}
		if(f1 == f2) {
			if(etternavn1 > etternavn2) {
				resultat = -resultat;
			}
			if(etternavn1 < etternavn2) {
				resultat = +resultat;
			}
			if(etternavn1 == etternavn2) {
				while(fornavn)
				if(fornavn1 > fornavn2) {
					resultat = -resultat;
				}
				if(fornavn1 < fornavn2) {
					resultat = +resultat;
				}
				if(fornavn1 == fornavn2) {
					;
				}
			}
		}else {
			throw outof
		}
		
		
		//... Fyll ut
		//Kall på compareTo i Stringklassen
		return resultat;
	}//

}// class