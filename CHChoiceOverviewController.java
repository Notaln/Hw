package fx.application.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import fx.application.MainApp;
import fx.application.alert.NoItemSelectedAlert;
import fx.application.models.Character;

public class CHChoiceOverviewController extends ParentInterfaceController{
	
    @FXML
    private TableView<Character> CHTable;
    @FXML
    private TableColumn<Character, String> TypeColumn;
    @FXML
    private TableColumn<Character, String> NameColumn;
    
    @FXML private Label Resume;
    @FXML private Label NameLabel;
    @FXML
    private Label HealthPointsLabel;
    @FXML
    private Label RustPointsLabel;
    @FXML
    private Label CoinsLabel;
    @FXML
    private Label WeaponNameLabel;
    @FXML
    private Label MainDamageLabel;
    @FXML
    private Label ResistanceLabel;
    @FXML
    private Label HealingPowerLabel;
    @FXML
    private Label TeamNameLabel;
    @FXML
    private Label TeamLevelLabel;
    @FXML
    private Label TeamLeaderLabel;
    @FXML
    private Label TeamSecondLeaderLabel;
    @FXML
    private Label TeamThirdLeaderLabel;
    @FXML
    private Label TeamSizeLabel;
   
    @FXML
    private Button Start;
    @FXML
    private Button FullResume;
    @FXML
    private Button SkillsResume;
    @FXML
    private Button New;
    @FXML
    private Button Rename;
    @FXML
    private Button Delete;
    
    private MainApp mainApp;
    
    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
    	TypeColumn.setCellValueFactory(cellData -> cellData.getValue().TypeProperty());
        NameColumn.setCellValueFactory(cellData -> cellData.getValue().NameProperty());
        
        //Reset details
        ShowOverview(null);
        
        CHTable.getSelectionModel().selectedItemProperty().addListener(
				(observable, oldValue, newValue) -> ShowOverview(newValue));
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     *@param mainApp
     */
    public void SETMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        // Add observable list data to the table
        CHTable.setItems(mainApp.getCharacterData());
    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     *
     * @param person the person or null
     */
    public void ShowOverview(Character c){
    	EnabledButton();
    	if(c != null){
    		Resume.setText(c.GETName() + "'s resume");
	    	NameLabel.setText(c.GETName());
	    	HealthPointsLabel.setText(c.GETHP() + " / " + c.GETHPMax());
	    	RustPointsLabel.setText(c.GETRP() + " / " + c.GETRPMax());
	    	CoinsLabel.setText(Integer.toString(c.GETCoins()));
	    	WeaponNameLabel.setText(c.GETWeaponName());
	    	MainDamageLabel.setText(Integer.toString(c.GETMainDamage()));
	    	ResistanceLabel.setText(c.GETResistance() + "%");
	    	HealingPowerLabel.setText(c.GETHealingPower() + "% / " + c.GETHealingPowerMax() + "%");
	    	if(c.GETTeam() == null){
	    		TeamNameLabel.setText("// No team //");
	    		TeamLevelLabel.setText("");
	    		TeamLeaderLabel.setText("");
		    	TeamSecondLeaderLabel.setText("");
		    	TeamThirdLeaderLabel.setText("");
		    	TeamSizeLabel.setText("");
	    	}
	    	else {
				if(c.GETTeamLeader() != null)
					TeamLeaderLabel.setText("");
				if(c.GETSecondLeader() != null)
					TeamSecondLeaderLabel.setText("");
				if(c.GETThirdLeader() != null)
					TeamThirdLeaderLabel.setText("");
				TeamLevelLabel.setText(Integer.toString(c.GETTeamLevel()));
				TeamSizeLabel.setText(c.GETTeamSize() + " / " + c.GETTeamMaxSize());
			}
    	}
    	else{
    		Resume.setText("");
    		NameLabel.setText("");
	    	HealthPointsLabel.setText("");
	    	RustPointsLabel.setText("");
	    	CoinsLabel.setText("");
	    	WeaponNameLabel.setText("");
            MainDamageLabel.setText("");
	    	ResistanceLabel.setText("");
	    	HealingPowerLabel.setText("");
	    	TeamNameLabel.setText("");
	    	TeamLevelLabel.setText("");
	    	TeamLeaderLabel.setText("");
	    	TeamSecondLeaderLabel.setText("");
	    	TeamThirdLeaderLabel.setText("");
	    	TeamSizeLabel.setText("");
    	}
    }

    public void EnabledButton(){
    	Start.setDisable(false);
    	FullResume.setDisable(false);
    	SkillsResume.setDisable(false);
    	New.setDisable(false);
    	Rename.setDisable(false);
    	Delete.setDisable(false);
    }
    public void DisabledButton(){
    	Start.setDisable(true);
    	FullResume.setDisable(true);
    	SkillsResume.setDisable(true);
    	New.setDisable(true);
    	Rename.setDisable(true);
    	Delete.setDisable(true);
    }
    //Buttons
    @FXML
    private void PUTDelete(){
    	int index = CHTable.getSelectionModel().getSelectedIndex();
    	if(index >= 0)
    		CHTable.getItems().remove(index);
    	else
    		new NoItemSelectedAlert(mainApp.getPrimaryStage()).show();
    }
    @FXML
    private void PUTRename(){
    	
    	//Character selected
    	Character character = CHTable.getSelectionModel().getSelectedItem();
    	if(character != null){
    		DisabledButton();
    		if(mainApp.ShowRenameOverview(character, this))
    			ShowOverview(character);
    	}
    	else
    		//NO Selection
    		new NoItemSelectedAlert(mainApp.getPrimaryStage()).showAndWait();
    }
    @FXML
    private void PUTNew(){
    	DisabledButton();
    	mainApp.ShowEditOverview(this);
    }
    @FXML
    private void PUTFullResume(){
    	Character character = CHTable.getSelectionModel().getSelectedItem();
    	if(character != null){
    		DisabledButton();
    		mainApp.ShowFullResume(character, this);
    	}
    	else
    		//NO Selection
    		new NoItemSelectedAlert(mainApp.getPrimaryStage()).show();
    }
    @FXML
    private void PUTSkillsResume(){
    	Character character = CHTable.getSelectionModel().getSelectedItem();
    	if(character != null){
    		DisabledButton();
    		mainApp.ShowSkillsResume(character, this, true);
    	}
    	else
    		//NO Selection
    		new NoItemSelectedAlert(mainApp.getPrimaryStage()).showAndWait();
    }
    @FXML
    private void PUTStart(){
    	Character character = CHTable.getSelectionModel().getSelectedItem();
    	if(character != null){
    		mainApp.ShowCharacterOverview(character, this);
    		DisabledButton();
    	}
    	else
    		//NO Selection
    		new NoItemSelectedAlert(mainApp.getPrimaryStage()).showAndWait();
    	
    }

}