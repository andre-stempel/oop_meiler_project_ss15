import Tools.IO.*;

public class Main {
	
	/** 
	 * Regeln anzeigen
	 */
	public String printRules() {
		
		String rules = "*** Hausnummern *** \n\n" +
				"Jede/r Spieler/in wuerfelt dreimal hintereinander und entscheidet \n" +
				"an welcher Stelle seiner/ihrer Hausnummer die gewürfelte Zahl stehen \n" +
				"soll. (Gemeint sind hier Einer, Zehner oder Hunderter) \n\n" +
				"1. Variante: Nach jedem Wurf wird die Position festgelegt. \n" +
				"2. Variant: Vor jedem Wurf wird die Position festgelegt. \n\n" +
				"Die hoechste Hausnummer hat gewonnen.";
		
		return rules;
	}
	
	/**
	 * Spiel konstruieren, Schleife starten
	 */
	public void start() {

		// spielregeln anzeigen
		System.out.println( "\n" + printRules() + "\n" );
		IOTools.readLine( "Weiter (RETURN) " );
		
		// new game
		NumberGame game = new NumberGame(
				NumberGame.setNumPlayers(),
				NumberGame.setNumRounds(),
				NumberGame.setNumVariant()
		);
		
		// play rounds
		game.playRounds();
		
	}
	
	/**
	 * Hauptprogramm
	 * @param args 
	 */
	public static void main(String[] args) {

	// create main loop
	Main mainLoop = new Main();
	
	// start game
	mainLoop.start();
	
		
	}

}