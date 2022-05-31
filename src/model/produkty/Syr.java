package model.produkty;

/**
 * Druha uroven hierarchie dedenia, zakladne atributy pre vyrobu syra a staticke Gettery
 * @author tomas
 *
 */
public class Syr extends Produkt {

	protected static int spotrebaSol = 4;
	protected static int spotrebaMlieko = 10;
	
	public Syr() {
		
		
	}
	
	/**
	 * Staticka metoda, aby som nemusel vytvarat instanciu pre zavolanie funkcie
	 * Pouzivam pri vypocte, ci mam dost surovin pre objednavku
	 * @return spotrebu soli pre vyrobu syra
	 */
	public static int getspotrebaSol()
	{
		return spotrebaSol;
	}
	
	/**
	 * Rovnako ako metoda vyssie, staticka aby som nepotreboval instanciu pre volanie
	 * @return spotreba mlieka pre vyrobu syra
	 */
	public static int getspotrebaMlieko()
	{
		return spotrebaMlieko;
	}

}
