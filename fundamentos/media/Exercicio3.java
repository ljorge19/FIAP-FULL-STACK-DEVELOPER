package br.com.fiap.fundamentos.media;

import javax.swing.JOptionPane;

import br.com.fiap.fundamentos.ExercicioExecutor;

public class Exercicio3 implements ExercicioExecutor {

	@Override
	public void execute() {
		/*
		 * Construa um programa que crie um vetor para coletar informações de salários de
		 * determinados funcionários. O programa inicialmente deverá questionar a
		 * quantidade de funcionários que servirá para determinar o tamanho do vetor.
		 * Após isso, será questionado o salário para cada funcionário deste vetor. Ao final,
		 * o programa deverá informar a média salarial da empresa.
		 * Nota: utilize o comando JOptionPane.showInputDialog para a entrada de dados.
		 * Como este comando retorna o tipo String, faça a conversão de tipos apropriada
		 * (classes wrappers).
		 */
		
		String numeroFunctionariosStr = JOptionPane.
				showInputDialog("Informe a quantidade de funcionários");
				
		int funcionarios = Integer.valueOf(numeroFunctionariosStr);
		double totalSalario = 0;
		
		for (int i = 0; i < funcionarios; i++) {
			String salarioStr = JOptionPane.
					showInputDialog("Informe o salário do funcionário " + i);
			
			double salario = Double.valueOf(salarioStr);
			totalSalario += salario;
		}
		
		double media = totalSalario / funcionarios;
		JOptionPane.showMessageDialog(null, "Media salarial da empresa: " + media);
			
	}

}
