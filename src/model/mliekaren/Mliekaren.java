package model.mliekaren;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import model.employees.Jogurtar;
import model.employees.Rozvazac;
import model.employees.Syrar;
import model.employees.User;
import model.employees.Veduci_mliekarne;
import model.employees.Zamestnanec;
import model.klienti.Klient;
import model.produkty.Broskynovy_jogurt;
import model.produkty.Jahodovy_jogurt;
//import model.klienti.Retazec;
import model.produkty.Korbace;
import model.produkty.Parenica;
import model.sklad.Sklad;

public class Mliekaren {

	private String nazov;
	
	private ArrayList<Zamestnanec> ZoznamZamestnancov;
	private ArrayList<Klient> ZoznamKlientov;
	private final Sklad sklad;
	private static Mliekaren Singleton_mliekaren = null;
	private Veduci_mliekarne veduciMliekarne;
	private User loggedIN = null;
	
	private double financie;
	
	
	

	private Mliekaren() 
	{
		this.setNazov("Mliekaren Hnusta");
		this.setFinancie(100000);
		sklad = new Sklad();
		
		System.out.println("Mliekaren inicializovana...");
		veduciMliekarne = Veduci_mliekarne.getDefaultInstance(sklad);
		
		ZoznamZamestnancov = new ArrayList<Zamestnanec>();
		ZoznamKlientov = new ArrayList<Klient>();
		
		Zamestnanec z1 = new Jogurtar("Matt","Stonie","matsto","123",sklad);
		Zamestnanec z2 = new Syrar("Johny","Depp","johdep","123",sklad);
		Zamestnanec z3 = new Syrar("Tom","Cruise","tomcru","123",sklad);
		Zamestnanec z4 = new Rozvazac("Jeff","Bezos","jefbez","123",sklad);
		Klient k1 = new Klient("Tesco","tesco","123");
		
		ZoznamKlientov.add(k1);
		ZoznamZamestnancov.add(z1);
		ZoznamZamestnancov.add(z2);
		ZoznamZamestnancov.add(z3);
		ZoznamZamestnancov.add(z4);

		
	}
	
	public static Mliekaren getDefaultInstance() 
	{
		if(Singleton_mliekaren == null)
		{
			System.out.println("Vytvaram novu instanciu");
			Singleton_mliekaren = new Mliekaren();
		}
		else {
			System.out.println("Returnujem uz predtym vytvorenu");
		}
		
		return Singleton_mliekaren;
		
	}
	
	/*		LOGIN		*/
	
	public User login(String login, String passw) 
	{
		if(loggedIN == null) 
		{
			if(veduciMliekarne.checkLogin(login, passw)) {
				System.out.println("ZHODA UDAJOV VEDUCI");
				loggedIN = veduciMliekarne;
				return loggedIN;
			}
			
			for(Zamestnanec usr : ZoznamZamestnancov)
			{
				if(usr.checkLogin(login, passw))
				{
					loggedIN = usr;
					return loggedIN;
				}
			}
			
			for(Klient usr : ZoznamKlientov)
			{
				if(usr.checkLogin(login, passw))
				{
					loggedIN = usr;
					return loggedIN;
				}
			}
			
			
			
			
		}
		return null;	
	}
	
	public void logoutClicked() {
		this.loggedIN = null;
	}
	
	/*		VYPLATA		*/
	public void vyplata()
	{
		double vydavky = 0;
		for(Zamestnanec zam : ZoznamZamestnancov)
		{
			zam.vyplata();
			vydavky += zam.getMzda();
		}		
		financie -= vydavky;
	}
	
	
	/*	vYPISY	*/
	public void vypisZAM()
	{
		System.out.println("\n");
		for(Zamestnanec a : ZoznamZamestnancov)
		{
			System.out.println( a.getName() + " " + a.getSurname());
		}
	}
	
	
	
	
	/*		SPRAVA ZOZNAMOV		*/
	public void pridajZam(String pozicia, String meno, String priezvisko, String usern, String passw) 
	{
		
			if(pozicia.equals("Syrar"))
			{
				System.out.println("Vytvaram syrara");
				Zamestnanec newZamestnanec = new Syrar(meno,priezvisko,usern,passw,sklad);
				ZoznamZamestnancov.add(newZamestnanec);	
			}
				
			else if(pozicia.equals("Jogurtar"))
			{
				System.out.println("Vytvaram jogurtara");
				Zamestnanec newZamestnanec = new Jogurtar(meno,priezvisko,usern,passw,sklad);
				ZoznamZamestnancov.add(newZamestnanec);
			}
			
			else if(pozicia.equals("Rozvazac"))
			{
				System.out.println("Vytvaram rozvazaca");
				Zamestnanec newZamestnanec = new Rozvazac(meno,priezvisko,usern,passw,sklad);
				ZoznamZamestnancov.add(newZamestnanec);
			}
	}
	
	public void vyhodZam(ObservableList<Zamestnanec> a) {
		for (Zamestnanec zam: a)
        {
            ZoznamZamestnancov.remove(zam);
        }
		
		this.vypisZAM();
		
	}
	
	///////		KLIENT
	
