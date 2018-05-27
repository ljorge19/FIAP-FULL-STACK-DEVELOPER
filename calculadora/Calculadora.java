

package br.com.fiap.fundamentos.calculadora;

public class Calculadora implements CalculadoraBasica {

	@Override
	public float somar(float opt1, float opt2) {
		return opt1 + opt2;
	}

	@Override
	public float subtrair(float opt1, float opt2) {
		return opt1 - opt2;
	}

	@Override
	public float dividir(float opt1, float opt2) {
		return opt1 / opt2;
	}

	@Override
	public float multiplicar(float opt1, float opt2) {
		return opt1 * opt2;
	}

}


