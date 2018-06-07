package exercicio2;

public class Main {
	public static void main(String[] args) {
		EquipamentoEletronico tablet = new Tablet();
		EquipamentoEletronico smartphone = new Smartphone();
		Equipamento equipamento = new Equipamento();
		Object objeto = new Object();
		Movel movel = new Movel();
		Tablet tablet2 = new Tablet();
		Smartphone smartphone2 = new Smartphone();
		
		
	    objeto = equipamento; 
	    objeto = movel;
	    equipamento=tablet2;
	    equipamento=smartphone2;
	    smartphone=tablet;
	    //smartphone2=tablet2;
	    equipamento=(Equipamento) tablet;
	    movel=(Movel) tablet;
	    tablet=(EquipamentoEletronico) equipamento;
	    
	    /*
	     * 
	     * RESPOSTAS
	     * 
	     */
	    
	  /*  A. objeto para equipamento (objeto=equipamento;);
	    Resposta = Implicito.

	    B. objeto para móvel (objeto=movel;);
	    Resposta = Implicito.


	    C. equipamento para tablet2 (equipamento=tablet2;);
	    Resposta = Implicito

	    D. equipamento para smartphone2 (equipamento=smartphone2;);
	    Resposta = Implicito

	    E. smartphone para tablet (smartphone=tablet;);
	    Resposta = Implicito

	    F. smartphone2 para tablet2 (smartphone2=tablet2;);
	    Resposta = Impossivel

	    G. equipamento para tablete (equipamento=(Equipamento) tablet;);
	    Resposta = Explicito

	    H. movel para tablete (movel=(Movel) tablet;);
	    Resposta = Explicito

	    I. tablet para equipamento (tablet=(EquipamentoEletronico) equipamento;); 
	    Resposta = Explicito*/
	    
	}
}