package model.exceptions;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Vynimka extends Throwable {

	public Vynimka()
	{
		Stage chyba = new Stage();
		chyba.setTitle("Hlásim chybu");
		FlowPane pane = new FlowPane();
		Scene scena = new Scene(pane,200,50);
		Label text = new Label("Chybný vstup");
		pane.getChildren().add(text);
		chyba.setScene(scena);
		chyba.show();
		
	}
}
