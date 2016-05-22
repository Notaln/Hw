package fx.application.models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class MobileEntity extends Entity{
	protected StringProperty _state;
	protected BooleanProperty _isMoving;
	//protected Movement _movement;
	
	public MobileEntity(String n){
		super(n);
		_state =  new SimpleStringProperty("Unknown");
		_isMoving = new SimpleBooleanProperty(false);
	}
	
	/*public final void SETMovement(Movement m){
		_movement = m;
		_isMoving = false;
		_state = "Static";
		if(!m.getClass().equals(MOVE_Stop.class)){
			_isMoving = true;
			_state = "Moving";
		}
		System.out.println("New movement set for " + _name);
	}
	*/
	public final double Arround(double a, int n){
		return (Math.round(a * Math.pow(10, n))) / (Math.pow(10, n)); 
	}
}
