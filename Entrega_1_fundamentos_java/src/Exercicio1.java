
import java.util.Scanner;

public class Exercicio1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int[] vetor = new int[10];

		for (int i = 0; i < vetor.length; i++) {
			System.out.println("Digite um número");
			System.out.println("lembre-se não use numeros repetidos \n");
			
			vetor[i] = entrada.nextInt();
		}

		for (int i = vetor.length - 1; i >= 0; i--) {
			System.out.println(vetor[i]);
		}

	}
}
