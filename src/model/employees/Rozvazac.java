package model.employees;

import model.klienti.Klient;
import model.produkty.Produkt;
import model.sklad.Sklad;

/**
 * Najnizsia trieda zamestnancov,  uz finalne pozicie.
 * @author tomas
 *
 */
public class Rozvazac extends Zamestnanec{
	
	private Klient zakaznik;
	private Produkt tovar;
	
	public Rozvazac(String meno, String priezvisko, String log, String pass,Sklad a) 
	{
		super(meno, priezvisko, log, pass,a);
		this.mzda = 400;
		
	}
	
	
	public Rozvazac(String meno, String priezvisko) {
		super(meno, priezvisko);
	}
	
	
	
	
	
	
	/**
	 *Funkcia na vypocet vyplaty Rozvazaca, rozvazac je zivnostnik takze neplati DPH - ma specificky vypocet mzdy
	 */
	public void vyplata()
	{
		this.ucet += mzda;
	}

	
	
	/**
	 * Funkcia pracuj pre Rozvazaca, odoberie produkt zo zoznamu v triede Sklad a vlozi ho do zoznamu produktov Klientovi
	 * @param pocet		kolko produktov bude prevazat
	 * @param produkt	String pre upresnenie, ktory produkt bude prevazat Rozvazac
	 * @param a =  Klient, ktoremu sa dorucia produkty
	 * @return	returnuje sumu, ktora sa pripocita na ucet mliekarni, je to vlastne poplatok za produkty
	 */
	public double  pracuj(int pocet ,String produkt, Klient a) {
		
		double price = sklad.getCenaProduktu(produkt);
		for(int i = 0; i<pocet;i++)
		{
			a.pridajProduktKlientovi(sklad.odvozProduktov(produkt));
		}
		a.zaplat(price*pocet);
		
		return  price*pocet;
		
			
	}

}
