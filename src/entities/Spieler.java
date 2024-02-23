package entities;

import java.util.Random;

public class Spieler extends Person {
	
	private int torschuss;
	private int motivation;
	private int tore;
	private int staerke;
	
	public Spieler(String name, int alter, int torschuss, int motivation, int staerke) {
		super(name, alter);
		this.setTorschuss(torschuss);
		this.setMotivation(motivation);
		this.setStaerke(staerke);
		this.tore = 0;
	}
	
	public int getTorschuss() {
		return torschuss;
	}
	public void setTorschuss(int torschuss) {
		this.torschuss = torschuss;
	}
	public int getMotivation() {
		return motivation;
	}
	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}
	public int getTore() {
		return tore;
	}
	private void setTore(int tore) {
		this.tore = tore;
	}
	public int getStaerke() {
		return staerke;
	}
	public void setStaerke(int staerke) {
		this.staerke = staerke;
	}
	
	public void addTor() {
		tore++;
	}
	
	public int schiesstAufsTor() {
		Random r = new Random();
		torschuss = Math.max(1, Math.min(10, torschuss - r.nextInt(3)));
		int ret = Math.max(1, Math.min(10, torschuss + r.nextInt(3)-1));
		return ret;
	}

}
