package ex4;

public enum ClassificacaoClientes {
	
	POTENCIAL(400_000,500_000), 
	MEDIO(200_000,400_000), 
	BAIXO(0,200_000);
	
	private double faixaInicial;
	private double faixaFinal;
	
	ClassificacaoClientes(double faixaInicial, double faixaFinal){
		this.faixaInicial=faixaInicial;
		this.faixaFinal=faixaFinal;
	}
	
	  public boolean isCompatible(ContaBancaria conta){
    	if (conta.getSaldo()>=faixaInicial && conta.getSaldo()<=faixaFinal){
    		System.out.println(this.name()+" Renda compativel.");
    		return true;
    	}
    	else
    	{
    		System.out.println(this.name()+" Renda não compativel.");
    		return false;
    	}
    }

}
