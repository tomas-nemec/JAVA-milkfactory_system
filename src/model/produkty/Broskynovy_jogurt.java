package model.produkty;

/**
 * Tretia vrstva hierarchie dedenia, z tejto triedy uz vytvaram instancie
 * @author tomas
 *
 */
public class Broskynovy_jogurt extends Jogurt{
	private static int spotrebaBroskyn = 5;
	
	public Broskynovy_jogurt() {
		this.cena = 400;
	}

	/**
	 * Staticka metoda pre ziskanie hodnoty atributu spotrebaBroskyn, dolezite pre vypocet, ci mam dostatok surovin pre objednavku
	 * @return hdonotu private atributu spotrebaBroskyn
	 */
	public static int getspotrebaBroskyn()
	{
		return spotrebaBroskyn;
	}
}
