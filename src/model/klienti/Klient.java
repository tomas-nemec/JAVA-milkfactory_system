package model.klienti;

import java.util.ArrayList;

import model.employees.User;
import model.produkty.Parenica;
import model.produkty.Produkt;

//import model.produkty.Produkt;

public class Klient extends User implements Klient_interface, Klient_interface.Klient_interface_nested {
	private double financie;
	private String nazov;
	private ArrayList<Produkt> zakupeneProdukty;
	

	
	
	
	
	
	public Klient() {
		
	}
	
	public Klient(String a, String log, String pass) {
		zakupeneProdukty = new ArrayList<Produkt>();
		this.nazov = a;
		this.setLogin(log);
		this.setPassword(pass);
		this.financie = 1000000;
	}
	
	
	
	

	public String getNazov() {
		return this.nazov;
	}
	
	public int pocetProduktov()
	{
		return zakupeneProdukty.size();
	}
	
	public double getFinancie()
	{
		return financie;
		
	}
	
	public void pridajProduktKlientovi(Produkt a)
	{
		this.zakupeneProdukty.add(a);
	}

	
	@Override
	public void zaplat(double cena) {
		this.financie -= cena;
		
	}
	
	
	

	
	
}
