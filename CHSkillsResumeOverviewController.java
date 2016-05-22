 package fx.application.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import core.skills.Skills;
import fx.application.MainApp;
import fx.application.alert.NotEnoughSkillPointsAlert;
import fx.application.models.Character;
 
public class CHSkillsResumeOverviewController {
	
	Stage stage;
	MainApp mainApp;
	Character character;
	ParentInterfaceController parent;
	
	@FXML private Label Skill1Label;
	@FXML private Label Damage1;
	@FXML private Label Cost1;
	@FXML private Label Skill2Label;
	@FXML private Label Damage2;
	@FXML private Label Cost2;
	@FXML private Label Skill3Label;
	@FXML private Label Damage3;
	@FXML private Label Cost3;
	@FXML private Label Skill4Label;
	@FXML private Label Damage4;
	@FXML private Label Cost4;
	@FXML private Label Skill5Label;
	@FXML private Label Damage5;
	@FXML private Label Cost5;
	@FXML private Label Skill6Label;
	@FXML private Label Damage6;
	@FXML private Label Cost6;
	@FXML private Label Skill7Label;
	@FXML private Label Damage7;
	@FXML private Label Cost7;
	@FXML private Label Skill8Label;
	@FXML private Label Damage8;
	@FXML private Label Cost8;
	@FXML private Label Skill9Label;
	@FXML private Label Damage9;
	@FXML private Label Cost9;
	@FXML private Label Skill10Label;
	@FXML private Label Damage10;
	@FXML private Label Cost10;
	@FXML private Label UltiLabel;
	@FXML private Label UltiDamage;
	@FXML private Label UltiCost;
	@FXML private Label SkillPointsLabel;
	@FXML private Button UP1;
	@FXML private Button UP2;
	@FXML private Button UP3;
	@FXML private Button UP4;
	@FXML private Button UP5;
	@FXML private Button UP6;
	@FXML private Button UP7;
	@FXML private Button UP8;
	@FXML private Button UP9;
	@FXML private Button UP10;
	@FXML private Button UPUlti;
	
