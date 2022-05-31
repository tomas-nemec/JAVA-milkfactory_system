package controller.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import model.employees.Zamestnanec;
import model.exceptions.*;
import model.mliekaren.Mliekaren;
import model.sklad.Sklad;
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
import javafx.stage.Stage;

public class SkladController implements Initializable {

	Mliekaren milkfactory;
	Sklad sklad;
	
	//LEFT SIDE
	@FXML private Label broskyneLab;
	@FXML private Label jahodyLab;
	@FXML private Label cukorLab;
	@FXML private Label mliekoLab;
	@FXML private Label solLab;
	@FXML private Label oznam;
    ///	OBJEDNAJ	///
    @FXML private TextField cukorTextField;
    @FXML private TextField mliekoTextField;
    @FXML private TextField jahodyTextField;
    @FXML private TextField broskyneTextField;
    @FXML private TextField solTextField; 
    
    
    @FXML private Label LabFinancie;
    
    

    
    
  
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		milkfactory = Mliekaren.getDefaultInstance();
		
		sklad = milkfactory.getSklad();
		nacitajHod();
		oznam.setVisible(false);
		
		
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
	
	public void objednajClicked() {
		String empty = "";
		//milkfactory.vykonajPracu();		//toto bolo iba na ukazku ci funguje praca zamestnancov
		double vydavky =0;
		try {
			if(!(cukorTextField.getText().equals(empty))) {
				if(Integer.parseInt(cukorTextField.getText()) >= 0) {
					sklad.setCukor(Integer.parseInt(cukorTextField.getText()));	
					vydavky += Integer.parseInt(cukorTextField.getText()) * sklad.getPriceCuk();
				}
				else {
					throw new Exception();	
				}
				
				
			}
			
			if(!(mliekoTextField.getText().equals(empty))) {
				if(Integer.parseInt(mliekoTextField.getText()) >= 0) {
					sklad.setMlieko(Integer.parseInt(mliekoTextField.getText()));
					vydavky += Integer.parseInt(mliekoTextField.getText()) * sklad.getPriceMilk();
				}
				else {
					throw new Exception();
				}
				
			}
			
			if(!(jahodyTextField.getText().equals(empty))) {
				if(Integer.parseInt(jahodyTextField.getText()) >= 0) {
					sklad.setJahody(Integer.parseInt(jahodyTextField.getText()));
					vydavky += Integer.parseInt(jahodyTextField.getText()) * sklad.getPriceJah();
				}
				else {
					throw new Exception();
				}
				
			}
			
			if(!(broskyneTextField.getText().equals(empty))) {
				if(Integer.parseInt(broskyneTextField.getText()) >= 0) {
					sklad.setBroskyne(Integer.parseInt(broskyneTextField.getText()));
					vydavky += Integer.parseInt(broskyneTextField.getText()) * sklad.getPriceBros();
				}
				else {
					throw new Exception();
				}
				
			}
			
			if(!(solTextField.getText().equals(empty))) {
				if(Integer.parseInt(solTextField.getText()) >= 0) {
					sklad.setSol(Integer.parseInt(solTextField.getText()));
					vydavky += Integer.parseInt(solTextField.getText()) * sklad.getPriceSol();
				}
				else {
					
					throw new Exception();
				}
				
			}
			
			milkfactory.setRemoveFinancie(vydavky);
			clearFieldLeft();
			nacitajHod();
			oznam.setText("Zasoby objednane");
			oznam.setVisible(true);
			
		}
		catch(Exception e) {
			clearFieldLeft();
			oznam.setText("Nespravny vstup");
			oznam.setVisible(true);
			System.out.println("Nezadal si cislo");
		}
	}
	
	
	
	
	
	
	
	
	
	
	


	private void nacitajHod() {
		//LEFT
		cukorLab.setText(String.valueOf(sklad.getCukor()));
		mliekoLab.setText(String.valueOf(sklad.getMlieko()));
		jahodyLab.setText(String.valueOf(sklad.getJahody()));
		broskyneLab.setText(String.valueOf(sklad.getBroskyne()));
		solLab.setText(String.valueOf(sklad.getSol()));
		
		aktFinancie();
		
		
		
	}
	
	private void clearFieldLeft() {
		solTextField.clear();
		broskyneTextField.clear();
		jahodyTextField.clear();
		mliekoTextField.clear();
		cukorTextField.clear();
	}
	
	private void aktFinancie() {
		LabFinancie.setText(String.valueOf(milkfactory.getFinancie()));
	}
	
	
	
	
	

}


