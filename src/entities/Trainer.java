package entities;

import java.util.Objects;

public class Trainer extends Person {
	
	private int erfahrung;
	
	public Trainer(String name, int alter, int erfahrung) {
		super(name, alter);
		this.setErfahrung(erfahrung);
	}

	public int getErfahrung() {
		return erfahrung;
	}

	public void setErfahrung(int erfahrung) {
		this.erfahrung = erfahrung;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		
		if (obj instanceof Trainer) {
			Trainer tr = (Trainer) obj;
			if (this.getName().equals(tr.getName())
					&& this.getAlter() == tr.getAlter()
					&& this.getErfahrung() == tr.getErfahrung())
				return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), this.erfahrung);
	}
	
	@Override
	public String toString() {
		return "Trainer: " + this.getName() 
		+ " Alter: " + this.getAlter() 
		+ " Erfahrung: " + this.getErfahrung();
	}
}
