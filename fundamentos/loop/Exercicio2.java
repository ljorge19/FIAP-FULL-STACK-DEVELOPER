package br.com.fiap.fundamentos.loop;

import br.com.fiap.fundamentos.ExercicioExecutor;

public class Exercicio2 implements ExercicioExecutor {

	@Override
	public void execute() {
		
		/*
		 * Exercicio 2:
		 * 
		 * Dado o trecho de código abaixo, indique os valores finais das variáveis a, b e c.
		 */
		int a=0, b=0, c=0;
		c=1;
		b=2;
		for (a=1;a<=b;a++){
			c++;
			if (c==2){
				continue;
			}
			c--;
		}
		
		System.out.println("a="+a+",b="+b+",c="+c);
		
	}

}
