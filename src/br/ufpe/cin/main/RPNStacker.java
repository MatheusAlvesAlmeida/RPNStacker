package br.ufpe.cin.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import br.cin.ufpe.exceptions.IncorrectOperationException;
import br.cin.ufpe.exceptions.UnexpectedCharacterException;

public class RPNStacker{


	public int calcular(ArrayList<Token> tokens, Stack<Integer> pilha) throws IncorrectOperationException{
		for(Token tk : tokens) {
			if(tk.type == TokenType.NUM) {
				pilha.push(Integer.parseInt(tk.lexeme));
			}else {
				int x = 0, y = 0;
				
				try {
					y = pilha.pop();
					x = pilha.pop();
				} catch (Exception e) {
					throw new IncorrectOperationException();
				}
					
				if(tk.type == TokenType.PLUS) {
					pilha.push(x+y);
				}else if(tk.type == TokenType.MINUS) {
					pilha.push(x-y);
				}else if(tk.type == TokenType.STAR) {
					pilha.push(x*y);
				}else {
					pilha.push(x/y);
				}
			}
		}
		if(pilha.size() != 1) {
			IncorrectOperationException e = new IncorrectOperationException();
			throw e;
		}
		return pilha.get(0);
	}
}
