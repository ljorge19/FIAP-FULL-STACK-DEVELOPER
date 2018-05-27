package br.com.fiap.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.EscolaDao;
import br.com.fiap.entity.Escola;

public class AppEscola {

	public static void main(String[] args) {
		incluirEscola();
		incluirEscola();
		listarEscola();
		// listarParticipantes(3);
	}

	private static void incluirEscola() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		EscolaDao escolaDao = new EscolaDao(em);

		Escola escola = new Escola();
		escola.setNome("Escola do FIAP");
		escola.setEndereço("av lins de vasconcelos 1222");
		try {
			escolaDao.salvar(escola);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private static void listarEscola() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		EscolaDao escolaDao = new EscolaDao(em);

		Escola escola = new Escola();
		escola.setId(1L);
		try {
			Escola escola2 = escolaDao.consultarEscola(escola.getId());
			System.out.println("-------------------------------------");
			System.out.println("Id: " + escola2.getId());
			System.out.println("Descrição: " + escola2.getEndereço());
			System.out.println("-------------------------------------");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
