package fx.application.models;

import core.skills.MainSkills;
import core.skillsSwordsman.SSkills1;
import core.weapons.SWNoviceSword;
import core.weapons.Weapon;
import javafx.beans.property.SimpleObjectProperty;

public class Swordsman extends Character{

	public Swordsman(String n) {
		super(n);
	}

	protected final void SetFirstSkill(){
		this._firstS = new SimpleObjectProperty<MainSkills>(new SSkills1());
	}
	protected final void SetFirstWeapon(){
		_weapon = new SimpleObjectProperty<Weapon>(new SWNoviceSword());
	}
}
