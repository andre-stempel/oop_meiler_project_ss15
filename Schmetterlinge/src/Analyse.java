import java.util.*;

/**
 * Führt statischtische Analysen mit der 
 * Schmetterlingspopulation durch
 * @author Joe Rilla
 */
public class Analyse {
	
	/**
	 * Analyseergebnisse
	 */
	private Integer[] results;
	
	/**
	 * Konstruktor
	 */
	public Analyse() {
		;
	}
	
	/**
	 * Gibt absolute Haeufigkeiten fuer alle Merkmale aus
	 * 
	 * [0] = Musterung: uni
	 * [1] = Musterung: schwarz gepunktet
	 * [2] = Mustering: gestreift
	 * [3] = Fluegelfarbe: rot
	 * [4] = Fluegelfarbe: gelb
	 * [5] = Fluegelfarbe: gruen
	 * [6] = Fluegelfarbe: blau 
	 * [7] = Fuehlerform: gerade 
	 * [8] = Fuehlerform: gekruemmt
	 * 
	 * @param butterflies Schmetterlinge
	 * @return Analyseergebnisse
	 */
	public Integer[] freqTotal(List<Butterfly> butterflies) {
		
		// Collection initialisieren
		results = new Integer[9];
		for (int i = 0; i < 9; i++) {
			results[i] = 0;
		}
		
		// Zaehlen
		for (Butterfly i: butterflies) {
			
			// Musterung
			switch (i.getPattern()) {
				case 1:
					results[0]++;
					break;
				case 2:
					results[1]++;
					break;
				case 3:
					results[2]++;
					break;
			}
			
			// Fluegelfarbe
			switch (i.getWingColor()) {
				case 1:
					results[3]++;
					break;
				case 2:
					results[4]++;
					break;
				case 3:
					results[5]++;
					break;
				case 4:
					results[6]++;
					break;
			}
			
			// Fuehlerform
			switch (i.getAntennaShape()) {
				case 1:
					results[7]++;
					break;
				case 2:
					results[8]++;
					break;
			}
		
		}
		
		// Liefert Ergebnis-Array zurueck
		return results;
		
	}
	
	/**
	 * Gibt abs. Haeufigkeiten fuer alle Merkmalskombinationen aus
	 * (Musterung x Fluegelfarbe x Fuehlerform)
	 * 
	 * [0]  uni 			  - rot   - gerade
	 * [1]  uni 			  - rot   - gekruemmt
	 * [2]  uni 			  - gelb  - gerade
	 * [3]  uni 			  - gelb  - gekruemmt
	 * [4]  uni 			  - gruen - gerade
	 * [5]  uni 			  - gruen - gekruemmt
	 * [6]  uni 			  - blau  - gerade
	 * [7]  uni 			  - blau  - gekruemmt
 	 * [8]  schwarz gepunktet - rot   - gerade
	 * [9]  schwarz gepunktet - rot   - gekruemmt
	 * [10] schwarz gepunktet - gelb  - gerade
	 * [11] schwarz gepunktet - gelb  - gekruemmt
	 * [12] schwarz gepunktet - gruen - gerade
	 * [13] schwarz gepunktet - gruen - gekruemmt
	 * [14] schwarz gepunktet - blau  - gerade
	 * [15] schwarz gepunktet - blau  - gekruemmt
 	 * [16] schwarz gestreift - rot   - gerade
	 * [17] schwarz gestreift - rot   - gekruemmt
	 * [18] schwarz gestreift - gelb  - gerade
	 * [19] schwarz gestreift - gelb  - gekruemmt
	 * [20] schwarz gestreift - gruen - gerade
	 * [21] schwarz gestreift - gruen - gekruemmt
	 * [22] schwarz gestreift - blau  - gerade
	 * [23] schwarz gestreift - blau  - gekruemmt

	 * @param butterflies Schmetterlinge
	 * @return Analyseergebnisse
	 */
	public Integer[] freqSelection(List<Butterfly> butterflies) {
		
		// Collection initialisieren
		results = new Integer[24];
		for (int i = 0; i < 24; i++) {
			results[i] = 0;
		}
		
		// Zaehlen
		for (Butterfly i: butterflies) {
			
			if (i.getPattern() == 1 && i.getWingColor() == 1 && i.getAntennaShape() == 1)
				results[0]++;
			if (i.getPattern() == 1 && i.getWingColor() == 1 && i.getAntennaShape() == 2)
				results[1]++;
			if (i.getPattern() == 1 && i.getWingColor() == 2 && i.getAntennaShape() == 1)
				results[2]++;
			if (i.getPattern() == 1 && i.getWingColor() == 2 && i.getAntennaShape() == 2)
				results[3]++;
			if (i.getPattern() == 1 && i.getWingColor() == 3 && i.getAntennaShape() == 1)
				results[4]++;
			if (i.getPattern() == 1 && i.getWingColor() == 3 && i.getAntennaShape() == 2)
				results[5]++;
			if (i.getPattern() == 1 && i.getWingColor() == 4 && i.getAntennaShape() == 1)
				results[6]++;
			if (i.getPattern() == 1 && i.getWingColor() == 4 && i.getAntennaShape() == 2)
				results[7]++;
			if (i.getPattern() == 2 && i.getWingColor() == 1 && i.getAntennaShape() == 1)
				results[8]++;
			if (i.getPattern() == 2 && i.getWingColor() == 1 && i.getAntennaShape() == 2)
				results[9]++;
			if (i.getPattern() == 2 && i.getWingColor() == 2 && i.getAntennaShape() == 1)
				results[10]++;
			if (i.getPattern() == 2 && i.getWingColor() == 2 && i.getAntennaShape() == 2)
				results[11]++;
			if (i.getPattern() == 2 && i.getWingColor() == 3 && i.getAntennaShape() == 1)
				results[12]++;
			if (i.getPattern() == 2 && i.getWingColor() == 3 && i.getAntennaShape() == 2)
				results[13]++;
			if (i.getPattern() == 2 && i.getWingColor() == 4 && i.getAntennaShape() == 1)
				results[14]++;
			if (i.getPattern() == 2 && i.getWingColor() == 4 && i.getAntennaShape() == 2)
				results[15]++;
			if (i.getPattern() == 3 && i.getWingColor() == 1 && i.getAntennaShape() == 1)
				results[16]++;
			if (i.getPattern() == 3 && i.getWingColor() == 1 && i.getAntennaShape() == 2)
				results[17]++;
			if (i.getPattern() == 3 && i.getWingColor() == 2 && i.getAntennaShape() == 1)
				results[18]++;
			if (i.getPattern() == 3 && i.getWingColor() == 2 && i.getAntennaShape() == 2)
				results[19]++;
			if (i.getPattern() == 3 && i.getWingColor() == 3 && i.getAntennaShape() == 1)
				results[20]++;
			if (i.getPattern() == 3 && i.getWingColor() == 3 && i.getAntennaShape() == 2)
				results[21]++;
			if (i.getPattern() == 3 && i.getWingColor() == 4 && i.getAntennaShape() == 1)
				results[22]++;
			if (i.getPattern() == 3 && i.getWingColor() == 4 && i.getAntennaShape() == 2)
				results[23]++;
			
		}
	
		return results;
		
	}
	
}