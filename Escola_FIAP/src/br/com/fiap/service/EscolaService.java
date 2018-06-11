package br.com.fiap.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.com.fiap.dao.DaoEscolaJDBC;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.entity.Escola;

public class EscolaService {

	/**
	 * Metodo para incluir a escola via uma conex�o JDBC
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void incluirEscolaJDBC() {
		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			DaoEscolaJDBC dao = new DaoEscolaJDBC();
			// Instanciando a classe Evento

			Escola rs = new Escola();
			Escola escola = new Escola();
			escola.setId(1L);

			rs = dao.buscar(escola.getId());
			if (rs == null) {

				String nomeEscola = JOptionPane.showInputDialog("nome da escola:");

				String enderecoEscola = JOptionPane.showInputDialog("endere�o da escola:");

				escola.setNome(nomeEscola);
				escola.setEndere�o(enderecoEscola);

				dao.incluir(escola);

				JOptionPane.showMessageDialog(null, "Solicita��o executada com sucesso", "Mensagem",
						JOptionPane.INFORMATION_MESSAGE);

			}

			else {

				String nomeEscola = JOptionPane.showInputDialog("nome da escola:");

				String enderecoEscola = JOptionPane.showInputDialog("endere�o da escola:");

				escola.setNome(nomeEscola);
				escola.setEndere�o(enderecoEscola);

				dao.update(escola);

				JOptionPane.showMessageDialog(null, "Solicita��o executada com sucesso", "Mensagem",
						JOptionPane.INFORMATION_MESSAGE);

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo para incluir a escola
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void incluirEscola() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		EscolaDao escolaDao = new EscolaDao(em);

		Escola escola = new Escola();
		escola.setId(1L);
		escola.setNome(JOptionPane.showInputDialog("Nome da escola -> "));
		escola.setEndere�o(JOptionPane.showInputDialog("Endere�o da escola -> "));
		try {
			escolaDao.salvar(escola);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	/**
	 * Listar escolas
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void listarEscolas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		EscolaDao escolaDao = new EscolaDao(em);

		try {
			for (Escola escola : escolaDao.listarEscolas()) {
				System.out.println("-------------------------------------");
				System.out.println("Escola");
				System.out.println("-------------------------------------");
				System.out.println("C�digo da escola: " + escola.getId());
				System.out.println("Nome da escola: " + escola.getNome());
				System.out.println("Endere�o: " + escola.getEndere�o());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

}
