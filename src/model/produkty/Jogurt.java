package model.produkty;

/**
 * Druha uroven hierarchie dedenia, zakladne atributy pre vyrobu Jogurtu a staticke GETTERY
 * @author tomas
 *
 */
public class Jogurt extends Produkt{
	
	protected static int spotrebaCukor = 2;
	protected static int spotrebaMlieko = 8;

	public Jogurt() {
		
	
	}
	
	/**
	 * Staticka metoda pre ziskanie hodnoty spotrebaCukru, aby som nemusel vytvarat instanciu pre jej zavolanie
	 * @return spotrabaCukru, dolezite pre vypocet, ci mam dost surovin pre objednavku
	 */
	public static int getspotrebaCukor() {
		return spotrebaCukor;
	}
	
	/**
	 * Staticka metoda pre ziskanie hodnoty spotrebaMlieko, aby som nemusel vytvarat instanciu pre jej zavolanie
	 * @return spotrebaMlieka, dolezite pre vypocet, ci mam dost surovin pre objednavku
	 */
	public static int getspotrebaMlieko() {
		return spotrebaMlieko;
	}
	
	

}
