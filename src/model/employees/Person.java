package model.employees;

/**
 * Datum: 14.5.2021 
 * Abstraktna trieda so zakladnymi atributmi pre osobu
 * @author Tomas Nemec
 * @version 2.0
 * 
 */
abstract class Person {
	
	private String name;
	private String surname;
	
	
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
