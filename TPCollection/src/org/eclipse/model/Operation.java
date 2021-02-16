package org.eclipse.model;

import org.elipse.exception.OperationException;

public class Operation {
private Nombre nombre;

public Operation(Nombre nombre) {
	super();
	this.nombre = nombre;
}

public Nombre getNombre() {
	return nombre;
}

public void setNombre(Nombre nombre) {
	this.nombre = nombre;
}

public float division() throws OperationException
{
	if (this.nombre.getVar2()==0)
		throw new OperationException("division par zero impossible");
	return (float) this.nombre.getVar1()/this.nombre.getVar2();
}
public double racineDeLaSomme() throws OperationException
{
	if (this.nombre.getVar1()+this.nombre.getVar2() <=0)
		throw new OperationException("la somme n'est pas positive, calcul de la racine carrée impossible");
	return Math.sqrt(this.nombre.getVar1()+this.nombre.getVar2()) ;
}
}
