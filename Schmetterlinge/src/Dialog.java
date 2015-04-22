import Tools.IO.*;

/**
 * Klasse fuer Ein- und Ausgabe
 * @author Joe Rilla
 */
public class Dialog {
	
	/**
	 * Konstruktor
	 */
	public Dialog() {
		;
	}
	
	/**
	 * Dialog zur Erzeugung von Schmetterlingen
	 * @param parent Mutter oder Vater
	 * @return Schmetterling
	 */
	public Butterfly createParent(String parent) {
		int pattern, wingColor, antennaShape;
		
		System.out.println();
		System.out.println("Erzeuge " + parent + ":");
		
		// Musterung
		System.out.println("  " + "Musterung:\n" +
				"    " + "[1] uni\n" +
				"    " + "[2] schwarz gepunktet\n" +
				"    " + "[3] schwarz gestreift"
		);
		pattern = IOTools.readInteger("    " + "Eingabe: ");
		System.out.println();
		
		// Fluegelfarbe
		System.out.println("  " + "Fluegelfarbe:\n" +
				"    " + "[1] rot\n" +
				"    " + "[2] gelb\n" +
				"    " + "[3] gruen\n" +
				"    " + "[4] blau"
		);
		wingColor = IOTools.readInteger("    " + "Eingabe: ");
		System.out.println();
		
		//Fuehlerform
		System.out.println("  " + "Fuehlerform:\n" +
				"    " + "[1] gerade\n" +
				"    " + "[2] gekruemmt"
		);
		antennaShape = IOTools.readInteger("    " + "Eingabe: ");
		System.out.println();
		
		// Schmetterling erzeugen
		return new Butterfly(pattern, wingColor, antennaShape);
		
	}
	
	/**
	 * Gib Haeufigkeiten der Merkmale aus
	 * @param results Haeufigkeiten der Merkmale
	 * @param populationSize Anzahl Schmetterlinge
	 */
	public void printFreqsTotal(Integer[] results, int populationSize) {
		
		// Berechne relative Haeufigkeiten
		Float[] percent = new Float[9];
		for (int i = 0; i < 9; i++) {
			percent[i] = ((float) results[i]) / ((float) populationSize) * 100;
		}
		
		// Gib Ergebnisse aus
		System.out.println("Schmetterlinge insgesamt: " + populationSize + "\n" +
				"\nHaeufigkeit der Merkmale:\n" +
				"\n  " + "Musterung:\n" +
				"    " + "uni              : " + results[0] + 
				" (" + percent[0] + " %)\n" +
				"    " + "schwarz gepunktet: " + results[1] + 
				" (" + percent[1] + " %)\n" +
				"    " + "schwarz gestreift: " + results[2] + 
				" (" + percent[2] + " %)\n" +
				"\n  " + "Fluegelfarbe:\n" +
				"    " + "rot              : " + results[3] + 
				" (" + percent[3] + " %)\n" +
				"    " + "gelb             : " + results[4] + 
				" (" + percent[4] + " %)\n" +
				"    " + "gruen            : " + results[5] + 
				" (" + percent[5] + " %)\n" +
				"    " + "blau             : " + results[6] + 
				" (" + percent[6] + " %)\n" +
				"\n  " + "Fuehlerform:\n" +
				"    " + "gerade           : " + results[7] + 
				" (" + percent[7] + " %)\n" +
				"    " + "gekruemmt        : " + results[8] + 
				" (" + percent[8] + " %)\n"
		);
	}
	
	/**
	 * Fragt dem dem Selector und liefert diesen zurueck
	 * @return Selector
	 */
	public int setSelector() {
		int selector;
		
		// Frage nach
		System.out.println("Merkmal fuer den Lepidopterologen:\n" +
				"\n  " + "[1] = Musterung: uni" + "\n" +  
				"  " + "[2] = Musterung: schwarz gepunktet" + "\n" +
				"  " + "[3] = Musterung: schwarz gestreift" + "\n" +
				"  " + "[4] = Fluegelfarbe: rot" + "\n" +
				"  " + "[5] = Fluegelfarbe: gelb" + "\n" +
				"  " + "[6] = Fluegelfarbe: gruen" + "\n" +
				"  " + "[7] = Fluegelfarbe: blau" + "\n" +
				"  " + "[8] = Fuehlerform: gerade" + "\n" +
				"  " + "[9] = Fuehlerform: gekruemmt" + "\n"
		);
		selector = IOTools.readInteger("  " + "Eingabe: ");
		
		// Gib Eingabe zurueck
		return selector;
		
	}
	
