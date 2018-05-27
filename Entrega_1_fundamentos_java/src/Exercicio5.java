

import javax.swing.JOptionPane;

public class Exercicio5 {

	public static void main(String[] args) {

		String fatoralEntrada = JOptionPane.showInputDialog("Informe o numero para ser fatorado");

		int fatoral = Integer.valueOf(fatoralEntrada);

		long fat = 1;

		for (int i = 1; i <= fatoral; i++) {
			fat = fat * i;
		}

		JOptionPane.showMessageDialog(null, "Fatorial de " + fatoral + " = " + fat);

	}
}
