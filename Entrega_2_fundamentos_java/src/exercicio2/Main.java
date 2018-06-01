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
	    
	  /*  a. objeto para equipamento (objeto=equipamento;);
	    resposta = Implicito.

	    b. objeto para móvel (objeto=movel;);
	    resposta = Implicito.


	    c. equipamento para tablet2 (equipamento=tablet2;);
	    resposta = Implicito

	    d. equipamento para smartphone2 (equipamento=smartphone2;);
	    resposta = Implicito

	    e. smartphone para tablet (smartphone=tablet;);
	    resposta = Implicito

	    f. smartphone2 para tablet2 (smartphone2=tablet2;);
	    resposta = Impossivel

	    g. equipamento para tablete (equipamento=(Equipamento) tablet;);
	    resposta = Explicito

	    h. movel para tablete (movel=(Movel) tablet;);
	    resposta = Explicito

	    i. tablet para equipamento (tablet=(EquipamentoEletronico) equipamento;); 
	    resposta = Explicito*/
	    
	}
}