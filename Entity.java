package fx.application.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Entity {

	protected StringProperty _name;
	
	public Entity(String n) {
		_name = new SimpleStringProperty(n);
	}
	
	public final String GETName(){
		return _name.get();
	}
	public final void SETName(String n){
		this._name.set(n);
	}
	public final StringProperty NameProperty(){
		return _name;
	}
}
