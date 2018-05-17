package br.com.fiap.aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import br.com.fiap.dao.EventosDao;
import br.com.fiap.entity.Evento;

public class CadastroEventos {

	public static void main(String[] args) {
		try {
			while(true) {
			 int opcao = JOptionPane.showConfirmDialog(null, "deseja incluir um evento ?", 
						                                     "confirmacao ?",
						                                     JOptionPane.YES_NO_OPTION);
			 
			 if(opcao == JOptionPane.NO_OPTION) {
				 break;
			 }
			 
			 String descricao = JOptionPane.showInputDialog("descricao do evento");
			 String data = JOptionPane.showInputDialog("data do evento (dd/MM/aaaa): ");
			 Date dataEvento = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			 String responsavel = JOptionPane.showInputDialog("descricao do evento");
			 
			 
			 Evento evento = new Evento();
			 evento.setDescricao(descricao);
			 evento.setData(dataEvento);
			 evento.setResponsavel(responsavel);
			 
			 
			 EventosDao dao = new EventosDao();
			 dao.incluir(evento);
			
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro: " + e.getMessage());
		}

	}

}
