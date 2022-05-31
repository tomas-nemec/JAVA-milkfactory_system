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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.mliekaren.Mliekaren;

public class KlientObjednavkaController implements Initializable {
	
	private Mliekaren milkfactory;
	private Stage headStage;
	
	
	@FXML private Pane mainPane;
	
	private Label JahJogLab;
	private Label BrosJogLab;
	private Label KorbaceLab;
	private Label ParenicaLab;
	
	private TextField JahJogTF;
	private TextField BrosJogTF;
	private TextField KorbaceTF;
	private TextField ParenicaTF;
	
	private Button Order;
	private Button BackToKlientMenu;
	private Label infoOrder;
	
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		milkfactory = Mliekaren.getDefaultInstance();
		
		JahJogLab = new Label("Jahodovy jogurt:");
		JahJogLab.setLayoutX(50);
		JahJogLab.setLayoutY(100);
		
		BrosJogLab = new Label("Broskynovy jogurt:");
		BrosJogLab.setLayoutX(50);
		BrosJogLab.setLayoutY(150);
		
		KorbaceLab = new Label("Korbace:");
		KorbaceLab.setLayoutX(50);
		KorbaceLab.setLayoutY(200);
		
		ParenicaLab = new Label("Parenice:");
		ParenicaLab.setLayoutX(50);
		ParenicaLab.setLayoutY(250);
		
		
		JahJogTF = new TextField();
		JahJogTF.setLayoutX(180);
		JahJogTF.setLayoutY(100);
		
		BrosJogTF = new TextField();
		BrosJogTF.setLayoutX(180);
		BrosJogTF.setLayoutY(150);
		
		KorbaceTF = new TextField();
		KorbaceTF.setLayoutX(180);
		KorbaceTF.setLayoutY(200);
			
		ParenicaTF = new TextField();
		ParenicaTF.setLayoutX(180);
		ParenicaTF.setLayoutY(250);
		
		Order = new Button("Objednat");
		Order.setLayoutX(180);
		Order.setLayoutY(290);
		Order.setOnAction(e -> {
			orderButtonClicked();
		});
		
		BackToKlientMenu = new Button("Navrat");
		BackToKlientMenu.setLayoutX(50);
		BackToKlientMenu.setLayoutY(30);
		BackToKlientMenu.setOnAction(e -> {
			try {
				goToKlientMenu(e);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		infoOrder = new Label("info");
		infoOrder.setLayoutX(180);
		infoOrder.setLayoutY(320);
		infoOrder.setVisible(false);
		
		mainPane.getChildren().addAll(JahJogLab,BrosJogLab,KorbaceLab,ParenicaLab,JahJogTF,BrosJogTF,
				KorbaceTF,ParenicaTF,Order,BackToKlientMenu,infoOrder);
		
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
	
	private void orderButtonClicked()
	{
		String empty = "";
		int pocBros = 0;
		int pocJahod = 0;
		int pocKorb = 0;
		int pocPare = 0;
		
		try {
			if(!(JahJogTF.getText().equals(empty))) {
				if(Integer.parseInt(JahJogTF.getText()) >= 0) 
				{
					pocJahod += Integer.parseInt(JahJogTF.getText()); 	
				}
				else {
					throw new Exception();	
				}
				
				
			}
			
			if(!(BrosJogTF.getText().equals(empty))) {
				if(Integer.parseInt(BrosJogTF.getText()) >= 0)
				{
					pocBros += Integer.parseInt(BrosJogTF.getText());
				}
				else {
					System.out.println("BJogurt TXT je zle");
					throw new Exception();
				}
				
			}
			
			if(!(ParenicaTF.getText().equals(empty))) {
				if(Integer.parseInt(ParenicaTF.getText()) >= 0) {
					pocPare += Integer.parseInt(ParenicaTF.getText());
				}
				else {
					System.out.println("PARENICA TXT je zle");
					throw new Exception();
				}
				
			}
			
			if(!(KorbaceTF.getText().equals(empty))) {
				if(Integer.parseInt(KorbaceTF.getText()) >= 0) {
					pocKorb += Integer.parseInt(KorbaceTF.getText());
					
				}
				else {
					System.out.println("KORBACE TXT je zle");
					throw new Exception();
				}
				
			}
			
			// vyroba
			if(milkfactory.vyrobaProduktu(pocJahod ,pocBros , pocPare, pocKorb).equals("Objednane"))
			{
				infoOrder.setText("Objednane");
				milkfactory.vyvozTovaru(pocBros,pocJahod,pocPare,pocKorb);
			}
			else {
				infoOrder.setText("Nedostatok surovin");
			}
			
			
			
			infoOrder.setVisible(true);
			
			
			
			milkfactory.vypisSkladu();
			
			clearField();
			
			
		}
		catch(Exception e) {
			clearField();
			
		}
	}
	
	private void clearField() {
		ParenicaTF.clear();
		KorbaceTF.clear();
		BrosJogTF.clear();
		JahJogTF.clear();
		
		
		
	}
}
