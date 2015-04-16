import Tools.IO.IOTools;
import java.util.Arrays;

public class NumberGame {
	
	/**
	 * Spielstand aktuelle Runde
	 */
	private int[] scoreRound;
	
	/**
	 * Spielstand gesamt
	 */
	private int[] scoreTotal;
	
	
	/** 
	 * Feld mit Spieler/innen
	 */
	private Player[] player;
	
	/**
	 * Anzahl der Spieler/innen
	 */
	private int numPlayers;
	
	/**
	 * Anzahl der Runden
	 */
	private int numRounds;
	
	/**
	 * Nummer fuer Spielvariante
	 * 1 = vor dem Wuerfeln fragen
	 * 2 = nach dem Wuerfeln fragen
	 */
	private int numVariant;
	
	/**
	 * Konstruktor
	 * @param inNumPlayers Anzahl der Spieler/innen
	 * @param inNumRounds Anzahl der Runden
	 * @param inNumVariant Spielvariante
	 */
	public NumberGame( int inNumPlayers, int inNumRounds, int inNumVariant ) {
		
		// spieler/innenanzahl setzen
		numPlayers = inNumPlayers;
		
		// rundenanzahl setzen
		numRounds = inNumRounds;
		
		// variante setzen
		numVariant = inNumVariant;
		

		// spieler erzeugen
		player = new Player[ numPlayers ];
		for (int i = 0; i < numPlayers; i++) {
			player[ i ] = new Player();
		}
		
		// spielstand initialisieren
		scoreRound = new int[ numPlayers ];
		scoreTotal = new int[ numPlayers ];
		for (int i = 0; i < numPlayers; i++) {
			scoreRound[ i ] = 0;
			scoreTotal[ i ] = 0;
		}
		
	}

	/**
	 * Frage nach Anzahl der Spieler/innen
	 * @return Anzahl der spieler/innen
	 */
	public static int setNumPlayers() {
		int numPlayers;
		
		// frage nach der anzahl der spieler/innen und wirf diese wieder aus
		System.out.println();
		do {
			numPlayers = IOTools.readInteger( "Anzahl der Spieler/innen?[1..10] ");
		} while ( !(numPlayers >= 1 && numPlayers <= 10) );	
		return numPlayers;

	}
	
	/**
	 * Frage nach Rundenanzahl
	 * @return Rundenanzahl
	 */
	public static int setNumRounds() {
		int numRounds;
		
		// frage nach rundenanzahl und wirf diese aus
		System.out.println();
		do {
			numRounds = IOTools.readInteger( "Anzahl der Runden?[1..10] " );
		} while ( !(numRounds >= 1 && numRounds <= 10));
		return numRounds;
		
	}
	
	/**
	 * Frage nach Spielvariante
	 * @return spielvariante
	 */
	public static int setNumVariant() {
		int numVariant;
		
		// frage nach variante und wirf die nummer aus
		System.out.println();
		do {
			numVariant = IOTools.readInteger( "Variante: [1] vor dem Wurf, [2] nach dem Wurf? " );
		} while ( !(numVariant == 1 || numVariant == 2) );
		return numVariant;
		
	}
	
	/**
	 * Bestimme Sieger/in
	 */
	public void getWinner(boolean total) {
		int[] sortedScore;
		boolean finished = false;
		int i = 0;

		// verwende den richtigen score
		if (total) {
			sortedScore = scoreTotal.clone();
		}
		else {
			sortedScore = scoreRound.clone();
		}
		
		
		// sortiere das array
		Arrays.sort(sortedScore);
		
		// nur ein/e spieler/in?
		if (numPlayers == 1) {
			
			// gesamtsieger/in
			if (total) {
				int j = 0;
				System.out.printf("Gesamtpunktzahl Spieler/in %s: %s\n", j+1, player[j].getTotalSum());
				System.out.printf("\n---\nGesamtsieger/in: Spieler/in %s\n", i+1);
			}
			
			// rundensieger/in
			else {
				System.out.printf("\n---\nRundensieger/in: Spieler/in %s\n", i+1);
			}
			
		}
		
		// mehr als ein/e spieler/in
		else {
			
			// gib sieger/in aus, sofern vorhanden
			if (sortedScore[ sortedScore.length - 1 ] != sortedScore[sortedScore.length - 2]) {
				while ((!finished) && (i < numPlayers)) {
					
					// gesamtsieger/in
					if (total) {
						if (player[i].getTotalSum() == sortedScore[ sortedScore.length - 1 ]) {
							
							// zeige gesamtpunktzahl
							System.out.println("---");
							for (int j = 0; j < numPlayers; j++) {
								System.out.printf("Gesamtpunktzahl Spieler/in %s: %s\n", j+1, player[j].getTotalSum());
							}
							
							// zeige gesamtsieger/in
							System.out.printf("\n---\nGesamtsieger/in: Spieler/in %s\n", i+1);
							
							finished = true;
						}
						i++;	
					}
					
					// rundensieger/in
					else {
						if (player[i].getHouseNumber() == sortedScore[ sortedScore.length - 1 ]) {
							System.out.printf("\n---\nRundensieger/in: Spieler/in %s\n", i+1);
							finished = true;
						}
						i++;
					}
					
				}
			}
			else {
				System.out.println("\nNiemand hat gewonnen.");
			}
			
		}
		
	}
	
