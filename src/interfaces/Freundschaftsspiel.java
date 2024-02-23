package interfaces;

import entities.Mannschaft;

public interface Freundschaftsspiel {

	Mannschaft getHeimMannschaft();
	Mannschaft getGastMannschaft();
	int getPunkteHeim();
	int getPunkteGast();
	
	String getErgebnisText();
}
