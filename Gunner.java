package fx.application.models;

import core.skills.MainSkills;
import core.skillsGunner.GSkills1;
import core.weapons.GULightGun;
import core.weapons.Weapon;
import javafx.beans.property.SimpleObjectProperty;

public class Gunner extends Character{

	public Gunner(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	protected final void SetFirstSkill(){
		this._firstS = new SimpleObjectProperty<MainSkills>(new GSkills1());
	}
	protected final void SetFirstWeapon(){
		_weapon = new SimpleObjectProperty<Weapon>(new GULightGun());
	}

	
}
