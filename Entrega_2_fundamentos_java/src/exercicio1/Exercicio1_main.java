package exercicio1;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Exercicio1_main {

	public static void main(String[] args) {
		float soma = 0;
		boolean somaVerificador = true;
		float subtracao = 0;
		boolean subtracaoVerificador = true;
		float divisao = 0;
		boolean divisaoVerificador = true;
		float multiplicacao = 0;
		boolean multiplicacaoVerificador = true;

		Calculadora calculadora = new Calculadora();

		String somaStr = JOptionPane.showInputDialog("Digite a operação de soma (ex: 1+1)");
		String[] arr = somaStr.split(Pattern.quote("+"));
		
			soma = calculadora.somar(Float.valueOf(arr[0]), Float.valueOf(arr[1]));
			System.out.println(soma);
	
		String subStr = JOptionPane.showInputDialog("Digite a operação de subtração (ex: 2-1)");
		String[] subArr = subStr.split(Pattern.quote("-"));
		
			subtracao = calculadora.subtrair(Float.valueOf(subArr[0]), Float.valueOf(subArr[1]));
			System.out.println(subtracao);
		

		String multStr = JOptionPane.showInputDialog("Digite a operação de multiplicação (ex: 2*2)");
		String[] multArr = multStr.split(Pattern.quote("*"));
		
			multiplicacao = calculadora.multiplicar(Float.valueOf(multArr[0]), Float.valueOf(multArr[1]));
			System.out.println(multiplicacao);
		

		String divStr = JOptionPane.showInputDialog("Digite a operação de divisão (ex: 4/2)");
		String[] divArr = divStr.split(Pattern.quote("/"));
		
			divisao = calculadora.dividir(Float.valueOf(divArr[0]), Float.valueOf(divArr[1]));
			System.out.println(divisao);
		
		

		String texto = "";
		if (somaVerificador == true)
			texto += "soma :" + soma + "  ";
		if (subtracaoVerificador == true)
			texto += "subtracao :" + subtracao + "  ";
		if (multiplicacaoVerificador == true)
			texto += "multiplicacao :" + multiplicacao + "  ";
		if (divisaoVerificador == true)
			texto += "divisao :" + divisao + "  ";

		JOptionPane.showMessageDialog(null,  texto);
		

	}
}
