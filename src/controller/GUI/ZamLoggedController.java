package controller.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//import model.employees.Zamestnanec;
//import model.exceptions.*;
//import model.milkfactory.Mliekaren;
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
import model.employees.User;
import model.employees.Zamestnanec;
import model.mliekaren.Mliekaren;

public class ZamLoggedController implements Initializable {
	
	//Mliekaren milkfactory;
	//private Zamestnanec loggedIN;
	private Stage headStage;
	private Mliekaren milkfactory;
	private User loggedIN = null;
	private Zamestnanec logPerson = null;
	
	@FXML private Pane mainPane;
	private Label meno;
	private Label priez;
	private Label plat;
	private Label dostupnost;
	
	private Label name;
	private Label surname;
	private Label paycheck;
	private Label available;
	
	private Button logOut;
	private Button zmenDostup;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.milkfactory = Mliekaren.getDefaultInstance();
		this.loggedIN = milkfactory.getLoggedUser();
		this.logPerson = (Zamestnanec) loggedIN;
		
		meno = new Label("Meno:");
		meno.setLayoutX(50);
		meno.setLayoutY(50);
		
		priez = new Label("Priezvisko:");
		priez.setLayoutX(50);
		priez.setLayoutY(100);
		
		plat = new Label("Mzda:");
		plat.setLayoutX(50);
		plat.setLayoutY(150);
		
		dostupnost = new Label("Dostupnost:");
		dostupnost.setLayoutX(50);
		dostupnost.setLayoutY(200);
		
		
		
		name = new Label();
		name.setLayoutX(150);
		name.setLayoutY(50);
		
		surname = new Label();
		surname.setLayoutX(150);
		surname.setLayoutY(100);
		
		paycheck = new Label();
		paycheck.setLayoutX(150);
		paycheck.setLayoutY(150);
		
		available = new Label();
		available.setLayoutX(150);
		available.setLayoutY(200);
		
		reloadInfo();
		
		
		zmenDostup = new Button("Zmen dostupnost");
		zmenDostup.setOnAction(e -> {
			this.logPerson.changeAvailable(logPerson);
			reloadInfo();
		});
		zmenDostup.setLayoutX(50);
		zmenDostup.setLayoutY(300);
		
		logOut = new Button("Odhlasit sa");
		logOut.setOnAction(e ->{
			try {
				logoutButtonClicked(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		logOut.setLayoutX(50);
		logOut.setLayoutY(350);
	
		mainPane.getChildren().addAll(meno,priez,plat,dostupnost,zmenDostup,logOut);
		mainPane.getChildren().addAll(name,surname,paycheck,available);
		
	}
	
	
	private void reloadInfo()
	{
		if(logPerson. getAvailable())
		{
			available.setText("Dostupny");
		}
		else {
			available.setText("PN");
		}
		paycheck.setText((String.valueOf(logPerson.getMzda()) + " €"));
		surname.setText(loggedIN.getSurname());
		name.setText(loggedIN.getName());
		
	}
	
	public void logoutButtonClicked(ActionEvent event) throws IOException
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
