package br.com.fiap.fundamentos.factorial;

import br.com.fiap.fundamentos.ExercicioExecutor;

public class Exercicio5 implements ExercicioExecutor{

	@Override
	public void execute() {
		System.out.println(factorial(10));		
	}

	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public long factorial(long n) {
		return n <= 1 ? 1 : n * factorial(n - 1);
	}
	
	
	
}