	/**
	 * Spiele Runden
	 */
	public void playRounds() {
	
		// entsprechend oft "playRound" aufrufen
		for (int i = 0; i < numRounds; i++) {
			System.out.printf("\n--- Runde %s ---\n", i+1);
			playRound();
		}
		
		// trage gesamtpunktzahl ein
		for (int i = 0; i < numPlayers; i++) {
			scoreTotal[i] = player[i].getTotalSum();
		}
		
		// gesamtsiegerin ausgeben
		getWinner(true);
		
	}
	
	/**
	 * Spiele eine Runde
	 */
	public void playRound() {
		
		// alle spieler durchgehen
		for (int i = 0; i < numPlayers; i++) {
			
			// spieler anzeigen
			System.out.printf("\nSpieler/in %s:\n", i+1);
			
			// hausnummer zuruecksetzen
			player[i].resetHouseNumber();
			
			// wuerfeln
			player[i].setWuerfel();
			
			// alle 3 wuerfel durchgehen
			int choice, j = 0;
			String s1 = " Einer[1] ", 
					s10 = " Zehner[10] ", 
					s100 = " Hunderter[100] ",
					sOccupied = "  Diese Stelle wurde bereits besetzt.",
					sInvalid = "  Eingabe ungueltig.";
			
			// so lange nachfragen, bis alle drei stellen vergeben sind
			do {
				
				System.out.println();
				
				// variante 1: vor dem wurf
				if (numVariant == 1) {
					
					// welche stelle?
					choice = IOTools.readInteger( " " + s1 + s10 + s100 + "? " );
					
					//augenzahl ausgeben
					System.out.printf("  %s. Wuerfel: %s\n", j+1, player[i].getWuerfel(j));
					
				}
				
				// variante 2: nach dem wurf
				else {
					
					// augenzahl ausgeben
					System.out.printf("  %s. Wuerfel: %s\n", j+1, player[i].getWuerfel(j));
					
					// welche stelle?
					choice = IOTools.readInteger( " " + s1 + s10 + s100 + "? " );
					
				}
				
				// eingabe umsetzen
				switch (choice) {
				
				// die einer stelle setzen
				case 1:
					if (s1.length() != 0) {
						player[i].addToHouseNumber(player[i].getWuerfel(j) * 1);
						s1 = "";
						j++;
					}
					else {
						System.out.println(sOccupied);
					}
					break;
					
				// die zehner stelle setzten	
				case 10:
					if (s10.length() != 0) {
						player[i].addToHouseNumber(player[i].getWuerfel(j) * 10);
						s10 = "";
						j++;
					}
					else {
						System.out.println(sOccupied);
					}
					break;
				
				// die hunderter stelle setzten
				case 100:
					if (s100.length() != 0) {
						player[i].addToHouseNumber(player[i].getWuerfel(j) * 100);
						s100 = "";
						j++;
					}
					else {
						System.out.println(sOccupied);
					}
					break;
					
					default:
						System.out.println(sInvalid);
					
				}
			} while (!(s1.length() == 0 && s10.length() == 0 && s100.length() == 0));
			
			// inkrementiere die total sum um die aktuelle Hausnummer
			player[i].addToTotalSum(player[i].getHouseNumber());
			
			// gib aktuelle hausnummer aus
			System.out.printf("\ngewuerfelte  Hausnummer: %s\n", player[i].getHouseNumber());
			
			// trage aktuelle hausnummer in spielstand ein
			scoreRound[i] = player[i].getHouseNumber();
			
		}
		
		// gibt rundensieger/in
		getWinner(false);
		
	}

}
