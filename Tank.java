package fx.application.models;

import core.skills.MainSkills;
import core.skillsTank.TSkills1;
import core.weapons.HAThinHammer;
import core.weapons.Weapon;
import javafx.beans.property.SimpleObjectProperty;

public class Tank extends Character{

	public Tank(String n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	protected final void SetFirstSkill(){
		this._firstS = new SimpleObjectProperty<MainSkills>(new TSkills1());
	}
	protected final void SetFirstWeapon(){
		_weapon = new SimpleObjectProperty<Weapon>(new HAThinHammer());
	}
}