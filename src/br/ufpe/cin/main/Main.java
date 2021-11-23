package br.ufpe.cin.main;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import br.cin.ufpe.exceptions.IncorrectOperationException;
import br.cin.ufpe.exceptions.UnexpectedCharacterException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, UnexpectedCharacterException, IncorrectOperationException {
		MyScanner sc = new MyScanner();
		RPNStacker calc = new RPNStacker();
		
		ArrayList<Token> tokenList = sc.lerEntrada(new FileReader("src/Calc1.stk"));
		
		System.out.println(calc.calcular(tokenList, new Stack<Integer>()));
		
	}

}
