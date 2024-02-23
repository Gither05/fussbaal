package entities;

public class Mannschaft {
	
	private String name = null;
	private Spieler[] kader = new Spieler[10];
	private Torwart tw = null;
	private Trainer trainer = null;
	
	public Mannschaft(String name, Spieler[] kader, Torwart tw, Trainer tr) {
		this.setName(name);
		this.setKader(kader);
		this.setTorwart(tw);
		this.setTrainer(tr);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Spieler[] getKader() {
		return kader;
	}
	public void setKader(Spieler[] kader) {
		this.kader = kader;
	}
	public Torwart getTw() {
		return tw;
	}
	public void setTorwart(Torwart tw) {
		this.tw = tw;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	public double getStaerke() {
		int summe = 0;
		
		for (Spieler spieler : kader) {
			summe += spieler.getStaerke();
		}
		
		summe += tw.getStaerke();
		
		return (double)summe/11;
	}
	
	public double getMotivation() {
		int summe = 0;
		
		for (Spieler spieler : kader) {
			summe += spieler.getMotivation();
		}
		
		summe += tw.getMotivation();
		
		return (double)summe/11;
	}
}
