package fx.application.models;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.LinkedList;

public class Team {

	private StringProperty _name;
	private ObjectProperty<Character> _Leader, _secondLeader, _thirdLeader;
	private List<Character> _composition = new LinkedList<Character>();
	private IntegerProperty _size, _maxSize, _level;
	
	public Team(String n, Character l, boolean r) {
		_name = new SimpleStringProperty(n);
		_Leader = new SimpleObjectProperty<Character>(l);
		_composition.add(_Leader.get());
		_size.set(_composition.size()); 
		switch(_Leader.get().GETGrade()){
			case 1:
				_maxSize.set(40);
				_level.set(5);
				break;
			case 2:
				_maxSize.set(30);
				_level.set(4);
				break;
			case 3: 
				_maxSize.set(22);
				_level.set(3);
				break;
			case 4:
				_maxSize.set(14);
				_level.set(2);
				break;
			case 5: 
				_maxSize.set(6);
				_level.set(1);
				break;
		}
		System.out.println("Team " + _name + " created\nLeader: " 
				+ _Leader.get().GETName() + " (" + _Leader.get().GETType() + ")\n");
		if(r)
			this.Resume(this.GETName());
	}

	public final void AddMember(Character c){
		for(Character a : _composition){
			if(a == c)
				System.out.println(c.GETName() + " already belongs to this team." + a.GETName());
		}
		if(_composition.size() + 1 <= _maxSize.get()){
			_composition.add(c);
			System.out.println("Member " + c.GETName() + " join the team " + _name + ".");
			c.SETTeam(this);
		}
		else
			System.out.println("The team " + _name + " is full.");
		_size.set(_composition.size());
	}
	public final void DismissMember(Character d, Character c){
		boolean b = false;
		for(Character a: _composition)
			if(a == c){
				b = true;
				break;
			}
		if(b){
			if(d == _secondLeader.get() && c == _Leader.get())
				System.out.println("The " + _name + "'s second leader " + _secondLeader.get().GETName() 
				+ " doesn't have the right to dismiss the Leader.");
			else if(d == _thirdLeader.get() && c == _Leader.get())
				System.out.println("The " + _name + "'s third leader " + _thirdLeader.get().GETName() 
				+ " doesn't have the right to dismiss the Leader.");
			else if(d == _thirdLeader.get() && c == _secondLeader.get())
				System.out.println("The " + _name + "'s third leader " + _thirdLeader.get().GETName() 
					+ " doesn't have the right to dismiss the second leader.");
			else{
				_composition.remove(c);
				if(c == _secondLeader.get())
					System.out.println(_name + "'s Second leader " + c.GETName() + " dismissed by " + _Leader.get().GETName() + ".");
				else if(c == _thirdLeader.get())
					System.out.println(_name + "'s Third leader " + c.GETName() + " dismissed by " + d.GETName() + ".");
				else
					System.out.println(_name + "'s Member " + c.GETName() + " dismissed by " + d.GETName() + ".");
				_size.set(_composition.size());
			}
		}
		else System.out.println(c.GETName() + " doesn't belongs to " + _name + " team.");
	}
	public final void Upgrade(){
		switch(_Leader.get().GETGrade()){
			case 4: _maxSize.set(14); break;
			case 3: _maxSize.set(22); break;
			case 2: _maxSize.set(30); break;
			case 1: _maxSize.set(40); break;
		}
		int i = _level.get() + 1;
		_level.set(i);
		System.out.println(_name + " team increases her max size: " + _maxSize);
	}
	public final void Refresh(){
		ArrayList<Character> toRemove = new ArrayList<Character>();
		for(Character c : _composition){
			if(c != _Leader.get()){
				if(c != _secondLeader.get()){
					if(c != _thirdLeader.get()){
						toRemove.add(c);
						c.SETTeam(null);
						System.out.println(c.GETName() + " was dismissed from " + _name + ".");
					}
				}
			}
		}
		_composition.removeAll(toRemove);
		_size.set(_composition.size());
		System.out.println(_name + " cleaned.\nRemain only leader(s).");
	}
	public final void Resume(String n){
		_size.set(_composition.size());
		System.out.println("\n\t\t/// " + n + "'s Team ///\n");
		System.out.println("\tName: " + _name + " (lvl." + _level + ")\n\tLeader: "
				+ _Leader.get().GETName() + " (" + _Leader.get().GETType() + ")");
		if(_secondLeader != null)
			System.out.println("\tSecond leader: " + _secondLeader.get().GETName());
		if(_thirdLeader != null)
			System.out.println( "\tThird leader: " + _thirdLeader.get().GETName());
		System.out.println("\tMember: " + _size + "/" + _maxSize);
	}
	
