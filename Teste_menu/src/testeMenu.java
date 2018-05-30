import javax.swing.JOptionPane;

public class testeMenu {


public static void main(String[] args) {
		menu();
		
	//  menu principal
}
	private static void menu() { // menu principal
		String opcaoViaTeclado =null;
		int opcao = 0;
		do {
			System.out
					.println("\n\n### SISCOM - Sistema Comercial de Controle de Compras e Vendas ###");
			System.out.println("\n                  =========================");
			System.out.println("                  |     1 - Venda         |");
			System.out.println("                  |     2 - Vendedor      |");
			System.out.println("                  |     3 - Compra        |");
			System.out.println("                  |     4 - Produto       |");
			System.out.println("                  |     5 - Cliente       |");
			System.out.println("                  |     6 - Fornecedor    |");
			System.out.println("                  |     0 - Sair          |");
			System.out.println("                  =========================\n");
			opcaoViaTeclado = JOptionPane.showInputDialog("OpÁ„o -> ");
			System.out.print("\n");
			
			/* if (opcaoViaTeclado.matches("^[a-zA-Z¡¬√¿«… Õ”‘’⁄‹·‚„‡ÁÈÍÌÛÙı˙¸]*$")) {
		         System.out.println("SÛ tem letras.");
		         opcaoViaTeclado = "10";
			 }else if (opcaoViaTeclado.matches("^[0-9]*$")) {
		         System.out.println("SÛ tem dÌgitos.");
			 }*/
			 
			if (!opcaoViaTeclado.matches("^[0-9]*$"))
			     opcaoViaTeclado = "100";
			
			if (opcaoViaTeclado.equals(""))
				 opcaoViaTeclado = "100";
			
			
			opcao = Integer.valueOf(opcaoViaTeclado);
			switch (opcao) {
			case 1:
				System.out.println("                  |     1 - Venda         |");
				break;
			case 2:
				System.out.println("                  |     2 - Vendedo       |");
				break;
			case 3:
				System.out.println("                  |     3 - Compra        |");
				break;
			case 4:
				System.out.println("                  |     4 - Produto       |");
				break;
			case 5:
				System.out.println("                  |     5 - Client        |");
				break;
			case 0:
			     System.out.println("Programa encerrado.");
			     JOptionPane.showMessageDialog(null, "Programa encerrado.");
			     break;
			default:
				System.out.println("OpÁ„o Inv·lida!");
				JOptionPane.showMessageDialog(null, "OpÁ„o Inv·lida!");
				break;
			}
		} while (opcao != 0);
	}
//aqui voce cria os metodos, da mesma forma que foi criado e menu, retornando os valores dos calculos que o aplicativo calculou?
}

