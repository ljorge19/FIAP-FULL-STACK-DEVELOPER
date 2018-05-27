package br.com.fiap.fundamentos;

import br.com.fiap.fundamentos.array.Exercicio1;
import br.com.fiap.fundamentos.calculator.Exercicio4;
import br.com.fiap.fundamentos.factorial.Exercicio5;
import br.com.fiap.fundamentos.loop.Exercicio2;
import br.com.fiap.fundamentos.media.Exercicio3;

public class Main {

	public static void main(String [] args) {
		
		ExercicioExecutor exercicio = new Exercicio1();
		exercicio.execute();
				
		exercicio = new Exercicio2();
		exercicio.execute();
		
		exercicio = new Exercicio3();
		exercicio.execute();
		
		exercicio = new Exercicio4();
		exercicio.execute();
		
		ExercicioExecutor exercicio = new Exercicio5();
		exercicio.execute();						
	}
	
	
	
	
}
