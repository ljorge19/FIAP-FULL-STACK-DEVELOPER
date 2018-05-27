package br.com.fiap.aplicacao;

import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.com.fiap.dao.EventosDao;
import br.com.fiap.entity.Evento;

public class CadastroParticipante {
	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(UIManager
					.getSystemLookAndFeelClassName());
			
			while(true) {
				int opcao = JOptionPane.showConfirmDialog(
						null, 
						"Deseja incluir um participante?", 
						"Confirmação", 
						JOptionPane.YES_NO_OPTION);
				
				if(opcao == JOptionPane.NO_OPTION) {
					break;
				}
				
				//Buscando o evento
				EventosDao dao = new EventosDao();
				Set<Evento> listaEventos = dao.listar();
				
				Evento evento = (Evento)JOptionPane.showInputDialog(
						null,
						"Selecione um evento",
						"Eventos",
						JOptionPane.DEFAULT_OPTION,
						null,
						listaEventos.toArray(),
						null);
				
				String nome = JOptionPane
						.showInputDialog("Nome do participante");
				String email = JOptionPane
						.showInputDialog("Email do participante");
				
				/*
				 * - Implementar a classe ParticipantesDao
				 * - Preparar a inclusão do participante
				 * - Prever uma opção para listar todos os 
				 *   participantes de um evento.
				 */
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null, 
					"ERRO: " + e.getMessage(),
					"Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