	/**
	 * Gib Haeufigkeiten der Merkmale aus
	 * @param results Haeufigkeit der Merkmale
	 * @param selectionSize Anzahl Schmetterlinge
	 */
	public void PrintFreqsSelection(Integer[] results, int selectionSize) {
		
		// Berechne relative Haeufigkeiten
		Float[] percent = new Float[24];
		for (int i = 0; i < 24; i++) {
			percent[i] = ((float) results[i]) / ((float) selectionSize) * 100;
		}

		// Gib Ergebnisse aus
		System.out.println("\nSchmetterlinge insgesamt: " + selectionSize + "\n" +
				"\nHaeufigkeit der Merkmale:\n" +
				"\n  " + "uni               - rot   - gerade   : " + results[0] + 
				" (" + percent[0] + " %)\n" +
				"  " + "uni               - rot   - gekruemmt: " + results[1] + 
				" (" + percent[1] + " %)\n" +
				"  " + "uni               - gelb  - gerade   : " + results[2] + 
				" (" + percent[2] + " %)\n" +
				"  " + "uni               - gelb  - gekruemmt: " + results[3] + 
				" (" + percent[3] + " %)\n" +
				"  " + "uni               - gruen - gerade   : " + results[4] + 
				" (" + percent[4] + " %)\n" +
				"  " + "uni               - gruen - gekruemmt: " + results[5] + 
				" (" + percent[5] + " %)\n" +
				"  " + "uni               - blau  - gerade   : " + results[6] + 
				" (" + percent[6] + " %)\n" +
				"  " + "uni               - blau  - gekruemmt: " + results[7] + 
				" (" + percent[7] + " %)\n" +
				"  " + "schwarz gepunktet - rot   - gerade   : " + results[8] + 
				" (" + percent[8] + " %)\n" +
				"  " + "schwarz gepunktet - rot   - gekruemmt: " + results[9] + 
				" (" + percent[9] + " %)\n" +
				"  " + "schwarz gepunktet - gelb  - gerade   : " + results[10] + 
				" (" + percent[10] + " %)\n" +
				"  " + "schwarz gepunktet - gelb  - gekruemmt: " + results[11] + 
				" (" + percent[11] + " %)\n" +
				"  " + "schwarz gepunktet - gruen - gerade   : " + results[12] + 
				" (" + percent[12] + " %)\n" +
				"  " + "schwarz gepunktet - gruen - gekruemmt: " + results[13] + 
				" (" + percent[13] + " %)\n" +
				"  " + "schwarz gepunktet - blau  - gerade   : " + results[14] + 
				" (" + percent[14] + " %)\n" +
				"  " + "schwarz gepunktet - blau  - gekruemmt: " + results[15] + 
				" (" + percent[15] + " %)\n" +
				"  " + "schwarz gestreift - rot   - gerade   : " + results[16] + 
				" (" + percent[16] + " %)\n" +
				"  " + "schwarz gestreift - rot   - gekruemmt: " + results[17] + 
				" (" + percent[17] + " %)\n" +
				"  " + "schwarz gestreift - gelb  - gerade   : " + results[18] + 
				" (" + percent[18] + " %)\n" +
				"  " + "schwarz gestreift - gelb  - gekruemmt: " + results[19] + 
				" (" + percent[19] + " %)\n" +
				"  " + "schwarz gestreift - gruen - gerade   : " + results[20] + 
				" (" + percent[20] + " %)\n" +
				"  " + "schwarz gestreift - gruen - gekruemmt: " + results[21] + 
				" (" + percent[21] + " %)\n" +
				"  " + "schwarz gestreift - blau  - gerade   : " + results[22] + 
				" (" + percent[22] + " %)\n" +
				"  " + "schwarz gestreift - blau  - gekruemmt: " + results[23] + 
				" (" + percent[23] + " %)\n"
		);
		
	}
	
}