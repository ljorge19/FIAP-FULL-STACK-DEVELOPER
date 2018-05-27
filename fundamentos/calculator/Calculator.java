package br.com.fiap.fundamentos.calculator;

public class Calculator {
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param symbol
	 * @return
	 */
	public double execute(double x, double y, ArithmeticSymbol symbol) {
		return symbol
				.getArithmeticOperation()
				.calculate(x, y);
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param symbol
	 * @return
	 */
	public int execute(int x, int y, ArithmeticSymbol symbol) {
		return symbol
				.getArithmeticOperation()
				.calculate(x, y);
	}
	
}
