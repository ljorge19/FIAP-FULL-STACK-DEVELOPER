package br.com.fiap.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.EscolaDao;
import br.com.fiap.entity.Escola;

public class EscolaService {
	
	
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
		escola.setEndereço(JOptionPane.showInputDialog("Endereço da escola -> "));
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
				System.out.println("Código da escola: " + escola.getId());
				System.out.println("Nome da escola: " + escola.getNome());
				System.out.println("Descrição: " + escola.getEndereço());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
}
