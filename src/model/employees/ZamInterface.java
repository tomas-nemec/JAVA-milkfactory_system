package model.employees;

public interface ZamInterface {
	
	default void changeAvailable(Zamestnanec a) {
		//System.out.println("Zmen dostupnost");
		if(a.available == true) {
			a.available = false;
		}
		else {
			a.available = true;
		}
	}

}
