package entities;

import java.util.Random;

public class Torwart extends Spieler {

	private int reaktion;
	
	public Torwart(String name, int alter, int torschuss, int motivation, int staerke, int reaktion) {
		super(name, alter, torschuss, motivation, staerke);
		this.setReaktion(reaktion);
	}

	public int getReaktion() {
		return reaktion;
	}

	public void setReaktion(int reaktion) {
		this.reaktion = reaktion;
	}
	
	public boolean haeltDenSchuss(int schuss) {
		// +-1 ist hier die Varianz
		Random r = new Random();
		
		int ret = Math.max(1, Math.min(10, reaktion + r.nextInt(3)-1));
		
		if (ret>=schuss)
			return true; //gehalten
		else
			return false; // TOR!!!
	}
	
}
