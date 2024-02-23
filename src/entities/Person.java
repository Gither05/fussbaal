package entities;

import java.security.InvalidParameterException;

public class Person {
	
	private String name;
	private int alter;
	
	public Person(String name, int alter) {
		this.setName(name);
		this.setAlter(alter);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) throws InvalidParameterException {
		if (alter < 1)
			throw new InvalidParameterException("Alter darf nicht negativ oder 0 sein.");
		
		this.alter = alter;
	}
	
	

}
