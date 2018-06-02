package br.com.fiap.verificadores;

import javax.swing.JOptionPane;

public class VerificadorDadosViaTeclado {

	public void verificaInteiros(String opcaoViaTeclado) {

		if (!opcaoViaTeclado.matches("^[0-9]*$")) {
			System.out.println("Opção Inválida!");
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			System.exit(0);
		}
		
		if (opcaoViaTeclado.equals("")) {
			System.out.println("Opção Inválida!");
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			System.exit(0);
		}
	}
}