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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.employees.User;
import model.employees.Veduci_mliekarne;
import model.employees.*;
import model.klienti.*;
import model.mliekaren.Mliekaren;

public class LoginSceneController implements Initializable {
	
	@FXML private Pane mainPane;
	
	 
	
	private Button loginMenuLoginButton;
	private PasswordField password;
	private TextField username;
	private Label loginLabel;
	private Label passwordLabel;
	
	private Stage headStage = null;
	private Mliekaren milkfactory;
	private User loggedIN = null;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		milkfactory = Mliekaren.getDefaultInstance();
		
		
		
		loginMenuLoginButton = new Button("Log In");
		loginMenuLoginButton.setLayoutX(260);
		loginMenuLoginButton.setLayoutY(236);
		loginMenuLoginButton.setOnAction( e-> {
			System.out.println("Ahoj");
			try {
				loginButtonClicked(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		password = new PasswordField();
		password.setLayoutX(220);
		password.setLayoutY(200);
		password.setPromptText("password");
		password.setText("pass");
		
		username = new TextField();
		username.setLayoutX(220);
		username.setLayoutY(150);
		username.setPromptText("username");
		username.setText("veduci");
		
		loginLabel = new Label("Login:");
		loginLabel.setLayoutX(150);
		loginLabel.setLayoutY(150);
		
		passwordLabel = new Label("Password:");
		passwordLabel.setLayoutX(150);
		passwordLabel.setLayoutY(200);
		
		mainPane.getChildren().addAll(loginMenuLoginButton,password,username,loginLabel,passwordLabel);
		
		
			
	}
	
	private void loginButtonClicked(ActionEvent event) throws IOException
	{
		loggedIN = milkfactory.login(username.getText(), password.getText());
		//System.out.println(loggedIN.getLogin() + "  " + loggedIN.getPassword());
		if(loggedIN == null)
		{
			System.out.println("LoggedIN je null");
		}
	
		if(loggedIN instanceof Veduci_mliekarne) {
			veduciLoggedIn(event);
		}
		else if(loggedIN instanceof Syrar || loggedIN instanceof Rozvazac || loggedIN instanceof Jogurtar) {
			zamestanecLoggedIn(event);
		}
		else if(loggedIN instanceof Klient)
		{
			klientLoggedIn(event);
		}
		

		
	}
	
	
	private void veduciLoggedIn(ActionEvent event) throws IOException 
	{
		Parent ViewParent = FXMLLoader.load(getClass().getResource("/view/scenes/VeduciLogged.fxml"));
        Scene ViewScene = new Scene(ViewParent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	
	
	private void zamestanecLoggedIn(ActionEvent event) throws IOException
    {
		Parent ViewParent = FXMLLoader.load(getClass().getResource("/view/scenes/ZamLogged.fxml"));
        Scene ViewScene = new Scene(ViewParent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
    }
	
	
	
	private void klientLoggedIn(ActionEvent event) throws IOException
	{
		Parent ViewParent = FXMLLoader.load(getClass().getResource("/view/scenes/KlientLogged.fxml"));
        Scene ViewScene = new Scene(ViewParent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());

        //This line gets the Stage information
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
	}
	
	

}
