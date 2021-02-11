package org.eclipse.model;



import org.eclipse.interfaces.Observer;


public class Fan implements Observer {
private String name;

	public Fan(String name) {
	this.name = name;
}

	public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

	@Override
	public void update(Object o) {
		System.out.println("("+this.name+"):changement de score : "+(Match)o);

	}

	@Override
	public String toString() {
		return name;
	}

}
