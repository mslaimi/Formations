package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.interfaces.Observer;
import org.eclipse.interfaces.Subject;

public class Match implements Subject{
private String score;
private List<Observer> observers=new ArrayList();
public Match(String score) {
	this.score = score;
}

public void setScore(String score)
{
	this.score=score;
	this.notifier();
}

public String getScore()
{
	return this.score;
	
}
@Override
public void subscribe(Observer o )
{
	this.observers.add(o);
	System.out.println( "une inscription : "+o);
}
@Override
public void unsubscribe(Observer o )
{
	this.observers.remove(o);
	System.out.println( "une désinscription : "+o);
}

@Override
public String toString() {
	return "Match [changement de score=" + score + "]";
}


@Override
public void notifier() {
	for (Observer o: this.observers)
	{
		o.update(this);
	}
	
}


}
