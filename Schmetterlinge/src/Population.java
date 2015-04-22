import java.util.*;

/**
 * Erzeugt eine ganze Schmetterlingspopulation
 * @author Joe Rilla
 */
public class Population {
	
	/**
	 * gesamte Schmetterlingspopulation
	 * family[0] = Mutter
	 * family[1] = Vater
	 * family[2 - ...] = Kinder
	 */
	private List<Butterfly> family;
	
	/**
	 * vom Lepidopterologe gesammelte Schmetterlinge
	 */
	private List<Butterfly> selection;
	
	/**
	 * Konstruktor, erzeugt Schmetterlingspopulation bei
	 * gegebenem Elternpaar
	 * @param mom Vater
	 * @param dad Mutter
	 */
	public Population(Butterfly mom, Butterfly dad) {
		
		// Familie initialisieren
		family = new ArrayList<Butterfly>();
		
		// Mutter auf "0" und Vater auf "1" ablegen
		family.add(mom);
		family.add(dad);
		
	}
	
	/**
	 * Kinder bekommen
	 * (geht nur, wenn schon Eltern in der Population sind)
	 */
	public void breed() {
		
		// einen Wuerfel erzeugen
		Wuerfel die = new Wuerfel(1000, 1000000);
				
		// entsprechend der gewuerfelten Zahl Kinder erzeugen
		die.wuerfeln();
		for (int i = 0; i < die.getAugen(); i++) {
			family.add(new Butterfly(family.get(0), family.get(1)));
		}
		
	}
	
	/**
	 * Gibt Groesse der Schmetteringlingspopulation aus
	 * @return Groesse der Population
	 */
	public int getPopulationSize() {
		return family.size();
	}
	
	/**
	 * Gibt Anzahl der gesammelten Schmetterlinge aus
	 * @return Anzahl der gesammelten Schmetterlinge 
	 */
	public int getSelectionSize() {
		return selection.size();
	}
	
	/**
	 * Gibt einen Schmetterling aus der Population zurueck
	 * @param position Position
	 * @return Schmetterling
	 */
	public Butterfly getButterfly(int position) {
		return family.get(position);
	}
	
	/**
	 * Gibt die gesamte Schmetterlingspopulation zurueck
	 * @return Schmetterlingspopulation
	 */
	public List<Butterfly> getPopulation() {
		return family;
	}
	
	/**
	 * Gibt alle gesammelten Schmetterlinge zurück
	 * @return gesammelte Schmetterlinge
	 */
	public List<Butterfly> getSelection() {
		return selection;
	}

	/**
	 * Sammle nur die Schmetterlinge mit einem best. Merkmal
	 * und kopiere diese in die Liste "selection"
	 * 
	 * [1] = Musterung: uni  
	 * [2] = Musterung: schwarz gepunktet
	 * [3] = Musterung: schwarz gestreift
	 * [4] = Fluegelfarbe: rot
	 * [5] = Fluegelfarbe: gelb
	 * [6] = Fluegelfarbe: gruen
	 * [7] = Fluegelfarbe: blau
	 * [8] = Fuehlerform: gerade
	 * [9] = Fuehlerform: gekruemmt
	 * 
	 * @param selector Merkmal
	 */
	public void catchButterflies(int selector) {
		
		// "selection" initialisieren
		selection = new ArrayList<Butterfly>();
		
		// Schmetterlinge fangen
		for (Butterfly i: family) {
			switch (selector) {
				case 1:
					if (i.getPattern() == 1) selection.add(i);
					break;
				case 2:
					if (i.getPattern() == 2) selection.add(i);
					break;
				case 3:
					if (i.getPattern() == 3) selection.add(i);
					break;
				case 4:
					if (i.getWingColor() == 1) selection.add(i);
					break;
				case 5:
					if (i.getWingColor() == 2) selection.add(i);
					break;
				case 6:
					if (i.getWingColor() == 3) selection.add(i);
					break;
				case 7:
					if (i.getWingColor() == 4) selection.add(i);
					break;
				case 8:
					if (i.getAntennaShape() == 1) selection.add(i);
					break;
				case 9:
					if (i.getAntennaShape() == 2) selection.add(i);
					break;
			}				
		}
		
	}
	
}