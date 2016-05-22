package fx.application.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import fx.application.MainApp;
import fx.application.models.Character;

public class CHTeamOverviewController {

	Character c;
	MainApp app;
	Stage stage;
	CHOverviewController parent;
	
	@FXML private Label Team;
	@FXML private Label Lvl;
	@FXML private Label L1;
	@FXML private Label L2;
	@FXML private Label L3;
	@FXML private Label Size;
	
	@FXML private Button Members;
	@FXML private Button Create;
	@FXML private Button Rename;
	@FXML private Button Add;
	@FXML private Button Dismiss;
	@FXML private Button Leave;
	@FXML private Button Refresh;
	@FXML private Button Delete;
	@FXML private Button OK;
	
	public void initialize(){
		
	}
	
	public void Show(){
		if(c.GETTeam()!= null){
			Team.setText(c.GETTeamName());
			Lvl.setText(Integer.toString(c.GETTeamLevel()));
			L1.setText(c.GETTeamLeader().GETName());
			L1.setText((c.GETTeamLeader() != null)? c.GETTeamLeader().GETName() : "Non-existant");
			L2.setText((c.GETSecondLeader() != null)? c.GETSecondLeader().GETName() : "Non-existant");
			L3.setText((c.GETThirdLeader() != null)? c.GETThirdLeader().GETName() : "Non-existant");
			Size.setText(c.GETTeamSize() + " / " + c.GETTeamMaxSize());
			Create.setDisable(true);
		}else{
			Members.setDisable(true);
			Rename.setDisable(true);
			Add.setDisable(true);
			Dismiss.setDisable(true);
			Leave.setDisable(true);
			Refresh.setDisable(true);
			Delete.setDisable(true);
		}
	}
	
	public void SETCharacter(Character c){
		this.c = c;
	}
	public void SETStage(Stage s){
		stage = s;
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              parent.EnabledButton();
	          }
	    });
	}
	public void SETMainApp(MainApp app){
		this.app = app;
	}
	public void SETParent(CHOverviewController p){
		parent = p;
	}
	
	public void PUTMembers(){
		
	}
	public void PUTCreate(){
		
	}
	public void PUTRename(){
		
	}
	public void PUTAdd(){
		
	}
	public void PUTDismiss(){
		
	}
	public void PUTLeave(){
		
	}
	public void PUTRefresh(){
		
	}
	public void PUTDelete(){
		
	}
	public void PUTOK(){
		parent.EnabledButton();
		stage.close();
	}
}
