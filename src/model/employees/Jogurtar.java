package model.employees;

import model.produkty.Broskynovy_jogurt;
import model.produkty.Jahodovy_jogurt;
import model.sklad.Sklad;

/**
 * Najnizsia trieda Zamestnanca, finalna z ktorej sa uz tvoria instancie zamestnancov
 * @author tomas
 *
 */
public class Jogurtar extends Zamestnanec{
	private int bonus;
	
	


	public Jogurtar(String meno, String priezvisko) {
		super(meno, priezvisko);
		this.mzda = 666;
	}
	
	
	
	public Jogurtar(String meno, String priezvisko, String log, String pass,Sklad a) {
		super(meno, priezvisko, log, pass,a);
		this.mzda = 400;
		this.bonus = 150;
		
	}
	
	
	/**
	 * Override funkcie pre vypocet vyplaty, Jogurtar dostava k vyplate este aj bonus
	 */
	public void vyplata() {
		this.ucet += (this.mzda*this.DPH)+this.bonus;
	}
	
	
	/**
	 * Presne zadefinovanie metody prace pre Jogurtara, vytvara jogurt a prida ho do skladu 
	 * @param prichut specifikacia podla kotrej vytvori bud jahodovy alebo broskynovy jogurt
	 */
	public void pracuj(String prichut)
	{
		if(prichut.equals("jahodovy"))
		{
			Jahodovy_jogurt a = new Jahodovy_jogurt();
			if(sklad.getJahody() >= a.getspotrebaJahod() && sklad.getCukor() >= a.getspotrebaCukor() && sklad.getMlieko() >= a.getspotrebaMlieko())
			{
				sklad.pridajJogurt(a);
			}
			else {
				System.out.println("Nedostatok surovin na jogurt jahodovy");
			}
		}
		else if(prichut.equals("broskynovy"))
		{
			Broskynovy_jogurt a = new Broskynovy_jogurt();
			if(sklad.getBroskyne() >= a.getspotrebaBroskyn() && sklad.getCukor() >= a.getspotrebaCukor() && sklad.getMlieko() >= a.getspotrebaMlieko())
			{
				sklad.pridajJogurt(a);
			}
			else {
				System.out.println("Nedostatok surovin na jogurt broskynovy");
			}
		}	
	}

}
