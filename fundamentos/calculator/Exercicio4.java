

public class Exercicio4 implements ExercicioExecutor {

	public static void main(String[] args) {
	
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.execute(1, 1, ArithmeticSymbol.SUM));
		System.out.println(calculator.execute(2, 2, ArithmeticSymbol.SUBTRACTION));
		System.out.println(calculator.execute(2, 2, ArithmeticSymbol.MULTIPLICATION));
		System.out.println(calculator.execute(2, 2, ArithmeticSymbol.DIVISION));		
	}

}
