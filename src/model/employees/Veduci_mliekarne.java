package model.employees;

import model.sklad.*;

/**
 * Singleton trieda, veduci mliekarne, mozne vytvorit iba jednu instanciu z tejto triedy
 * @author tomas
 *
 */
public class Veduci_mliekarne extends Zamestnanec {

	private static Veduci_mliekarne Singleton_Veduci = null;
	private Sklad Sklad;
	
	private Veduci_mliekarne(String prih_meno, String heslo,String name, String surname, Sklad a)
	{
		this.setLogin(prih_meno);
		this.setPassword(heslo);
		this.setName(name);
		this.setSurname(surname);
		this.Sklad = a;
		
	}
	
	/**
	 * Staticka metoda, ktora zaruzuje ze z triedy nebude vytvorenych viac instancii
	 * V pripade, ze este nebola vytvorena instancia Veduci_mliekarne, vytvori ju pomocou private konstruktora
	 * Ak uz instancia bola predtym vytvorena, tak ju iba returnuje
	 * @param a - posiela sa iba sklad, pre pripad ze instancia este nebola vytvorena
	 * @return instancia veduceho mliekarne
	 */
	public static Veduci_mliekarne getDefaultInstance(Sklad a) 
	{
		if(Singleton_Veduci == null)
		{
			Singleton_Veduci = new Veduci_mliekarne("veduci","pass", "Tomáš", "Nemec",a);
		}
		
		return Singleton_Veduci;
		
	}

	
}