	public void pridajKlienta(String name, String log, String pass) {
		
		Klient newKlient = new Klient(name,log,pass);
		ZoznamKlientov.add(newKlient);
		

		
	}

	public void vyhodKlienta(ObservableList<Klient> a) {
		for (Klient clien: a)
        {
            ZoznamKlientov.remove(clien);
        }
	}
	
	
	
	/*			VYROBA PRODUKTOV		*/
	
	public String vyrobaProduktu(int pocetJah, int pocetBros, int pocetParenic, int pocetKorbacov) {
		
		int mlieko = (pocetJah*Jahodovy_jogurt.getspotrebaMlieko()) + (pocetBros*Broskynovy_jogurt.getspotrebaMlieko()) + (pocetParenic*Parenica.getspotrebaMlieko()) + (pocetKorbacov*Korbace.getspotrebaMlieko());
		int sol = (pocetParenic*Parenica.getspotrebaSol()) + (pocetKorbacov*Korbace.getspotrebaSol());
		int cukor = (pocetJah*Jahodovy_jogurt.getspotrebaCukor()) + (pocetBros*Broskynovy_jogurt.getspotrebaCukor()); 
		int jahody = pocetJah*Jahodovy_jogurt.getspotrebaJahod();
		int broskyne = pocetBros*Broskynovy_jogurt.getspotrebaBroskyn();
		
		
		if(sklad.getMlieko() >= mlieko && sklad.getSol() >= sol && sklad.getCukor() >= cukor && sklad.getJahody() >= jahody && sklad.getBroskyne() >= broskyne)
		{
			
			
			int i = 0;
			while(i != pocetJah) {
				for(Zamestnanec zam : ZoznamZamestnancov)
				{
					if(zam instanceof Jogurtar)
					{
						((Jogurtar) zam).pracuj("jahodovy");
						i++;
						if(i == pocetJah)
						{
							break;
						}
					}
				}
			}
			
			i=0;
			while(i != pocetBros) {
				for(Zamestnanec zam : ZoznamZamestnancov)
				{
					if(zam instanceof Jogurtar)
					{
						((Jogurtar) zam).pracuj("broskynovy");
						i++;
						if(i == pocetBros)
						{
							break;
						}
					}
				}
			}
			

			i=0;
			while(i != pocetParenic) {
				for(Zamestnanec zam : ZoznamZamestnancov)
				{
					if(zam instanceof Syrar)
					{
						((Syrar) zam).pracuj("parenica");
						i++;
						if(i == pocetParenic)
						{
							break;
						}
					}
				}
			}
			
			
			i=0;
			while(i != pocetKorbacov) {
				for(Zamestnanec zam : ZoznamZamestnancov)
				{
					if(zam instanceof Syrar)
					{
						((Syrar) zam).pracuj("korbace");
						i++;
						if(i == pocetKorbacov)
						{
							break;
						}
					}
				}
			}
			
			return "Objednane";
			
		}
		
		else
		{
			return "Nedostatok surovin";
		}
		
			
	}
	
	public void vyvozTovaru(int pocBJ, int pocJJ, int par, int korb)
	{	
		int zarobok = 0; 
		for(Zamestnanec zam : ZoznamZamestnancov)
		{
			if(zam instanceof Rozvazac)
			{
				zarobok += ((Rozvazac) zam).pracuj(pocJJ, "jahodovy", ((Klient)loggedIN));
				zarobok += ((Rozvazac) zam).pracuj(pocJJ, "broskynovy",((Klient)loggedIN));
				zarobok += ((Rozvazac) zam).pracuj(pocJJ, "parenica",((Klient)loggedIN));
				zarobok += ((Rozvazac) zam).pracuj(pocJJ, "korbace",((Klient)loggedIN));
				break;
				
			}
		}
		this.financie += zarobok;
	}
	
	
	
	
	public void vypisSkladu()
	{
		sklad.vypisProduktov();
	}
	
	
	
	
	
	
	
	
	
	////	gettery + settery
	
	public String getNazov() {
		return nazov;
	}

	public void setNazov(String nazov) {
		this.nazov = nazov;
	}
	
	public double getFinancie() {
		return financie;
	}

	public void setFinancie(double financie) {
		this.financie = financie;
	}
	
	public void setAddFinancie(double financie)
	{
		this.financie += financie;
	}
	public void setRemoveFinancie(double financie)
	{
		this.financie -= financie;
	}
		
	
	public Sklad getSklad()
	{
		return sklad;
		
	}
	
	public User getLoggedUser() {
		return this.loggedIN;
	}

	
	
	
	public ArrayList<Zamestnanec> getZoznamZamestnancov() {
		return ZoznamZamestnancov;
	}

	public void setZoznamZamestnancov(ArrayList<Zamestnanec> zoznamZamestnancov) {
		ZoznamZamestnancov = zoznamZamestnancov;
	}

	public ArrayList<Klient> getZoznamKlientov() {
		return ZoznamKlientov;
	}

	
	public void setZoznamKlientov(ArrayList<Klient> zoznamKlientov) {
		ZoznamKlientov = zoznamKlientov;
	}
	
	
	
	
	
}
