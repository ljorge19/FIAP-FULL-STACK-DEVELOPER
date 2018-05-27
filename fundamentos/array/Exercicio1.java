package br.com.fiap.fundamentos.array;

import java.util.Arrays;

import br.com.fiap.fundamentos.ExercicioExecutor;

public class Exercicio1 implements ExercicioExecutor {

	@Override
	public void execute() {
		
		/*
		 * Exercicio 1:
		 * 
		 * Crie um programa que leia a seqüência de um determinado vetor (array) e
		 * depois escreva, em seqüência inversa, em outro vetor. 
		 * Por exemplo, se o vetor A = {1,2,3}, então vetor B = {3,2,1}.
		 */
		int [] arr = ArrayUtils.reverse(new int[] {3,2,1,4,5,6,7});		
		System.out.println(Arrays.toString(arr));
		
	}

}
