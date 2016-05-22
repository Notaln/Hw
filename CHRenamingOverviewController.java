package fx.application.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import core.skills.Skills;
import fx.application.MainApp;
import fx.application.alert.EmptyFieldAlert;
import fx.application.models.Character;

public class CHRenamingOverviewController {

	private ParentInterfaceController parent;
	private Stage stage;
	private MainApp mainApp;
	private Character character;
	private Skills skill;
	private boolean okClicked = false;

	@FXML
	public TextField NameField;
	
	@FXML
	private void initialize(){}
	
	public void SETParentInterfaceController(ParentInterfaceController p){
		parent = p;
	}
	public void SETMainApp(MainApp app){
		mainApp = app;
	}
	public void SETStage(Stage stage) {
        this.stage = stage;
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              parent.EnabledButton();
	          }
	    });
    }
	public void SETCharacter(Character c){
		this.character = c;
	}
	public void SETSkill(Skills s){
		skill = s;
	}
	
	public boolean isOkClicked() {
        return okClicked;
    }
	
	@FXML private void PUTSetName(){
		String error = "";
		if(NameField.getText() == null || NameField.getText().length() == 0)
			error += "No valid name";
		else{
			character.SETName(NameField.getText());
			parent.EnabledButton();
			stage.close();
		}
		if(error != "")
			new EmptyFieldAlert(stage).showAndWait();
		
		okClicked = true;
	}
	@FXML private void PUTCancel(){
		parent.EnabledButton();
		stage.close();
	}
}
