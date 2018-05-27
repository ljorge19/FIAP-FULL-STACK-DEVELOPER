package br.com.fiap.fundamentos.calculator;

public class Sum implements ArithmeticOperation {

	@Override
	public double calculate(double x, double y) {
		return x + y;
	}

	@Override
	public int calculate(int x, int y) {
		return x + y;
	}

}
