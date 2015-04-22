/**
 * Schmetterlingspopulationen erzeugen und analysieren
 * @author Joe Rilla
 */
public class Main {
	
	/**
	 * Konstruktor
	 */
	public Main() {
		;
	}
	
	/**
	 * Das Hauptprogramm aufrufen
	 */
	public void start() {
		
		// Dialog erzeugen
		Dialog dialog = new Dialog();
		
		// eine neue Population erzeugen
		Population family = new Population(dialog.createParent("Mutter"),
				dialog.createParent("Vater")
		);
		
		// Kinder bekommen
		family.breed();
		
		// Häufigkeiten der Merkmale ausgeben
		Analyse a1 = new Analyse();
		dialog.printFreqsTotal(a1.freqTotal(family.getPopulation()), 
				family.getPopulationSize()
		);
		
		// Schmetterlinge fangen
		family.catchButterflies(dialog.setSelector());
		
		// Häufigkeiten der Merkmale ausgeben 
		Analyse a2 = new Analyse();
		dialog.PrintFreqsSelection(a2.freqSelection(family.getSelection()),
				family.getSelectionSize()
		);
		
	}

	/**
	 * Hauptprogramm
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main mainLoop = new Main();
		mainLoop.start();
		
	}

}