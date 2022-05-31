package model.produkty;

/**
 * Tretia vrstva hierarchie dedenia, z tejto triedy uz vytvaram instancie
 * @author tomas
 *
 */
public class Jahodovy_jogurt extends Jogurt{

	private static int spotrebaJahod = 4;

	
	public Jahodovy_jogurt() {
		this.cena = 450;
	}
	
	/**
	 * Staticka metoda pre ziskanie hodnoty atributu spotrebaJahod, dolezite pre vypocet, ci mam dostatok surovin pre objednavku
	 * @return private atributu spotrebaJahod
	 */
	public static int getspotrebaJahod()
	{
		return spotrebaJahod;
	}

}
