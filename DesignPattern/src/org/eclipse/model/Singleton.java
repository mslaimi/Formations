package org.eclipse.model;

public class Singleton {
private static Singleton instance;
private int var;
private Singleton() {
	var=5;
}

public static Singleton getInstance()
{
	if (instance==null)
		instance=new Singleton();
	return instance;
}

public int getVar() {
	return var;
}

public void setVar(int var) {
	this.var = var;
}

}