	public final String GETName(){
		return _name.get();
	}
	public final void SETName(String n){
			_name = new SimpleStringProperty(n);
	}
	public final StringProperty NameProperty(){
		return _name;
	}
	public final void ResumeLeader(){
		System.out.println("\n\t\t(Leader)");
		_Leader.get().Resume();
	}
	public final void ResumeLeader2(){
		System.out.println("\n\t\t(Second leader)");
		_secondLeader.get().Resume();
	}
	public final void ResumeLeader3(){
		System.out.println("\n\t\t(Third leader)");
		_thirdLeader.get().Resume();
	}	
	public final Character GETLeader(){
		return _Leader.get();
	}
	public final Character GETLeader2(){
		return _secondLeader.get();
	}
	public final Character GETLeader3(){
		return _thirdLeader.get();
	}
	public final void SETLeader(Character c){
		_Leader = new SimpleObjectProperty<Character>(c);
	}
	public final void SETLeader2(Character c){
		if(_secondLeader != null){
			if(_thirdLeader == null){
				_thirdLeader = _secondLeader;
				_secondLeader = null;
				System.out.println(_thirdLeader.get().GETName() + " became the third leader of " + _name);
			}
		}
		if(c != _thirdLeader.get() || c != _secondLeader.get()){
			boolean r = true;
			for( Character a: _composition){
				if(c == a)
					r = false;
			}
			if(r)
				_composition.add(c);
		}
		_secondLeader = new SimpleObjectProperty<Character>(c);
		_secondLeader.get().SETTeam(this);
		if(_thirdLeader.get()== c)
			_thirdLeader = null;
		_size.set(_composition.size());
		System.out.println(_secondLeader.get().GETName() + " became the second leader of " + _name + " team.");
	}
	public final void SETLeader3(Character c){
		if(_thirdLeader != null){
			_thirdLeader = null;
			System.out.println(c.GETName() + " lost his leader's post.");
		}
		if(c != _thirdLeader.get() || c != _secondLeader.get()){
			boolean r = true;
			for( Character a: _composition){
				if(c == a)
					r = false;
			}
			if(r)
				_composition.add(c);
		}
			
		_thirdLeader = new SimpleObjectProperty<Character>(c);
		_thirdLeader.get().SETTeam(this);
		if(_secondLeader.get() == c)
			_secondLeader = null;
		_size.set(_composition.size());
		System.out.println(_thirdLeader.get().GETName() + " became the third leader of " + _name + " team.");
	}	
	public final ObjectProperty<Character> LeaderProperty(){
		return _Leader;
	}
	public final ObjectProperty<Character> SecondLeaderProperty(){
		return _secondLeader;
	}
	public final ObjectProperty<Character> ThirdLeaderProperty(){
		return _thirdLeader;
	}
	public final int GETSize(){
		_size.set(_composition.size());
		return _size.get();
	}
	public final void SETSize(int i){
		_size.set(i);
	}
	public final IntegerProperty SizeProperty(){
		_size.set(_composition.size());
		return _size;
	}
	public final int GETMaxSize(){
		return _maxSize.get();
	}
	public final void SETMaxSize(int i){
		_maxSize.set(i);
	}
	public final IntegerProperty MaxSizeProperty(){
		return _maxSize;
	}
	public final int GETLevel(){
		return _level.get();
	}
	public final void SETLevel(int l){
		_level.set(l);
	}
	public final IntegerProperty LevelProperty(){
		return _level;
	}
	
}
