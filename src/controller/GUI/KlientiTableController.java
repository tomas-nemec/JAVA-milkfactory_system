package controller.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.employees.Zamestnanec;
import model.exceptions.ZhodneLoginHesloException;
import model.klienti.Klient;
import model.mliekaren.Mliekaren;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class KlientiTableController implements Initializable{
	
	Mliekaren milkfactory;
	private Zamestnanec loggedIN;
	
	Stage headStage;
	
	@FXML private Pane mainPane;
	private VBox vbox;
	private HBox hbox;
	
	private TableView<Klient> table;
	private TableColumn<Klient,String> nameColumn;
	
	private TextField nazovKlient, login, password;
	private Button addButton,removeButton;
	
	
	
	
	
	
	private Button mainMenu;
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		milkfactory = Mliekaren.getDefaultInstance();
		vbox = new VBox();
		hbox = new HBox();
		table = new TableView<>();
		//TAbulka
		nameColumn = new TableColumn<>("Spolocnost");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("nazov"));
		
		table.setItems(getKlient(milkfactory));
		table.getColumns().addAll(nameColumn);
		
		
		
		mainMenu = new Button("Back to main menu");
		mainMenu.setOnAction(e -> {
			try {
				changeToMainMenu(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		mainMenu.setLayoutX(400);
		mainMenu.setLayoutY(450);
		
		
		//others
		nazovKlient = new TextField();
		nazovKlient.setPromptText("Nazov");
		
		login = new TextField();
		login.setPromptText("Login");
		
		password = new TextField();
		password.setPromptText("Password");
		
		addButton = new Button("Add");
		addButton.setOnAction(e ->{
			this.addButtonClicked();
		});
		removeButton = new Button("Remove");
		removeButton.setOnAction(e -> {
			this.deleteButtonClicked();
		});
		
		
		
		
		hbox.getChildren().addAll(nazovKlient,login,password,addButton,removeButton);		
		vbox.getChildren().addAll(table,hbox);
		mainPane.getChildren().add(vbox);
		mainPane.getChildren().addAll(mainMenu);
	
		
		
	}
	
	
	
	public void deleteButtonClicked()
    {
        ObservableList<Klient> selectedRow;
       
        
        selectedRow = table.getSelectionModel().getSelectedItems();
        milkfactory.vyhodKlienta(selectedRow);
        
        table.setItems(getKlient(milkfactory));
        
    }




	public void addButtonClicked()
    {
		
        String empty = "";
        
        try {
        	if(!(nazovKlient.getText().equals(empty)) && !(login.getText().equals(empty)) && !(password.getText().equals(empty)) ) {
          		milkfactory.pridajKlienta(nazovKlient.getText(), login.getText(),password.getText());
          		this.nazovKlient.clear();
          		this.login.clear();
          		this.password.clear();
            }
        	table.setItems(getKlient(milkfactory));
        }
        catch(Exception e) {
        	System.out.println("KLIENT OSETRENIE VSTUPU");
        }
        
    		
    }
	
	
	//DATA PART
	public ObservableList<Klient> getKlient(Mliekaren a){
		ObservableList<Klient> klienti = FXCollections.observableArrayList(a.getZoznamKlientov());
		return klienti;	
	}
	
	
	
	public void changeToMainMenu(ActionEvent event) throws IOException
    {
    	Stage headStage = null;
		Parent ViewParent = FXMLLoader.load(getClass().getResource("/view/scenes/VeduciLogged.fxml"));
        Scene ViewScene = new Scene(ViewParent);
        ViewScene.getStylesheets().add(getClass().getResource("/view/scenes/application.css").toExternalForm());
        
        headStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        headStage.setScene(ViewScene);
        headStage.show();
    }
	
	

}
