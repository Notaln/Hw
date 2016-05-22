package fx.application.view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import fx.application.MainApp;
import fx.application.models.Character;

public class CHFullResumeOverviewController {

	Stage stage;
	MainApp mainApp;
	Character character;
	ParentInterfaceController parent;
	
	@FXML
	private Label NameLabel;
	@FXML
	private Label TypeLabel;
	@FXML
	private Label PassiveLabel;
	@FXML
	private Label StateLabel;
	@FXML
	private Label DefenseTypeLabel;
	@FXML
	private Label HPLabel;
	@FXML
	private Label RPLabel;
	@FXML
	private Label CoinsLabel;
	@FXML
	private Label WeaponNameLabel;
	@FXML
	private Label WeaponDamageLabel;
	@FXML
	private Label MainDamageLabel;
	@FXML
	private Label ResistanceLabel;
	@FXML
	private Label HealingPowerLabel;
	@FXML
	private Label StockSizeLabel;
	@FXML
	private Label SkillPointsLabel;
	@FXML
	private Label TargetLabel;
	@FXML
	private Label MainTargetLabel;
	@FXML
	private Label LinkedCharacterLabel;
	@FXML
	private Label DefendedCharacterLabel;
	@FXML
	private Label MobVictoryLabel;
	@FXML
	private Label BossVictoryLabel;
	@FXML
	private Label CharacterVictoryLabel;
	
	
	@FXML
	private void initialize(){
		
	}
	public void ShowOverview(){
		NameLabel.setText(character.GETName());
		TypeLabel.setText(character.GETType());
		PassiveLabel.setText(character.GETPassive());
		StateLabel.setText("");
		DefenseTypeLabel.setText(character.GETDefenseType());
		HPLabel.setText(character.GETHP() + " / " + character.GETHPMax());
		RPLabel.setText(character.GETRP() + " / " + character.GETRPMax());
		CoinsLabel.setText(Integer.toString(character.GETCoins()));
		WeaponNameLabel.setText(character.GETWeaponName());
		WeaponDamageLabel.setText(Integer.toString(character.GETWeaponDamage()));
		MainDamageLabel.setText(Integer.toString(character.GETMainDamage()));
		ResistanceLabel.setText(character.GETResistance() + "% / " + character.GETDefendingResistance() + "%");
		HealingPowerLabel.setText(character.GETHealingPower() + "% / " + character.GETHealingPowerMax() + "%");
		StockSizeLabel.setText(Integer.toString(character.GETStock().GETSize()) + " / " + Integer.toString(character.GETStock().GETMaxSize()));
		SkillPointsLabel.setText(Integer.toString(character.GETSkillPoints()));
		if(character.GETTarget() != null)
			TargetLabel.setText(character.GETTarget().GETName() + " (" + character.GETTarget().GETType() + ")");
		else
			TargetLabel.setText("Unknown");
		if(character.GETMainTarget() != null)
			MainTargetLabel.setText(character.GETMainTarget().GETName() + " (" + character.GETMainTarget().GETType() + ")");
		else
			MainTargetLabel.setText("Unknown");
		if(character.GETLinkedCharacter() != null)
			LinkedCharacterLabel.setText(character.GETLinkedCharacter().GETName() + " (" + character.GETLinkedCharacter().GETType() + ")");
		else
			LinkedCharacterLabel.setText("Unknown");
		if(character.GETDefendedCharacter() != null)
			DefendedCharacterLabel.setText(character.GETDefendedCharacter().GETName() + " (" + character.GETLinkedCharacter().GETType() + ")");
		else
			DefendedCharacterLabel.setText("Unknown");
		MobVictoryLabel.setText(Integer.toString(character.GETMobVictory()));
		BossVictoryLabel.setText(Integer.toString(character.GETBossVictory()));
		CharacterVictoryLabel.setText(Integer.toString(character.GETCharacterVictory()));
		
	}
	
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
	
	@FXML
	private void PUTOk(){
		parent.EnabledButton();
		stage.close();
	}
	@FXML
	private void PUTSkills(){
		mainApp.ShowSkillsResume(character, parent, true);
		stage.close();
	}
}
