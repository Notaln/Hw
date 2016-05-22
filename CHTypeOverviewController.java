package fx.application.view;

import fx.application.MainApp;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CHTypeOverviewController {
	
	Stage stage;
	MainApp mainApp;
	CHEditOverviewController parent;
	
	public void initialize(){
		
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
	public void SETController(CHEditOverviewController c){
		parent = c;
	}
	
	public void Gunner(){
		parent.SETType("Gunner");
		parent.EnabledButton();
		stage.close();
	}
	public void Martial(){
		parent.SETType("Martial");
		parent.EnabledButton();
		stage.close();
	}
	public void Swordsman(){
		parent.SETType("Swordsman");
		parent.EnabledButton();
		stage.close();
	}
	public void Tank(){
		parent.SETType("Tank");
		parent.EnabledButton();
		stage.close();
	}
	public void Wizard(){
		parent.SETType("Wizard");
		parent.EnabledButton();
		stage.close();
	}
}
