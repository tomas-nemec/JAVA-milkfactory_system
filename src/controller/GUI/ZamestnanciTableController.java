package controller.GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;

import model.employees.Zamestnanec;
import model.exceptions.*;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javafx.stage.Stage;

public class ZamestnanciTableController implements Initializable{

	private Mliekaren milkfactory; 
	
	//configure the table
    @FXML private TableView<Zamestnanec> tableView;
    
    @FXML private TableColumn<Zamestnanec, String> menoColumn;
    @FXML private TableColumn<Zamestnanec, String> priezColumn;
    @FXML private TableColumn<Zamestnanec, Double> ucetColumn;
    @FXML private TableColumn<Zamestnanec, Boolean> avaiColumn;
    
    
    @FXML private TextField menoTextField;
    @FXML private TextField priezTextField;
    @FXML private TextField passTextField;
    @FXML private TextField loginTextField;
    @FXML private Label exceptionLabel;
    
    
  /// CHoice BOx
    @FXML private ChoiceBox<String> positionBox;
    ObservableList<String> position = FXCollections.observableArrayList();
    
    
    
    
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
	
    
   
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		milkfactory = Mliekaren.getDefaultInstance();
		
		loadChoiceBox();
		
		//nasetapuj colonky v tabulke
        menoColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priezColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        ucetColumn.setCellValueFactory(new PropertyValueFactory<>("ucet"));
        avaiColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        
        //nacitaj data ludi
        tableView.setItems(getPeople(milkfactory));
        
        tableView.setEditable(true);
        exceptionLabel.setVisible(false);
        
		
	}
	
	
	public void addZamButtonPushed()
    {
		
        String empty = "";
        
    	try {
    		  if(passTextField.getText().equals(loginTextField.getText())) {
    			  throw new ZhodneLoginHesloException("Zhodne meno a heslo");
    		  }
    		  else {
    			  if(!(menoTextField.getText().equals(empty)) && !(priezTextField.getText().equals(empty))&& !(loginTextField.getText().equals(empty)) && !(passTextField.getText().equals(empty)))
                  {
          			milkfactory.pridajZam(positionBox.getValue(), menoTextField.getText(), priezTextField.getText(),loginTextField.getText(),passTextField.getText());
          			this.cleanTextField();
          			exceptionLabel.setVisible(false);
                  }
    		  }
           
    		
    	}catch(ZhodneLoginHesloException e) {
    		exceptionLabel.setText(e.getMessage());
    		exceptionLabel.setVisible(true);
    		
    		
    		
    	}
		
        
        
        
        tableView.setItems(getPeople(milkfactory));
    }
	
	public void removeZamPushed()
    {
        ObservableList<Zamestnanec> selectedRows;
       
        //this gives us the rows that were selected
        selectedRows = tableView.getSelectionModel().getSelectedItems();
        milkfactory.vyhodZam(selectedRows);
        //milkfactory.vypisZam();
        tableView.setItems(getPeople(milkfactory));
        
    }
	
	public void vyplataClicked() 
	{
		milkfactory.vyplata();
		tableView.refresh();	
	}
	
	public ObservableList<Zamestnanec>  getPeople(Mliekaren a)
    {
        ObservableList<Zamestnanec> osoby = FXCollections.observableArrayList(a.getZoznamZamestnancov());
        return osoby;
    }
	
	private void loadChoiceBox()
	{
		String a ="Syrar";
		String b = "Jogurtar";
		String c = "Rozvazac";
		positionBox.setValue(a);
		positionBox.getItems().addAll(a,b,c);
	}
	
	private void cleanTextField() {
		menoTextField.clear();
        priezTextField.clear();
        passTextField.clear();
        loginTextField.clear();
	}
	
	

}


