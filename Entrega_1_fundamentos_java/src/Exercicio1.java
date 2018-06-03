
import java.util.Scanner;

public class Exercicio1 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);

		int[] vetor = new int[10];

		System.out.println("Digite no console uma sequencia de 10 numero, pressione enter após cada número");
		System.out.println("lembre-se não use numeros repetidos \n");
		
		for (int i = 0; i < vetor.length; i++) {
			
			vetor[i] = entrada.nextInt();
		}

		System.out.println("Resultado: \n");
		for (int i = vetor.length - 1; i >= 0; i--) {
			System.out.println(vetor[i]);
		}

	}
}
