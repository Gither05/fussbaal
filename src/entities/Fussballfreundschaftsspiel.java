package entities;

import java.util.Random;

import interfaces.Freundschaftsspiel;

public class Fussballfreundschaftsspiel implements Freundschaftsspiel {
	
	private Mannschaft heim;
	private Mannschaft gast;
	private int toreHeim = 0;
	private int toreGast = 0;
	
	public Fussballfreundschaftsspiel(Mannschaft heim, Mannschaft gast) {
		this.setHeim(heim);
		this.setGast(gast);
	}

	public Mannschaft getHeim() {
		return heim;
	}

	public void setHeim(Mannschaft heim) {
		this.heim = heim;
	}

	public Mannschaft getGast() {
		return gast;
	}

	public void setGast(Mannschaft gast) {
		this.gast = gast;
	}

	public int getToreHeim() {
		return toreHeim;
	}

	public int getToreGast() {
		return toreGast;
	}

	@Override
	public Mannschaft getHeimMannschaft() {
		return heim;
	}

	@Override
	public Mannschaft getGastMannschaft() {
		return gast;
	}

	@Override
	public int getPunkteHeim() {
		return toreHeim;
	}

	@Override
	public int getPunkteGast() {
		return toreGast;
	}

	@Override
	public String getErgebnisText() {
		return "Das Freundschaftsspiel endete \n\n"+heim.getName()
				+" - "+gast.getName()+" "+toreHeim+":"
				+toreGast+".";
	}
	
	public void starteSpiel() {
		Random r = new Random();
		
		boolean spiellaeuft = true;
		int spieldauer = 90 + r.nextInt(5);
		int zeit = 0;
		int naechsteAktion = 0;
		
		while(spiellaeuft)
		{
			naechsteAktion = r.nextInt(15) + 1;
			
			if ((naechsteAktion+zeit > spieldauer)||(zeit > spieldauer))
			{
				spiellaeuft = false;
				break;
			}
				
			zeit += naechsteAktion;
			
			double staerke_heim = (heim.getStaerke()/2.0f) +
					((heim.getStaerke()/2.0f) * (heim.getMotivation()));
			double staerke_gast = (gast.getStaerke()/2.0f) +
					((gast.getStaerke()/2.0f) * (gast.getMotivation()));
			
			int abweichung = r.nextInt(2);
			if (staerke_heim > heim.getTrainer().getErfahrung())
				abweichung = -abweichung;
			staerke_heim = Math.max(1, Math.min(10, staerke_heim + abweichung));
			
			abweichung = r.nextInt(2);
			if (staerke_gast > gast.getTrainer().getErfahrung())
				abweichung = -abweichung;
			staerke_gast = Math.max(1, Math.min(10, staerke_gast + abweichung));
			
			int schuetze = r.nextInt(10);
			
			if ((r.nextInt((int)Math.round(staerke_heim+staerke_gast))-staerke_heim)<=0)
			{
				Spieler s = heim.getKader()[schuetze];
				Torwart t = gast.getTw();
				int torschuss = s.schiesstAufsTor();

				// haelt er den Schuss?
				boolean tor = !t.haeltDenSchuss(torschuss);
				
				System.out.println();
				System.out.println(zeit+".Minute: ");
				System.out.println(" Chance fuer "+heim.getName()+" ...");
				System.out.println(" "+s.getName()+" zieht ab");
				
				if (tor) {
					toreHeim++;
					s.addTor();
					System.out.println(" TOR!!! "+toreHeim+":"+
										toreGast+" "+s.getName()+"("+s.getTore()+")");
				} else 
				{
					System.out.println(" "+gast.getTw().getName() +" pariert glanzvoll.");
				}
			}
			else
			{
				Spieler s = gast.getKader()[schuetze];
				Torwart t = heim.getTw();
				int torschuss = s.schiesstAufsTor();

				// haelt er den Schuss?
				boolean tor = !t.haeltDenSchuss(torschuss);
				
				System.out.println();
				System.out.println(zeit+".Minute: ");
				System.out.println(" Chance fuer "+gast.getName()+" ...");
				System.out.println(" "+s.getName()+" zieht ab");
				
				if (tor) {
					toreGast++;
					s.addTor();
					System.out.println(" TOR!!! "+toreHeim+":"+
										toreGast+" "+s.getName()+"("+s.getTore()+")");
				} else 
				{
					System.out.println(" "+heim.getTw().getName() +" pariert glanzvoll.");
				}
			}
			
		}
	}

}
