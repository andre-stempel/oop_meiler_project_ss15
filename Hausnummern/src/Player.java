
public class Player {
	
	/**
	 * Satz Wuerfel
	 */
	private Wuerfel[] wuerfel;
	
	/**
	 * Hausnummer
	 */
	private int houseNumber;
	
	/**
	 * Gesamtsumme
	 */
	private int totalSum;

	/**
	 * Konstruktor
	 */
	public Player() {
		
		// satz mit drei wuerfeln erzeugen
		wuerfel = new Wuerfel[3];
		for (int i = 0; i < 3; i++) {
			wuerfel[i] = new Wuerfel(0, 9);
		}
		
		// hausnummer initialisieren
		houseNumber = 0;
		
		// total sum initialisieren
		totalSum = 0;
		
	}
	
	/**
	 * Addiere den Wert auf die aktuelle Hausnummer
	 * @param toAdd Wert
	 */
	public void addToHouseNumber( int toAdd ) {
		houseNumber += toAdd;
	}
	
	/**
	 * Setze Hausnummer wieder auf "0" zurueck
	 */
	public void resetHouseNumber() {
		houseNumber = 0;
	}
	
	/**
	 * Gib Hausnummer aus
	 * @return Hausnummer
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Mit dem ganzen Satz einmal wuerfeln
	 */
	public void setWuerfel() {
		for (int i = 0; i < 3; i++) {
			wuerfel[i].wuerfeln();
		}
		
	}

	/**
	 * Lies Augenzahl des i-ten Wuerfels aus 
	 * @param i Stelle im Array
	 * @return Augenzahl
	 */
	public int getWuerfel(int i) {
		return wuerfel[i].getAugen();
	}

	/**
	 * Addiere den Wert auf die Gesamtsumme
	 * @param toAdd Wert
	 */
	public void addToTotalSum( int toAdd ) {
		totalSum += toAdd;
	}
	
	/**
	 * Liest Gesamtsumme aus
	 * @return Gesamtsumme
	 */
	public int getTotalSum() {
		return totalSum;
	}

}
