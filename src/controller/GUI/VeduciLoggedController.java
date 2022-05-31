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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.employees.User;
import model.mliekaren.Mliekaren;

public class VeduciLoggedController implements Initializable{
	
	
	Stage headStage;
	private Mliekaren milkfactory;
	private User loggedIN = null;
	
	
	@FXML private Pane mainPane;
	private Button goToZamestnanci;
	private Button goToKlienti;
	private Button goToSklad;
	private Button logout;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		this.milkfactory = Mliekaren.getDefaultInstance();
		this.loggedIN = milkfactory.getLoggedUser();
		
		goToZamestnanci = new Button("Zamestnanci");
		goToZamestnanci.setLayoutX(100);
		goToZamestnanci.setLayoutY(100);
		goToZamestnanci.setOnAction(e -> {
			try {
				goToZamestnanciTable(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		goToKlienti = new Button("Klienti");
		goToKlienti.setLayoutX(100);
		goToKlienti.setLayoutY(150);
		goToKlienti.setOnAction(e -> {
			try {
				goToKlienti(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		
		goToSklad = new Button("Sklad");
		goToSklad.setLayoutX(100);
		goToSklad.setLayoutY(200);
		goToSklad.setOnAction(e -> {
			try {
				goToSklad(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		logout = new Button("Log Out");
		logout.setLayoutX(50);
		logout.setLayoutY(50);
		logout.setOnAction(e -> {
			try {
				logoutButtonClicked(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		mainPane.getChildren().addAll(goToZamestnanci,goToKlienti, goToSklad, logout );
		
		
		
	}
	
	
	
	
	
	private void logoutButtonClicked(ActionEvent event) throws IOException
	{
		milkfactory.logoutClicked();
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/LoginScene.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	private void goToZamestnanciTable(ActionEvent event) throws IOException
	{
		
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/ZamestnanciTable.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	private void goToSklad(ActionEvent event) throws IOException
	{
		
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/SkladScene.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	private void goToKlienti(ActionEvent event) throws IOException
	{
		
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/KlientiTable.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	
	
	
	
	
	
}
