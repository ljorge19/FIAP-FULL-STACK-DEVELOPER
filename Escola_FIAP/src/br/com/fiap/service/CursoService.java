package br.com.fiap.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.CursoDao;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.Escola;

public class CursoService {
	
	/**
	 * Metodo para incluir um curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void incluirCurso() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		CursoDao cursoDao = new CursoDao(em);

		Curso curso = new Curso();
		curso.setNome(JOptionPane.showInputDialog("Nome do curso -> "));
		Escola escola = new Escola();
		escola.setId(1L);
		curso.setEscola(escola);

		try {
			cursoDao.salvar(curso);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Listar cursos
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void listarCursos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		CursoDao cursoDao = new CursoDao(em);

		try {
			for (Curso curso : cursoDao.listarCursos()) {
				System.out.println("-------------------------------------");
				System.out.println("Código do curso: " + curso.getId()); 
				System.out.println("Nome do curso: " + curso.getNome());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
