package fx.application.models;

import core.skills.MainSkills;
import core.skillsMartial.MSkills1;
import core.weapons.Fists;
import core.weapons.Weapon;
import javafx.beans.property.SimpleObjectProperty;

public class Martial extends Character{

	public Martial(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	protected final void SetFirstSkill(){
		this._firstS = new SimpleObjectProperty<MainSkills>(new MSkills1());
	}
	protected final void SetFirstWeapon(){
		_weapon = new SimpleObjectProperty<Weapon>(new Fists());
	}
	
}
