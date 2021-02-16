package org.elipse.exception;

public class OperationException extends Exception {

	public OperationException() {
		System.out.println("l'operation est incorrecte");
	}
	public OperationException(String msg)
	{
		System.out.println(msg);
	}

}
