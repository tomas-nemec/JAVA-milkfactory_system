package model.employees;

/**
 * Trieda User obsahuje atributy a metody, ktore su spajane s prihlasovanim do systemu
 * @author tomas
 *
 */
public class User extends Person {
	
	private String login;
	private String password;
	
	public User()
	{
		
	}
	
	
	
	/**
	 * Metoda na kontrolovanie prihlasovacich udajov
	 * @param login - prihlasovacie meno
	 * @param passw	- heslo
	 * @return boolean ci sa parametre zhoduju s prihlasovacimi udajmi objektu 
	 */
	public boolean checkLogin(String login, String passw)
	{
		System.out.println(this.getLogin() + " " + this.getPassword());
		if(login.equals(this.getLogin()) && passw.equals(this.getPassword() ) )
		{
			return true;
		}
		return false;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
