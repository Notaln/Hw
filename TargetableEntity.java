package fx.application.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import featuresInterface.pack.MainFighting;

public abstract class TargetableEntity extends MobileEntity{

	protected StringProperty _type;
	protected DoubleProperty _healthPoints, _resistance,
		_basicResistance, _defendingResistance;
	protected IntegerProperty _grade, _mainDamage, _healthPointsMax;
	protected BooleanProperty _isDead, _isDefended, _isDefendingHimSelf;
	//protected MainFighting _mainFight;
	
	public TargetableEntity(String n, int g){
		super(n);
		//TODO SET value for boss/mobs
		this._name = new SimpleStringProperty(n.trim());
		this._grade = new SimpleIntegerProperty(g);
		this._isDead = this._isDefendingHimSelf = this._isDefended = new SimpleBooleanProperty(false);
	}

	protected double ReceivedDamage(double d, MobileEntity e) {
		double damage = d - _resistance.get()*d/100;
		double hp = _healthPoints.get();
		hp -= damage;
		_healthPoints.set(Arround(hp, 1));
		if(_healthPoints.get() <= 0){
			_healthPoints.set(0);;
			_isDead.set(true);
		}
		return damage;
	}

	public final int GETGrade(){
		return _grade.get();
	}
	public final void SETGrade(int g){
		_grade.set(g);
	}
	public IntegerProperty GradeProperty(){
		return _grade;
	}
	
	public void Resume() {
		System.out.println("\tName: " + _name + " ("+ _grade + ")");
		System.out.println("\tMain damages: " + _mainDamage);
		System.out.println("\tResistance: " + _resistance + "% / 70%");
		if(_healthPoints.get() <= 1)
			System.out.print("\tHealth point: " + _healthPoints);
		else
			System.out.print("\tHealth points: " +_healthPoints);
		System.out.print(" / " + _healthPointsMax + " ");
		if(!_isDead.get())
			System.out.println("(Alive)");
		else
			System.out.println("(Dead)");
		System.out.println("\tState: " + _state);
	}
	protected void StatsResume(){
		System.out.println("\t>> " + _healthPointsMax + " health points max.");
		System.out.println("\t>> " + _mainDamage + " damage points on the main damages.");
		System.out.println("\t>> " + _basicResistance + "% of resistance.");
	}
	
	public boolean IsDead(){
		if(_healthPoints.get() <= 0){
			_healthPoints.set(0);
			return true;
		}
		else{ 
			return false;
		}
	}
	protected void Death(){
		this.StopDefend();
		_isDead.set(true);
	}
	public void StopDefend(){
		if(!_isDead.get())
			System.out.println(_name + " stops his defensive posture.");
		_resistance = _basicResistance;
		_isDefendingHimSelf.set(false);
	}

	public String GETType(){
		return _type.get();
	}
	public void SETType(String t){
		this._type.set(t);
	}
	public StringProperty TypeProperty(){
		return _type;
	}
}
