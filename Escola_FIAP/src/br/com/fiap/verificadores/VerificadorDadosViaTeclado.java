package br.com.fiap.verificadores;

import javax.swing.JOptionPane;

public class VerificadorDadosViaTeclado {

	public void verificaInteiros(String opcaoViaTeclado) {

		if (!opcaoViaTeclado.matches("^[0-9]*$")) {
			System.out.println("Op��o Inv�lida!");
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida!");
			System.exit(0);
		}
		
		if (opcaoViaTeclado.equals("")) {
			System.out.println("Op��o Inv�lida!");
			JOptionPane.showMessageDialog(null, "Op��o Inv�lida!");
			System.exit(0);
		}
	}
}