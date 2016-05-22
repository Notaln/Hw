package fx.application.models;

import core.enums.CharacterType;
import core.skills.MainSkills;
import core.skills.UltimateSkills;
import core.utilitary.Stock;
import core.weapons.Weapon;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Character extends TargetableEntity{
	protected StringProperty _weaponName, _passive, _defenseType;
	protected CharacterType Type;
	protected DoubleProperty _healingPower, _healingPowerMax;
	protected IntegerProperty _rustPoints, _rustPointsMax, _coins, _skillPoints,
			_mobVictory, _bossVictory, _characterVictory, _weaponDamage;
	protected BooleanProperty  _isDefendingAnother, _isRusty, _allSkillsUnblocked;
	protected ObjectProperty<Character> _linkedCharacter, _defendedCharacter;
	protected ObjectProperty<MainSkills> _firstS, _secondS, _thirdS, _fourthS, _fifthS, _sixthS,
	_seventhS, _eighthS, _ninthS, _tenthS;
	protected ObjectProperty<UltimateSkills> _ulti;
	protected ObjectProperty<Weapon> _weapon;
	protected ObjectProperty<Stock> _stock;
	protected ObjectProperty<TargetableEntity> _mainTarget, _target;
	protected ObjectProperty<Team> _team;
	
	public Character(String n){
		
		super(n, 5);
		
		this.Type = TypeConstructor();
		this._type = new SimpleStringProperty(Type.Name());
		this._healingPower = _healingPowerMax = new SimpleDoubleProperty(Type.HealingPower());
		this._healthPoints = new SimpleDoubleProperty(Type.HealPointsMax());
		this._resistance = this._basicResistance = new SimpleDoubleProperty(Type.Resistance());
		this._defendingResistance = new SimpleDoubleProperty(_resistance.get()*3);
		this._healingPower = this._healingPowerMax = new SimpleDoubleProperty(Type.HealingPower());
		this._healthPointsMax = new SimpleIntegerProperty(Type.HealPointsMax());
		this._rustPoints = this._coins = _skillPoints = 
				 this._mobVictory = this._bossVictory = 
				 this._characterVictory =new SimpleIntegerProperty(0);
		this._rustPointsMax = new SimpleIntegerProperty(8000);
		this._isDefendingAnother = this._isRusty =
				this._allSkillsUnblocked = new SimpleBooleanProperty(false);
		this._linkedCharacter = this._defendedCharacter = new SimpleObjectProperty<Character>(null);
		this._target = this._mainTarget = new SimpleObjectProperty<TargetableEntity>(null);
		this._secondS = this._thirdS = this._fourthS = this._fifthS = this._sixthS = this._seventhS =
				this._eighthS = this._ninthS = this._tenthS = new SimpleObjectProperty<MainSkills>(null);
		this._ulti = new SimpleObjectProperty<UltimateSkills>(null);
		this.SetFirstSkill();
		this.SetFirstWeapon();
		this._weaponName = new SimpleStringProperty(_weapon.get().GETName());
		this._weaponDamage = new SimpleIntegerProperty(_weapon.get().GETDamage());
		this._mainDamage = new SimpleIntegerProperty(Type.MainDamage() + _weaponDamage.get());
		this._stock = new SimpleObjectProperty<Stock>(new Stock());
		this._team = new SimpleObjectProperty<Team>(null);
	}
	
	private CharacterType TypeConstructor(){
		if(this instanceof Swordsman){
			_defenseType = new SimpleStringProperty("Swordsblock");
			_passive = new SimpleStringProperty("+5% damages to character");
			return CharacterType.ApprenticeSwordsman;
		}
		else if(this instanceof Tank){
			_defenseType = new SimpleStringProperty("Shield");
			_passive = new SimpleStringProperty("+5% resistance against monsters or boss");
			return CharacterType.ApprenticeTank;
		}
		else if(this instanceof Wizard){
			_defenseType = new SimpleStringProperty("Barrier");
			_passive = new SimpleStringProperty("+5% damages to monsters or boss");
			return CharacterType.ApprenticeWizard;
		}
		else if(this instanceof Martial){
			_defenseType = new SimpleStringProperty("Fists");
			_passive = new SimpleStringProperty ("2% of resistance per grade");
			return CharacterType.ApprenticeMartial;
		}
		else if(this instanceof Gunner){
			_defenseType = new SimpleStringProperty("Gunsblock");
			_passive = new SimpleStringProperty("+3% damages");
			return CharacterType.ApprenticeGunner;
		}
		else
			return null;
	}
	
	//String
	
	public String GETPassive(){
		return _passive.get();
	}
	public void SETPassive(String p){
		_passive.set(p);
	}
	public StringProperty PassiveProperty(){
		return _passive;
	}
	public String GETDefenseType(){
		return _defenseType.get();
	}
	public void SETDefenseType(String t){
		_defenseType.set(t);
	}
	public StringProperty DefenseTypeProperty(){
		return _defenseType;
	}
	public String GETWeaponName(){
		return _weaponName.get();
	}
	public void SETWeaponName(String n){
		this._weaponName.set(n);
	}
	public StringProperty WeaponNameProperty(){
		return _weaponName;
	}
	
	public double GETHealingPower(){
		return _healingPower.get();
	}
	public void SETHealingPower(double h){
		_healingPower.set(h);
	}
	public DoubleProperty HealingPowerProperty(){
		return _healingPower;
	}
	public double GETHealingPowerMax(){
		return _healingPowerMax.get();
	}
	public void SETHealingPowerMax(double h){
		_healingPowerMax.set(h);
	}
	public DoubleProperty HealingPowerMaxProperty(){
		return _healingPowerMax;
	}
	
	//HP
	public double GETHP(){
		return _healthPoints.get();
	}
	public void SETHP(double h){
		_healthPoints.set(h);
	}
	public DoubleProperty HealthPointsProperty(){
		return _healthPoints;
	}
	public int GETHPMax(){
		return _healthPointsMax.get();
	}
	public void SetHealthPointsMax(int h){
		_healthPointsMax.set(h);
	}
	public IntegerProperty HealthPointsMaxProperty(){
		return _healthPointsMax;
	}
	
	//Resistance
	public double GETResistance(){
		return _resistance.get();
	}
	public void SETResistance(double r){
		_resistance.set(r);
	}
	public DoubleProperty ResistanceProperty(){
		return _resistance;
	}
	public double GETBasicResistance(){
		return _basicResistance.get();
	}
	public void SETBasicResistance(double r){
		_basicResistance.set(r);
	}
	public DoubleProperty BasicResistanceProperty(){
		return _basicResistance;
	}
	public double GETDefendingResistance(){
		return _defendingResistance.get();
	}
	public void SETDefendingResistance(double r){
		_defendingResistance.set(r);
	}
	public DoubleProperty DefendingResistanceProperty(){
		return _defendingResistance;
	}

	public int GETRP(){
		return _rustPoints.get();
	}
	public void SETRP(int r){
		_rustPoints.set(r);
	}
	public IntegerProperty RustPointsProperty(){
		return _rustPoints;
	}
	public int GETRPMax(){
		return _rustPointsMax.get();
	}
	public void SETRPMax(int r){
		_rustPointsMax.set(r);
	}
	public IntegerProperty RustPointsMaxProperty(){
		return _rustPointsMax;
	}
	public int GETCoins(){
		return _coins.get();
	}
	public void SETCoins(int r){
		_coins.set(r);
	}
	public IntegerProperty CoinsProperty(){
		return _coins;
	}
	public int GETSkillPoints(){
		return _skillPoints.get();
	}
	public void SETSkillPoints(int r){
		_skillPoints.set(r);
	}
	public IntegerProperty SkillPointsProperty(){
		return _skillPoints;
	}
	public int GETMainDamage(){
		return _mainDamage.get();
	}
	public void SETMainDamage(int d){
		_mainDamage.set(d);
	}
	public IntegerProperty MainDamageProperty(){
		return _mainDamage;
	}
	
	//Victory
	public int GETMobVictory(){
		return _mobVictory.get();
	}
	public void SETMobVictory(int r){
		_mobVictory.set(r);
	}
	public IntegerProperty MobVictoryProperty(){
		return _mobVictory;
	}
	public int GETBossVictory(){
		return _bossVictory.get();
	}
	public void SETBossVictory(int r){
		_bossVictory.set(r);
	}
	public IntegerProperty BossVictoryProperty(){
		return _bossVictory;
	}
	public int GETCharacterVictory(){
		return _characterVictory.get();
	}
	public void SETCharacterVictory(int r){
		_characterVictory.set(r);
	}
	public IntegerProperty CharacterVictoryProperty(){
		return _characterVictory;
	}

	public int GETWeaponDamage(){
		return _weaponDamage.get();
		
	}
	public void SETWeaponDamage(int d){
		_weaponDamage.set(d);
	}
	public IntegerProperty WeaponDamageProperty(){
		return _weaponDamage;
	}
	public boolean GETIsDefendingAnother(){
		return _isDefendingAnother.get();
	}
	public void SETIsDefendingAnother(boolean d){
		_isDefendingAnother.set(d);
	}
	public BooleanProperty IsDefendingAnotherProperty(){
		return _isDefendingAnother;
	}
	public boolean GETIsDefended(){
		return _isDefended.get();
	}
	public void SETIsDefended(boolean d){
		_isDefended.set(d);
	}
	public BooleanProperty IsDefendedProperty(){
		return _isDefended;
	}
	public boolean GETIsRusty(){
		return _isRusty.get();
	}
	public void SETIsRusty(boolean r){
		_isRusty.set(r);
	}
	public BooleanProperty IsRustyProperty(){
		return _isRusty;
	}
	public boolean GETAllSkillsUnblocked(){
		return _allSkillsUnblocked.get();
	}
	public void SETAllSkillsUnblocked(boolean s){
		_allSkillsUnblocked.set(s);
	}
	public BooleanProperty AllSkillsUnblocked(){
		return _allSkillsUnblocked;
	}
	
	//Character
	public Character GETLinkedCharacter(){
		return _linkedCharacter.get();
	}
	public void SETLinkedCharacter(Character c){
		_linkedCharacter = new SimpleObjectProperty<Character>(c);
	}
	public ObjectProperty<Character> LinkedCharacterProperty(){
		return _linkedCharacter;
	}
	public Character GETDefendedCharacter(){
		return _defendedCharacter.get();
	}
	public void SETDefendedCharacter(Character c){
		_defendedCharacter = new SimpleObjectProperty<Character>(c);
	}
	public ObjectProperty<Character> DefendedCharacterProperty(){
		return _defendedCharacter;
	}
	public TargetableEntity GETTarget(){
		return _target.get();
	}
	public void SETTarget(TargetableEntity t){
		_target = new SimpleObjectProperty<TargetableEntity>(t);
		System.out.println(_target.get().GETName());
	}
	public ObjectProperty<TargetableEntity> TargetProperty(){
		return _target;
	}
	public TargetableEntity GETMainTarget(){
		return _mainTarget.get();
	}
	public void SETMainTarget(TargetableEntity t){
		_mainTarget = new SimpleObjectProperty<TargetableEntity>(t);
	}
	public ObjectProperty<TargetableEntity> MainTargetProperty(){
		return _mainTarget;
	}
	
	//Team
	public Team GETTeam(){
		return _team.get();
	}
	public void SETTeam(Team t){
		_team = new SimpleObjectProperty<Team>(t);
	}
	public ObjectProperty<Team> TeamProperty(){
		return _team;
	}
	public Character GETTeamLeader(){
		return _team.get().GETLeader();
	}
	public void SETLeader(Character l){
		_team.get().SETLeader(l);
	}
	public ObjectProperty<Character> LeaderProperty(){
		return _team.get().LeaderProperty();
	}
	public Character GETSecondLeader(){
		return _team.get().GETLeader2();
	}
	public void SETLeader2(Character l){
		_team.get().SETLeader(l);
	}
	public ObjectProperty<Character> SecondLeaderProperty(){
		return _team.get().SecondLeaderProperty();
	}
	public Character GETThirdLeader(){
		return _team.get().GETLeader3();
	}
	public void SETLeader3(Character l){
		_team.get().SETLeader3(l);
	}
	public ObjectProperty<Character> ThirdLeaderProperty(){
		return _team.get().ThirdLeaderProperty();
	}
	public String GETTeamName(){
		return _team.get().GETName();
	}
	public void SETTeamName(String n){
		_team.get().SETName(n);
	}
	public StringProperty TeamNameProperty(){
		return _team.get().NameProperty();
	}
	public int GETTeamSize(){
		return _team.get().GETSize();
	}
	public void SETTeamSize(int s){
		_team.get().SETSize(s);
	}
	public IntegerProperty TeamSizeProperty(){
		return _team.get().SizeProperty();
	}
	public int GETTeamMaxSize(){
		return _team.get().GETMaxSize();
	}
	public void SETTeamMaxSize(int s){
		_team.get().SETMaxSize(s);
	}
	public IntegerProperty TeamMaxSizeProperty(){
		return _team.get().MaxSizeProperty();
	}
	public int GETTeamLevel(){
		return _team.get().GETLevel();
	}
	public void SETTeamLevel(int l){
		_team.get().SETLevel(l);
	}
	public IntegerProperty TeamLevel(){
		return _team.get().LevelProperty();
	}
	
	//Skills
	public MainSkills GETFirst(){
		return _firstS.get();
	}
	public MainSkills GETSecond(){
		return _secondS.get();
	}
	public MainSkills GETThird(){
		return _thirdS.get();
	}
	public MainSkills GETFourth(){
		return _fourthS.get();
	}
	public MainSkills GETFifth(){
		return _fifthS.get();
	}
	public MainSkills GETSixth(){
		return _sixthS.get();
	}
	public MainSkills GETSeventh(){
		return _seventhS.get();
	}
	public MainSkills GETEighth(){
		return _eighthS.get();
	}
	public MainSkills GETNinth(){
		return _ninthS.get();
	}
	public MainSkills GETTenth(){
		return _tenthS.get();
	}
	public UltimateSkills GETUlti(){
		return _ulti.get();
	}
	public void SETFirst(MainSkills s){
		_firstS.set(s);
	}
	public void SETSecond(MainSkills s){
		_secondS.set(s);
	}
	public void SETThird(MainSkills s){
		_thirdS.set(s);
	}
	public void SETFourth(MainSkills s){
		_fourthS.set(s);
	}
	public void SETFifth(MainSkills s){
		_fifthS.set(s);
	}
	public void SETSixth(MainSkills s){
		_sixthS.set(s);
	}
	public void SETSeventh(MainSkills s){
		_seventhS.set(s);
	}
	public void SETEighth(MainSkills s){
		_eighthS.set(s);
	}
	public void SETNinth(MainSkills s){
		_ninthS.set(s);
	}
	public void SETTenth(MainSkills s){
		_tenthS.set(s);
	}
	public void SETUlti(UltimateSkills s){
		_ulti.set(s);
	}
	public ObjectProperty<MainSkills> FirstProperty(){
		return _firstS;
	}
	public ObjectProperty<MainSkills> SecondProperty(){
		return _secondS;
	}
	public ObjectProperty<MainSkills> ThirdProperty(){
		return _thirdS;
	}
	public ObjectProperty<MainSkills> FourthProperty(){
		return _fourthS;
	}
	public ObjectProperty<MainSkills> FifthProperty(){
		return _fifthS;
	}
	public ObjectProperty<MainSkills> SixthProperty(){
		return _sixthS;
	}
	public ObjectProperty<MainSkills> SeventhProperty(){
		return _seventhS;
	}
	public ObjectProperty<MainSkills> EighthProperty(){
		return _eighthS;
	}
	public ObjectProperty<MainSkills> NinthProperty(){
		return _ninthS;
	}
	public ObjectProperty<MainSkills> TenthtProperty(){
		return _tenthS;
	}
	public ObjectProperty<UltimateSkills> UltiProperty(){
		return _ulti;
	}
	
	//Stock
	public Stock GETStock(){
		return _stock.get();
	}
	public void SETStock(Stock s){
		_stock.set(s);
	}
	public ObjectProperty<Stock> StockProperty(){
		return _stock;
	}
	
	public void Attack(){
		if(_target != null){
			_isDead.set(IsDead());
			_isRusty.set(IsRusty());
			_target.get()._isDead.set(_target.get().IsDead());
			if(_isDead.get()){
				if(_isRusty.get()){
					if(_isDefendingHimSelf.get() || _isDefendingAnother.get()){
						if(this != _target.get()){
							double damage;
							if(_target == _mainTarget){
								double a = _mainDamage.get()*10/100;
								damage = Arround(_target.get().ReceivedDamage
										(_mainDamage.get() + a + _weapon.get().GETDamage(), this), 1);
							}
							else
								damage = Arround(_target.get().ReceivedDamage
										(_mainDamage.get() + _weapon.get().GETDamage(), this), 1);
							_rustPoints.set(_rustPoints.get() + 1);
							System.out.println(_name.get() + " deals " + damage + " damage points"
									+ " to his target " + _target.get()._name + " using his main basic attack.");
							_target.get()._isDead.set(_target.get().IsDead());
							if(_target.get()._isDead.get()){
								_target.get().Death();
								System.out.println(_name.get() + " kills his"
										+ " target: " + _target.get().GETName() + ".\n");
								//this.KillRewards();
								_mainTarget.set(null);
								_target.set(null);
							}
						}
					}
				}
			}
		}
	}
	public void Attack(TargetableEntity e){
		_isDead.set(IsDead());
		_isRusty.set(IsRusty());
		_target.get()._isDead.set(_target.get().IsDead());
		if(_isDead.get()){
			if(_isRusty.get()){
				if(_isDefendingHimSelf.get() || _isDefendingAnother.get()){
					if(this != _target.get()){
						_target.set(e);
						double damage;
						if(_target == _mainTarget){
							double a = _mainDamage.get()*10/100;
							damage = Arround(_target.get().ReceivedDamage
									(_mainDamage.get() + a + _weapon.get().GETDamage(), this), 1);
						}
						else
							damage = Arround(_target.get().ReceivedDamage
									(_mainDamage.get() + _weapon.get().GETDamage(), this), 1);
						_rustPoints.set(_rustPoints.get() + 1);
						System.out.println(_name.get() + " deals " + damage + " damage points"
								+ " to his target " + _target.get()._name + " using his main basic attack.");
						_target.get()._isDead.set(_target.get().IsDead());
						if(_target.get()._isDead.get()){
							_target.get().Death();
							System.out.println(_name.get() + " kills his"
									+ " target: " + _target.get().GETName() + ".\n");
							this.KillRewards();
							_mainTarget.set(null);
							_target.set(null);
						}
					}
				}
			}
		}
	}
	protected double ReceivedDamage(double d, MobileEntity e){
		double damage = d - _resistance.get()*d/100;
		double HP = _healthPoints.get() - damage;
		_healthPoints.set(Arround(HP, 1));
		_rustPoints.set(_rustPoints.get() + 1);
		if(_healthPoints.get() <= 0){
			_healthPoints.set(0);
			_isDead.set(true);
		}
		return damage;
	}
	protected void KillRewards(){
		String resistance = "", healingPower = "";
		int addCoins = 0, addHPMax = 0, removeRust = 0,
				addMainDamage = 0, addSkillPoints = 0, randomWeapon = 1;
		double addResistance = 0, addHealingPower = 0;
		if(_target.get() instanceof Character){
			switch(_target.get().GETGrade()){
				case 1:	//Legendary
					addSkillPoints = 1;
					addCoins = 25000;
					removeRust = 50;
					addHPMax = 10;
					addMainDamage = 7;
					addResistance = 0.1;
					addHealingPower = 0.2;
					break;
				case 2:		//Master
					addCoins = 10000;
					removeRust = 40;
					addHPMax = 10;
					addMainDamage = 4;
					addResistance = 0.075;
					addHealingPower = 0.15;
					randomWeapon = 3;
					break;
				case 3:		//Veteran
					addCoins = 5000;
					removeRust = 30;
					addHPMax = 7;
					addMainDamage = 3;
					addResistance = 0.05;
					addHealingPower = 0.1;
					randomWeapon = 5;
					break;
				case 4:		//Hardered
					addCoins = 2500;
					removeRust = 20;
					addHPMax = 5;
					addMainDamage = 2;
					addResistance = 0.025;
					addHealingPower = 0.05;
					randomWeapon = 8;
					break;
				case 5:		//Apprentice
					addCoins = 1000;
					removeRust = 10;
					addHPMax = 3;
					addMainDamage = 1;
					randomWeapon = 12;
					break;
			}
			_characterVictory.set(_characterVictory.get() + 1);
		}
		else{
			switch(_target.get()._grade.get()){
				case 1:
					addSkillPoints = 2;
					addCoins = 500000;
					removeRust = 2000;
					addHPMax = 250;
					addMainDamage = 15;
					addResistance = 0.75;
					addHealingPower = 1;
					break;
					
					/////////////////////////////////////
				case 2:
					addSkillPoints = 1;
					addCoins = 250000;
					removeRust = 1000;
					addHPMax = 150;
					addMainDamage = 8;
					addResistance = 0.35;
					addHealingPower =0.5;
					break;
					
					/////////////////////////////////////
				case 3:
					addCoins = 100000;
					removeRust = 500;
					addHPMax = 100;
					addMainDamage = 5;
					addResistance = 0.30;
					addHealingPower =0.4;
					break;
					
					/////////////////////////////////////
				case 4:
					addCoins = 50000;
					removeRust = 250;
					addHPMax = 50;
					addMainDamage = 3;
					addResistance = 0.25;
					addHealingPower =0.3;
					
					/////////////////////////////////////
				case 5:
					addCoins = 25000;
					removeRust = 200;
					addHPMax = 35;
					addMainDamage = 2;
					addResistance = 0.15;
					addHealingPower =0.2;
					break;
			}
			_mobVictory.set(_mobVictory.get() + 1);
		}
		
		//this.ItemReward(_target.get(), randomWeapon, _target.get().GETGrade());
		
		_coins.set(_coins.get() + addCoins);
		if(_rustPoints.get() - removeRust <= 0)
			_rustPoints.set(0);
		else
			_rustPoints.set(_rustPoints.get() - removeRust);
		
		_healthPointsMax.set(_healthPointsMax.get() + addHPMax);
		if(_healthPoints.get() + _healthPointsMax.get()/45 <= _healthPointsMax.get())
			_healthPoints.set(_healthPointsMax.get()/45);
		else
			_healthPoints.set(_healthPointsMax.get());
		
		if(!_isDefendingHimSelf.get())
			_resistance.set(_basicResistance.get());
		
		_mainDamage.set(_mainDamage.get() + addMainDamage);
		
		if(_basicResistance.get() + addResistance < 70 && addResistance != 0){
			_basicResistance.set(_basicResistance.get() + addResistance);
			resistance = ">> +" + addResistance + "% resistance\n";
		}
		else if(_basicResistance.get() + addResistance >= 70){
			_basicResistance.set(70);
			resistance = _name + "'s resistance attains the maximum (70)\n";
		}
		if(_healingPowerMax.get() + addHealingPower < 70 && addHealingPower != 0){
			_healingPowerMax.set(_healingPowerMax.get() + addHealingPower);
			healingPower = ">> +" + addHealingPower + "% healing power max\n";
		}
		else if(_healingPowerMax.get() + addHealingPower >= 70){
			_healingPowerMax.set(70);
			healingPower = _name + "'s healing power max attains the maximum (70)\n";
		}
		
		_skillPoints.set(_skillPoints.get() + addSkillPoints);
		
		System.out.println("\n\t||" + _name + "||\n>> +" + addCoins + " coins.");
		if(addSkillPoints != 0)
			System.out.println(">> +" + addSkillPoints + " skill points.");
		System.out.println(">> +" + addHPMax + " HP max.");
		System.out.println(">> -" + removeRust + " rust points.");
		System.out.println(">> +" + addMainDamage +" main damage.");
		if(addResistance != 0)
			System.out.print(resistance);
		if(addHealingPower != 0)
			System.out.print(healingPower);
		//this.SETSkill();
	}	
	
	public boolean IsRusty(){
		return _rustPoints.get() >= _rustPointsMax.get();
	}
	
	//		protected abstract void SETSkill();
	protected abstract void SetFirstSkill();
	protected abstract void SetFirstWeapon();
	//protected abstract void ItemReward(TargetableEntity e, int r, int g);
}
