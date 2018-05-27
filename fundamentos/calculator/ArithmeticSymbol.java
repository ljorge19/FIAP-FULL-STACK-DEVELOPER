package br.com.fiap.fundamentos.calculator;

/**
 * 
 * @author tom-m
 *
 */
public enum ArithmeticSymbol {

	/*
	 * 
	 */
	SUM("+", new Sum()),
	
	/*
	 * 
	 */
	SUBTRACTION("-", new Subtraction()),
	
	/*
	 * 
	 */
	DIVISION("/", new Division()),
	
	/*
	 * 
	 */
	MULTIPLICATION("*", new Multiplication());
	
	private String symbol;
	private ArithmeticOperation operation;
	
	/**
	 * 
	 * @param symbol
	 * @param operation
	 */
	ArithmeticSymbol(String symbol, ArithmeticOperation operation) {
		this.symbol = symbol;
		this.operation = operation;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSymbol() {
		return this.symbol;
	}
	
	/**
	 * 
	 * @return
	 */
	public ArithmeticOperation getArithmeticOperation() {
		return this.operation;
	}
	
}
