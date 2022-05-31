package model.sklad;

import java.util.ArrayList;

import model.produkty.Broskynovy_jogurt;
import model.produkty.Jahodovy_jogurt;
import model.produkty.Jogurt;
import model.produkty.Korbace;
import model.produkty.Parenica;
import model.produkty.Produkt;
import model.produkty.Syr;

public class Sklad {
	
	private int mlieko;
	private int sol;
	private int cukor;
	private int jahody;
	private int broskyne;
	
	private  double priceSol = 1;
	private double priceCuk = 1;
	private double priceMilk = 3;
	private double priceJah = 10;
	private double priceBros = 8;
	
	
	
	private ArrayList<Jahodovy_jogurt> jahodoveJogurtyNaSklade;
	private ArrayList<Broskynovy_jogurt> broskynoveJogurtyNaSklade;
	private ArrayList<Parenica> pareniceNaSklade;
	private ArrayList<Korbace> korbaceNaSklade;
	
	
	public Sklad()
	{
		jahodoveJogurtyNaSklade = new ArrayList<Jahodovy_jogurt>();
		broskynoveJogurtyNaSklade = new ArrayList<Broskynovy_jogurt>();
		pareniceNaSklade = new ArrayList<Parenica>();
		korbaceNaSklade = new ArrayList<Korbace>();
		this.setMlieko(500);
		this.setSol(500);
		this.setCukor(500);
		this.setJahody(200);
		this.setBroskyne(200);
	}

	/*		VYROBA		*/
	public void pridajJogurt(Jogurt a)
	{
		this.mlieko -= a.getspotrebaMlieko();
		this.cukor -= a.getspotrebaCukor();
		if(a instanceof Jahodovy_jogurt) {
			this.jahody -= ((Jahodovy_jogurt) a).getspotrebaJahod();
			this.jahodoveJogurtyNaSklade.add((Jahodovy_jogurt) a);
			
			System.out.println("Pridavam do arrayu Jahodovy jogurt");
		}
		else {
			this.broskyne -= ((Broskynovy_jogurt) a).getspotrebaBroskyn();
			this.broskynoveJogurtyNaSklade.add((Broskynovy_jogurt) a);
			
			System.out.println("Pridavam do arrayu Broskynovy jogurt");
		}
		
	}
	
	public void pridajSyr(Syr a)
	{
		this.mlieko -= a.getspotrebaMlieko();
		this.sol -= a.getspotrebaSol();
		
		if(a instanceof Parenica) {
			this.pareniceNaSklade.add((Parenica) a);
			System.out.println("Pridavam do arrayuparenicu");
		}
		else {
			this.korbaceNaSklade.add((Korbace) a);
			System.out.println("Pridavam do arrayu korbact");
		}
	}
	
	
	public void vypisProduktov()
	{
		System.out.println("Pocet jahodovych jogurtov: " + jahodoveJogurtyNaSklade.size());
		System.out.println("Pocet broskynovych jogurtov: " + broskynoveJogurtyNaSklade.size());
		System.out.println("Pocet parenice: " + pareniceNaSklade.size());
		System.out.println("Pocet korbacikov: " + korbaceNaSklade.size());
	}
	
	/*		VYVOZ A PREDAJ		*/
	public Produkt odvozProduktov(String produkt)
	{
		
		if(produkt.equals("broskynovy")) {
				for(Broskynovy_jogurt jog : broskynoveJogurtyNaSklade)
				{
					broskynoveJogurtyNaSklade.remove(jog);
					return jog;	
				}
			
		}
		
		else if(produkt.equals("jahodovy")) {
				for(Jahodovy_jogurt jog : jahodoveJogurtyNaSklade)
				{
					jahodoveJogurtyNaSklade.remove(jog);
					return jog;
					
				}
			
		}
		
		else if(produkt.equals("parenica")) {
			for(Parenica par : pareniceNaSklade)
			{
				pareniceNaSklade.remove(par);
				return par;
				
			}
		
		}
		
		else if(produkt.equals("korbace")) 
		{
			for(Korbace kor : korbaceNaSklade)
			{
				korbaceNaSklade.remove(kor);
				return kor;
				
			}
		}
		return null;
	}
	
	public double getCenaProduktu(String produkt)
	{
		if(produkt.equals("broskynovy")) {
			for(Broskynovy_jogurt jog : broskynoveJogurtyNaSklade)
			{
				return jog.getCena();
			}
		
		}
	
		else if(produkt.equals("jahodovy")) {
				for(Jahodovy_jogurt jog : jahodoveJogurtyNaSklade)
				{
					return jog.getCena();
				}
			
		}
		
		else if(produkt.equals("parenica")) {
			for(Parenica par : pareniceNaSklade)
			{
				return par.getCena();
			}
		
		}
		
		else if(produkt.equals("korbace")) 
		{
			for(Korbace kor : korbaceNaSklade)
			{
				return kor.getCena();	
			}
		}
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public double getPriceSol() {
		return priceSol;
	}


	public void setPriceSol(double priceSol) {
		this.priceSol = priceSol;
	}


	public double getPriceCuk() {
		return priceCuk;
	}


	public void setPriceCuk(double priceCuk) {
		this.priceCuk = priceCuk;
	}


	public double getPriceMilk() {
		return priceMilk;
	}


	public void setPriceMilk(double priceMilk) {
		this.priceMilk = priceMilk;
	}


	public double getPriceJah() {
		return priceJah;
	}


	public void setPriceJah(double priceJah) {
		this.priceJah = priceJah;
	}


	public double getPriceBros() {
		return priceBros;
	}


	public void setPriceBros(double priceBros) {
		this.priceBros = priceBros;
	}


	public int getBroskyne() {
		return broskyne;
	}


	public void setBroskyne(int broskyne) {
		this.broskyne += broskyne;
	}


	public int getJahody() {
		return jahody;
	}


	public void setJahody(int jahody) {
		this.jahody += jahody;
	}


	public int getCukor() {
		return cukor;
	}


	public void setCukor(int cukor) {
		this.cukor += cukor;
	}


	public int getSol() {
		return sol;
	}


	public void setSol(int sol) {
		this.sol += sol;
	}


	public int getMlieko() {
		return mlieko;
	}


	public void setMlieko(int mlieko) {
		this.mlieko += mlieko;
	}

}
