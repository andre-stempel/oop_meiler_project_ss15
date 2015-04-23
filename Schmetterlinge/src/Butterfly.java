import Tools.Wuerfel.*;

/**
 * Ein Schmetterling mit Musterung, Fluegelfarbe und
 * Fluegelform
 * @author Joe Rilla
 */
public class Butterfly {

	/**
	 * Musterung:
	 * 1 = uni
	 * 2 = schwarz gepunktet
	 * 3 = schwarz gestreift
	 */
	private int pattern;
	
	/**
	 * Fluegelfarbe:
	 * 1 = rot
	 * 2 = gelb
	 * 3 = gruen
	 * 4 = blau
	 */
	private int wingColor;
	
	/**
	 * Fuehlerform:
	 * 1 = gerade
	 * 2 = gekruemmt
	 */
	private int antennaShape;
	
	/**
	 * Konstruktor, erzeugt einen Schmetterling mit gegebenen Merkmalen
	 * @param inPattern Musterung
	 * @param inWingColor Fluegelfarbe
	 * @param inAntennaShape Fuehlerform
	 */
	public Butterfly(int inPattern, int inWingColor, int inAntennaShape) {
		
		// setze die merkmale
		pattern = inPattern;
		wingColor = inWingColor;
		antennaShape = inAntennaShape;
		
	}
	/**
	 * Konstruktor, erzeugt einen Schmetterling mit zufälligen Merkmalen
	 * bei gegebenem Elternpaar
	 * @param mom Mutter
	 * @param dad Vater
	 */
	public Butterfly(Butterfly mom, Butterfly dad) {
		
		// einen Wuerfel erzeugen
		Wuerfel die = new Wuerfel(0,1);
		
		// Musterung wuerfeln
		die.wuerfeln();
		if (die.getAugen() == 0) pattern = mom.getPattern();
		else pattern = dad.getPattern();
		
		// Fluegelfarbe wuerfeln
		die.wuerfeln();
		if (die.getAugen() == 0) wingColor = mom.getWingColor();
		else wingColor = dad.getWingColor();
		
		// Fuehlerform wuerfeln
		die.wuerfeln();
		if (die.getAugen() == 0) antennaShape = mom.getAntennaShape();
		else antennaShape = dad.getAntennaShape();
		
	}
	
	/**
	 * Liefert Code fuer Musterung
	 * @return Musterung
	 */
	public int getPattern() {
		return pattern;
	}
	
	/**
	 * Liefert Code fuer Fluegelfarbe
	 * @return Fluegelfarbe
	 */
	public int getWingColor() {
		return wingColor;
	}
	
	/**
	 * Liefert Code fuer Fuehlerform
	 * @return Fuehlerform
	 */
	public int getAntennaShape() {
		return antennaShape;
	}
	
	/**
	 * toString Methode
	 */
	public String toString() {
		String outPattern, outWingColor, outAntennaShape, output;
		
		// Musterung
		switch (pattern) {
			case 1:
				outPattern = "uni";
				break;
			case 2:
				outPattern = "schwarz gepunktet";
				break;
			case 3:
				outPattern = "schwarz gestreift";
				break;
			default:
				outPattern = "";
				break;
		}
		
		// Fluegelfarbe
		switch (wingColor) {
		case 1:
			outWingColor = "rot";
			break;
		case 2:
			outWingColor = "gelb";
			break;
		case 3:
			outWingColor = "gruen";
			break;
		case 4:
			outWingColor = "blau";
			break;
		default:
			outWingColor = "";
			break;
		}
		
		// Fuehlerform
		switch (antennaShape) {
			case 1:
				outAntennaShape = "gerade";
				break;
			case 2:
				outAntennaShape = "gekruemmt";
				break;
			default:
				outAntennaShape = "";
				break;
		}
		
		output = "Schmetterling: \n" +
				"  Musterung: " + outPattern + "\n" +
				"  Fluegelfarbe: " + outWingColor + "\n" +
				"  Fuehlerform: " + outAntennaShape;
		
		return output;
		
	}
	
}