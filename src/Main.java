import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Stack<Integer> pilha = new Stack<>();		
		//Colocar aqui o caminho para o arquivo.
		Scanner in = new Scanner(new FileReader("CAMINHO"));
		while(in.hasNext()) {
			if(in.hasNextInt()) {
				pilha.push(in.nextInt());
			}else {
				char operador = in.next().charAt(0);
				int x = pilha.pop();
				int y = pilha.pop();
				switch (operador) {
				case '+':
					pilha.push(x+y);
					break;
				case '-':
					pilha.push(x-y);
					break;
				case '*':
					pilha.push(x*y);
					break;
				default:
					pilha.push(x/y);
					break;
				}
			}
		}
		System.out.println(pilha.get(0));
	}

}
