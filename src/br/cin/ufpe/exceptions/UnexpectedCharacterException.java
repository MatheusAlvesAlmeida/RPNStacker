package br.cin.ufpe.exceptions;

public class UnexpectedCharacterException extends Exception{
	public UnexpectedCharacterException(String operador){ super("Unexpected character: " + operador);}
}
