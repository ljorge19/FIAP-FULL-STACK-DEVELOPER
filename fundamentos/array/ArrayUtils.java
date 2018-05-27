package br.com.fiap.fundamentos.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * <p> Array utility class. </p>
 * It provides a method to solve the following exercise:
 * <br>
 * Crie um programa que leia a seqüência de um determinado vetor (array) e
 * depois escreva, em seqüência inversa, em outro vetor. Por exemplo, se o vetor
 * A = {1,2,3}, então vetor B = {3,2,1}.
 * 
 * @author Neilton Bordan 
 */
public class ArrayUtils {
	
	/**
	 * <p>Returns a reversed representation of the given array.</p>
	 * <br>
	 * Eg.:
	 * <br>
	 * If the given array is {1,2,3}
	 * the method will produce the following result:
	 * {3,2,1}
	 * @param arr - int array
	 * @return reversed - the reversed array
	 * @see Collections#reverse(java.util.List)
	 * @see Arrays#asList(Object...)
	 */
	public static int [] reverse(int [] arr) {
		int length = arr.length;
		int [] reversed = new int [length];
		
		for (int i = 0; i < length; i++) {
			reversed[i] = arr[length - (i + 1)];
		}
		
		return reversed;
	}
	
}
