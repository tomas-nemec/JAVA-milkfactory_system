package model.employees;



import model.sklad.Sklad;

/**
 * Trieda Zamestnanec obsahuje bezne atributy pre zamestnanca mliekarne
 * @author tomas
 *
 */
public class Zamestnanec extends User  implements ZamInterface{
	
	protected Sklad sklad;
	
	protected boolean available;
	protected double mzda;
	protected final double DPH = 0.8;
	protected int ucet = 0;
	
	
	
	
	
	public Zamestnanec()
	{
		
	}
	
	public Zamestnanec(String a,String b)
	{
		this.setName(a);
		this.setSurname(b);
		this.mzda = 888;
	}
	
	public Zamestnanec(String meno,String priezvisko,String log, String pass,Sklad a)
	{
		
			this.setName(meno);
			this.setSurname(priezvisko);
			this.setLogin(log);
			this.setPassword(pass);
			this.available = true;	
			this.sklad = a;
			
		
	}
	
	public Zamestnanec(String meno,String priezvisko,String log, String pass)
	{
		
			this.setName(meno);
			this.setSurname(priezvisko);
			this.setPassword(pass);
			this.setLogin(log);
			this.available = true;	
			
			
		
	}
	
	
	
	/**
	 * Funckia, ktora pripocita vyplatu zamestnancovi na ucet.
	 * 
	 */
	public void vyplata() {
		this.ucet += (this.mzda*this.DPH);
	}

	
	public double getUcet() {
		return this.ucet;
	}

	/**
	 * Funckia na zistenie mzdy zamestnanca, pouziva sa na odcitanie vyplaty od financii mliekarne
	 * @return mzdu zamestnanca
	 */
	public double getMzda() {
		return this.mzda;
	}
	
	/**
	 * Funkcia na ziskanie informacii zamestnanca ohladom dostupnosti pre pracu (dostupny/PN)
	 * @return boolean
	 */
	public boolean getAvailable()
	{
		return this.available;
	}
	
	
	
	
	

}
