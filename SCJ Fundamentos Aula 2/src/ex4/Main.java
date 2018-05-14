package ex4;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		ContaPoupanca conta1 = new ContaPoupanca("Leandro", "de Jesus Jorge", "362.767.358-78", LocalDate.of(1986, 1, 12), LocalDate.now());
		conta1.deposita(500000);
		
		
		ClassificacaoClientes.POTENCIAL.isCompatible(conta1);
		ClassificacaoClientes.MEDIO.isCompatible(conta1);
		ClassificacaoClientes.BAIXO.isCompatible(conta1);

	}

}