	public void initialize(){
		}
	public void UpgradeButton(boolean d){
		if(d){
			UP1.setVisible(false);
			UP2.setVisible(false);
			UP3.setVisible(false);
			UP4.setVisible(false);
			UP5.setVisible(false);
			UP6.setVisible(false);
			UP7.setVisible(false);
			UP8.setVisible(false);
			UP9.setVisible(false);
			UP10.setVisible(false);
			UPUlti.setVisible(false);
		}
		else{
			UP2.setDisable(true);
			UP3.setDisable(true);
			UP4.setDisable(true);
			UP5.setDisable(true);
			UP6.setDisable(true);
			UP7.setDisable(true);
			UP8.setDisable(true);
			UP9.setDisable(true);
			UP10.setDisable(true);
			UPUlti.setDisable(true);
		}
	}
	public void ShowOverview(){
		String d = "Damage : ";
		String c = "Cost : ";
		SkillPointsLabel.setText("Skill points: " + character.GETSkillPoints());
		Skill1Label.setText("||1|| " + character.GETFirst().GETName() + "	(" + character.GETFirst().GETUpgradeInstance() + ")");
		Damage1.setText(d + character.GETFirst().GETDamage());
		Cost1.setText(c + character.GETFirst().GETCost());
		if(character.GETSecond() == null){
			Skill2Label.setText("||2|| --Locked--");
			Damage2.setText(d + "//");
			Cost2.setText(c + "//");
		}
		else{
			Skill1Label.setText("||2|| " + character.GETSecond().GETName() + "	(" + character.GETSecond().GETUpgradeInstance() + ")");
			Damage1.setText(d + character.GETSecond().GETDamage());
			Cost1.setText(c + character.GETSecond().GETCost());
		}

		if(character.GETThird() == null){
			Skill3Label.setText("||3|| --Locked--");
			Damage3.setText(d + "//");
			Cost3.setText(c + "//");
		}
		else{
			Skill3Label.setText("||3|| " + character.GETThird().GETName() + "	(" + character.GETThird().GETUpgradeInstance() + ")");
			Damage3.setText(d + character.GETThird().GETDamage());
			Cost3.setText(c + character.GETThird().GETCost());
		}

		if(character.GETFourth() == null){
			Skill4Label.setText("||4|| --Locked--");
			Damage4.setText(d + "//");
			Cost4.setText(c + "//");
		}
		else{
			Skill4Label.setText("||4|| " + character.GETFourth().GETName() + "	(" + character.GETFourth().GETUpgradeInstance() + ")");
			Damage4.setText(d + character.GETFourth().GETDamage());
			Cost4.setText(c + character.GETFourth().GETCost());
		}

		if(character.GETFifth() == null){
			Skill5Label.setText("||5|| --Locked--");
			Damage5.setText(d + "//");
			Cost5.setText(c + "//");
		}
		else{
			Skill5Label.setText("||5|| " + character.GETFifth().GETName() + "	(" + character.GETFifth().GETUpgradeInstance() + ")");
			Damage5.setText(d + character.GETFifth().GETDamage());
			Cost5.setText(c + character.GETFifth().GETCost());
		}

		if(character.GETSixth() == null){
			Skill6Label.setText("||6|| --Locked--");
			Damage6.setText(d + "//");
			Cost6.setText(c + "//");
		}
		else{
			Skill6Label.setText("||6|| " + character.GETSixth().GETName() + "	(" + character.GETSixth().GETUpgradeInstance() + ")");
			Damage6.setText(d + character.GETSixth().GETDamage());
			Cost6.setText(c + character.GETSixth().GETCost());
		}

		if(character.GETSeventh() == null){
			Skill7Label.setText("||7|| --Locked--");
			Damage7.setText(d + "//");
			Cost7.setText(c + "//");
		}
		else{
			Skill7Label.setText("||7|| " + character.GETSeventh().GETName() + "	(" + character.GETSeventh().GETUpgradeInstance() + ")");
			Damage7.setText(d + character.GETSeventh().GETDamage());
			Cost7.setText(c + character.GETSeventh().GETCost());
		}

		if(character.GETEighth() == null){
			Skill8Label.setText("||8|| --Locked--");
			Damage8.setText(d + "//");
			Cost8.setText(c + "//");
		}
		else{
			Skill8Label.setText("||8|| " + character.GETEighth().GETName() + "	(" + character.GETEighth().GETUpgradeInstance() + ")");
			Damage8.setText(d + character.GETEighth().GETDamage());
			Cost8.setText(c + character.GETEighth().GETCost());
		}

		if(character.GETNinth() == null){
			Skill9Label.setText("||9|| --Locked--");
			Damage9.setText(d + "//");
			Cost9.setText(c + "//");
		}
		else{
			Skill9Label.setText("||9|| " + character.GETNinth().GETName() + "	(" + character.GETNinth().GETUpgradeInstance() + ")");
			Damage9.setText(d + character.GETNinth().GETDamage());
			Cost9.setText(c + character.GETNinth().GETCost());
		}

		if(character.GETTenth() == null){
			Skill10Label.setText("||10|| --Locked--");
			Damage10.setText(d + "//");
			Cost10.setText(c + "//");
		}
		else{
			Skill10Label.setText("||10|| " + character.GETTenth().GETName() + "	(" + character.GETTenth().GETUpgradeInstance() + ")");
			Damage10.setText(d + character.GETTenth().GETDamage());
			Cost10.setText(c + character.GETTenth().GETCost());
		}

		if(character.GETUlti() == null){
			UltiLabel.setText("||0|| --Locked--");
			UltiDamage.setText(d + "//");
			UltiCost.setText(c + "//");
		}
		else{
			UltiLabel.setText("||0|| " + character.GETUlti().GETName() + "	(" + character.GETUlti().GETUpgradeInstance() + ")");
			UltiDamage.setText(d + character.GETUlti().GETDamage());
			UltiCost.setText(c + character.GETUlti().GETCost());
		}
	}

	public void SETParentInterfaceController(ParentInterfaceController c){
		parent = c;
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
	public void SETCharacter(Character c){
		character = c;
	}
	
	public void PUTOk(){
		parent.EnabledButton();
		stage.close();
	}
	public void PUTFullResume(){
		mainApp.ShowFullResume(character, parent);
		stage.close();
	}
	
	public void PUTUpgrade1(){
		if(TestUpgrade()){
			Upgrade(character.GETFirst());
			ShowOverview();
		}
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade2(){
		if(TestUpgrade())
			Upgrade(character.GETSecond());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade3(){
		if(TestUpgrade())
			Upgrade(character.GETThird());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade4(){
		if(TestUpgrade())
			Upgrade(character.GETFourth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade5(){
		if(TestUpgrade())
			Upgrade(character.GETFifth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade6(){
		if(TestUpgrade())
			Upgrade(character.GETSixth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade7(){
		if(TestUpgrade())
			Upgrade(character.GETSeventh());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade8(){
		if(TestUpgrade())
			Upgrade(character.GETEighth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade9(){
		if(TestUpgrade())
			Upgrade(character.GETNinth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgrade10(){
		if(TestUpgrade())
			Upgrade(character.GETTenth());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}
	public void PUTUpgradeUlti(){
		if(TestUpgrade())
			Upgrade(character.GETUlti());
		else
			new NotEnoughSkillPointsAlert(stage).showAndWait();
	}

	public boolean TestUpgrade(){
		return character.GETSkillPoints() > 0;
	}
	private void Upgrade(Skills s){
		s.AskUpgrade();
		int p = character.GETSkillPoints() - 1;
		character.SETSkillPoints(p);
	}
}
