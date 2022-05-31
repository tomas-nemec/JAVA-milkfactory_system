package controller.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.klienti.Klient;
import model.mliekaren.Mliekaren;

public class KlientInfoController implements Initializable {
	private Stage headStage;
	@FXML private Pane mainPane;
	
	private Mliekaren milkfactory;
	private Klient client;
	
	private Label financieInfo,financie, skladInfo,sklad;
	private Button goToMenu;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		milkfactory = Mliekaren.getDefaultInstance();
		client = ((Klient)milkfactory.getLoggedUser());
		
		goToMenu = new Button("Go to Menu");
		goToMenu.setLayoutX(50);
		goToMenu.setLayoutY(30);
		goToMenu.setOnAction(e -> {
			try {
				goToKlientMenu(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		financieInfo = new Label("Financie:");
		financieInfo.setLayoutX(100);
		financieInfo.setLayoutY(100);
		
		skladInfo = new Label("Produktov:");
		skladInfo.setLayoutX(100);
		skladInfo.setLayoutY(150);
		
		sklad = new Label(String.valueOf(client.pocetProduktov()));
		sklad.setLayoutX(200);
		sklad.setLayoutY(150);
		
		financie = new Label(String.valueOf(client.getFinancie()));
		financie.setLayoutX(200);
		financie.setLayoutY(100);
		
		
		
		mainPane.getChildren().addAll(goToMenu,financieInfo,skladInfo,sklad,financie);
		
		
		
		
		
		
		
		
	}
	
	
	private void goToKlientMenu(ActionEvent event) throws IOException 
	{
		// TODO Auto-generated method stub
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/KlientLogged.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
		
	}
	
	
	

}
