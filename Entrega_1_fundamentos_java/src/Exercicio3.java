import javax.swing.JOptionPane;



public class Exercicio3  {
	public static void main(String [] args) {
		
		
		String numFuncionarios = JOptionPane.
				showInputDialog("Informe a quantidade de funcionários");
				
		int funcionarios = Integer.valueOf(numFuncionarios);
		double totalSalario = 0;
		
		for (int i = 0; i < funcionarios; i++) {
			int func = i +1;
			
			String salarioStr = JOptionPane.
					showInputDialog("Informe o salário do funcionário " + func + " use o . no lugar da ,");
			
			double salario = Double.valueOf(salarioStr);
			totalSalario += salario;
		}
		
		double media = totalSalario / funcionarios;
		//String mediaStr = Double.toString(media);
		JOptionPane.showMessageDialog(null, "Media salarial da empresa: " + media);
			
	}

}