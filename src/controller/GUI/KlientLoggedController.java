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

public class KlientLoggedController implements Initializable{
	
	@FXML private Pane mainPane;
	Stage headStage;
	private Mliekaren milkfactory;
	private User loggedIN = null;
	
	private Button order;
	private Button info;
	private Button logout;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		this.milkfactory = Mliekaren.getDefaultInstance();
		this.loggedIN = milkfactory.getLoggedUser();
		
		order = new Button("Objednavka");
		order.setLayoutX(100);
		order.setLayoutY(150);
		order.setOnAction(e -> {
			try {
				goToObjednavka(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		
		info = new Button("Info");
		info.setLayoutX(100);
		info.setLayoutY(200);
		info.setOnAction(e -> {
			try {
				goToInfo(e);
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
		
		mainPane.getChildren().addAll(order,info, logout);
		
	}
	
	
	private void goToObjednavka(ActionEvent event) throws IOException 
	{
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/KlientObjednavka.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	private void goToInfo(ActionEvent event) throws IOException 
	{
		Parent Parent = FXMLLoader.load(getClass().getResource("/view/scenes/KlientInfo.fxml"));
        Scene ViewScene = new Scene(Parent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
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

}
