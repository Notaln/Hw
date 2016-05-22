package fx.application.view;

import fx.application.MainApp;
import fx.application.alert.NoItemSelectedAlert;
import fx.application.alert.NoTargetAlert;
import fx.application.models.Character;
import fx.application.models.Gunner;
import fx.application.models.Swordsman;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class CHOverviewController extends ParentInterfaceController{
	
	CHChoiceOverviewController parent;
	Character character;
	Stage stage;
	MainApp app;
	
	@FXML private TableView<Character> CHTable;
	@FXML private TableColumn<Character, String> TypeColumn;
	@FXML private TableColumn<Character, String> NameColumn;
	@FXML private Label Name;
	@FXML private Label Type;
	@FXML private Label WeaponName;
	@FXML private Label HP;
	@FXML private Label RP;
	@FXML private Label Coins;
	@FXML private Button Attack;
	@FXML private Button Attack2;
	@FXML private Button UseSkill;
	@FXML private Button Defend;
	@FXML private Button StopDefend;
	@FXML private Button TeamResume;
	@FXML private Button SkillsResume;
	@FXML private Button Inventory;
	@FXML private Button FullResume;
	
 	public void initialize(){
 		TypeColumn.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
	}
 	public void ShowOverview(){
		Name.setText(character.GETName());
		Type.setText(character.GETType());
		WeaponName.setText(character.GETWeaponName());
		HP.setText(character.GETHP() + "/" + character.GETHPMax());
		RP.setText(character.GETRP() + "/" + character.GETRPMax());
		Coins.setText(Double.toString(character.GETCoins()));
	}
	
	public void SETParent(CHChoiceOverviewController p){
		parent = p;
	}
	public void SETCharacter(Character c){
		character = c;
		if(!(character instanceof Swordsman) && !(character instanceof Gunner)){
			Attack2.setDisable(true);
			System.out.println("a");
		}
	}
	public void SETMainApp(MainApp a){
		app = a;
		 ObservableList<Character> chData = FXCollections.observableArrayList(app.getCharacterData());
		 chData.remove(character);
		 CHTable.setItems(chData);
	}
	public void SETStage(Stage s){
		stage = s;
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	          public void handle(WindowEvent we) {
	              parent.EnabledButton();
	          }
	    });
	}
	
	public void PUTAttack(){
		if(CHTable.getSelectionModel().getSelectedItem() != null || character.GETTarget() != null){
			if(character.GETTarget() != null)
				character.Attack();
			else
				character.Attack(CHTable.getSelectionModel().getSelectedItem());
		}
		else
			new NoTargetAlert(stage).showAndWait();
	}
	public void PUTAttack2(){
		
	}
	public void PUTUseSkill(){
		
	}
	public void PUTDefend(){
		
	}
	public void PUTStopDefend(){
		
	}
	
	public void PUTTeam(){
		app.ShowCHTeamOverview(character, this);
		DisabledButton();
	}
	public void PUTSkillsResume(){
		DisabledButton();
		app.ShowSkillsResume(character, this, false);
	}
	public void PUTSkills(){
		
	}
	public void PUTInventory(){
		
	}
	public void PUTResume(){
		DisabledButton();
		app.ShowFullResume(character, this);
	}
	
	public void DisabledButton(){
		Attack.setDisable(true);
		UseSkill.setDisable(true);
		Defend.setDisable(true);
		StopDefend.setDisable(true);
		TeamResume.setDisable(true);
		SkillsResume.setDisable(true);
		Inventory.setDisable(true);
		FullResume.setDisable(true);
	}
	public void EnabledButton(){
		Attack.setDisable(false);
		UseSkill.setDisable(false);
		Defend.setDisable(false);
		StopDefend.setDisable(false);
		TeamResume.setDisable(false);
		SkillsResume.setDisable(false);
		Inventory.setDisable(false);
		FullResume.setDisable(false);
	}
}
