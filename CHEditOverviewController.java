package fx.application.view;

import fx.application.MainApp;
import fx.application.alert.EmptyFieldAlert;
import fx.application.models.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CHEditOverviewController {

	private MainApp mainApp;
	private Stage stage;
	private ParentInterfaceController parent;
	
	@FXML private TextField Name;
	@FXML private TextField Type;
	@FXML private Button OK;
	@FXML private Button Cancel;
	
	public void initialize(){
		
	}
	public void EnabledButton(){
		OK.setDisable(false);
		Cancel.setDisable(false);
	}
	
	public void SETParentInterfaceController(ParentInterfaceController p){
		parent = p;
	}
	public void SETMainApp(MainApp app){
		mainApp = app;
	}
	public void SETStage(Stage s){
		stage = s;
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              parent.EnabledButton();
	          }
	    });
	}
	public void SETType(String t){
		Type.setText(t);
	}
	
	public void ChooseType(){
		OK.setDisable(true);
		Cancel.setDisable(true);
		mainApp.ShowCHTypeOverview(this);
	}
	public void PUTOk(){
		if(Name.getText() == null || Name.getText().length() != 0){
			if(Type.getText() != null || Type.getText().length() != 0){
				switch(Type.getText()){
					case "Gunner" : mainApp.getCharacterData().add(new Gunner(Name.getText())); stage.close(); break;
					case "Martial" : mainApp.getCharacterData().add(new Martial(Name.getText())); stage.close(); break;
					case "Swordsman" : mainApp.getCharacterData().add(new Swordsman(Name.getText())); stage.close(); break;
					case "Tank" : mainApp.getCharacterData().add(new Tank(Name.getText())); stage.close(); break;
					case "Wizard" : mainApp.getCharacterData().add(new Wizard(Name.getText())); stage.close(); break;
				}
			}
		}
		else
			new EmptyFieldAlert(stage).showAndWait();
			
	}
	public void PUTCancel(){
		parent.EnabledButton();
		stage.close();
	}
}
