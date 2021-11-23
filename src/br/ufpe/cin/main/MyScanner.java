package br.ufpe.cin.main;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import br.cin.ufpe.exceptions.UnexpectedCharacterException;

public class MyScanner {
	
	public ArrayList<Token> lerEntrada(FileReader arquivo) throws UnexpectedCharacterException{
		Scanner in = new Scanner(arquivo);
		ArrayList<Token> tokens = new ArrayList<Token>();
		while(in.hasNext()) {
			if(in.hasNextInt()) {
				Token token = new Token(TokenType.NUM, in.nextLine());
				tokens.add(token);
			}else {
				Token token;
				String operador = in.nextLine();
				switch (operador) {
				case "+":
					token = new Token(TokenType.PLUS, operador);
					tokens.add(token);
					break;
				case "-":
					token = new Token(TokenType.MINUS, operador);
					tokens.add(token);
					break;
				case "*":
					token = new Token(TokenType.STAR, operador);
					tokens.add(token);
					break;
				case "/":
					token = new Token(TokenType.SLASH, operador);
					tokens.add(token);
					break;
				default:
					UnexpectedCharacterException e = new UnexpectedCharacterException(operador);
					throw e;
				}
			}
		}
		return tokens;
	}
}
