package model.exceptions;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ZhodneLoginHesloException extends Exception{

	public ZhodneLoginHesloException() {
		super("POZOR! Zhodny LOGIN a HESLO");
	}
	
	public ZhodneLoginHesloException(String message) {
		super(message);
	}
	
	
	
}
