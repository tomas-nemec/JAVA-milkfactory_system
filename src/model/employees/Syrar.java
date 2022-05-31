package model.employees;


import model.produkty.Korbace;
import model.produkty.Parenica;
import model.sklad.Sklad;

/**
 * Najnizsia trieda zamestnancov, finalne verzie
 * @author tomas
 *
 */
public class Syrar extends Zamestnanec {

	public Syrar(String meno, String priezvisko, String log, String pass,Sklad a) {
		super(meno, priezvisko, log, pass, a);
		this.mzda = 400;
		
	}
	
	public Syrar(String meno, String priezvisko) {
		
		super(meno, priezvisko);
		
	}
	
	
	
	
	/**
	 * Uz presna specifikacia prace Syrara
	 * @param typ urcuje aky typ syru bude Syrar vyrabat
	 */
	public void pracuj(String typ)
	{
		if(typ.equals("parenica"))
		{
			Parenica a = new Parenica();
			if(sklad.getSol() >= a.getspotrebaSol() && sklad.getMlieko() >= a.getspotrebaMlieko())
			{
				System.out.println("Vytvaram parenicu");
				sklad.pridajSyr(a);
			}
			else {
				System.out.println("Nedostatok surovin na parenicu");
			}
		}
		else if(typ.equals("korbace"))
		{
			Korbace a = new Korbace();
			if(sklad.getMlieko() >= a.getspotrebaMlieko() && sklad.getSol() >= a.getspotrebaSol())
			{
				System.out.println("Vytvaram korbace");
				sklad.pridajSyr(a);
			}
			else {
				System.out.println("Nedostatok surovin na korbace");
			}
		}	
	}
	
	

}
