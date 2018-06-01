package br.com.fiap.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoAlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.CursoAluno;
import br.com.fiap.entity.Escola;

public class AlunoService {

	/**
	 * Metodo para incluir um aluno
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void incluirAluno() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();

		// setando a escola que será vinculada ao curso
		Escola escola = new Escola();
		escola.setId(1L);

		AlunoDao alunoDao = new AlunoDao(em);
		Aluno aluno = new Aluno();
		aluno.setNome("Leandro Jorge");
		aluno.setCpf(36272435878L);
		aluno.setEscola(escola);

		try {
			alunoDao.salvar(aluno);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	/**
	 * Vincular aluno ao curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void vincularAlunoCurso() {
		boolean alunoExistente = true;
		boolean cursoExistente = true;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

		//
		// verificar se o curso existe
		//
		EntityManager em1 = emf.createEntityManager();
		CursoDao cursoDao = new CursoDao(em1);
		Curso curso = null;
		try {
			curso = cursoDao.consultarCursoPorId(1L);
			if (curso == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		//
		// verificar se o aluno existe
		//
		EntityManager em2 = emf.createEntityManager();
		AlunoDao alunoDao = new AlunoDao(em2);
		Aluno aluno = null;
		try {
			aluno = alunoDao.consultarAlunoPorId(2L);
			if (aluno == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		//
		// instanciando o CursoAluno que será inserido
		//
		EntityManager em3 = emf.createEntityManager();
		CursoAluno cursoAluno = new CursoAluno();
		cursoAluno.setNomeAluno(aluno.getNome());
		cursoAluno.setAluno(aluno);
		cursoAluno.setNomeCurso(curso.getNome());
		cursoAluno.setCurso(curso);

		if (alunoExistente == true && cursoExistente == true) {

			CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em3);
			try {
				cursoAlunoDao.salvar(cursoAluno);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}

	/**
	 * Vincular nota do aluno ao curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */

	public void incluirNotasDosAlunosPorCurso() {
		boolean alunoExistente = true;
		boolean cursoExistente = true;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em1 = emf.createEntityManager();

		EntityManager em2 = emf.createEntityManager();

		EntityManager em3 = emf.createEntityManager();

		//
		// verificar se o curso existe
		//
		CursoDao cursoDao = new CursoDao(em1);
		Curso curso = null;
		try {
			curso = cursoDao.consultarCursoPorId(1L);
			if (curso == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		//
		// verificar se o aluno existe
		//
		AlunoDao alunoDao = new AlunoDao(em2);
		Aluno aluno = null;
		try {
			aluno = alunoDao.consultarAlunoPorId(2L);
			if (aluno == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		// chamar o campo para inserir a nota do aluno

		//
		// inserindo a nota do aluno
		//
		CursoAluno cursoAluno = null;
		if (alunoExistente == true && cursoExistente == true) {

			CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em3);

			/*
			 * try { cursoAluno = cursoAlunoDao.consultarCursoAlunoPorId(2L, 1L); } catch
			 * (Exception e) { JOptionPane.showMessageDialog(null, "ERRO: " +
			 * e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); e.printStackTrace(); }
			 */

			try {
				for (CursoAluno cursoAlunos : cursoAlunoDao.consultarCursoAlunoPorId(aluno, curso)) {
					cursoAluno = new CursoAluno();
					cursoAluno.setId(cursoAlunos.getId());
					cursoAluno.setAluno(aluno);
					cursoAluno.setCurso(curso);
					cursoAluno.setNomeAluno(aluno.getNome());
					cursoAluno.setNomeCurso(curso.getNome());
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

			// colocar a nota vinda pelo joptionpane
			cursoAluno.setNota(10);
			try {
				cursoAlunoDao.salvar(cursoAluno);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}

		}
	}

	/**
	 * Listar alunos
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void listarAlunos() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		AlunoDao alunoDao = new AlunoDao(em);

		try {
			for (Aluno aluno : alunoDao.listarAlunos()) {
				System.out.println("-------------------------------------");
				System.out.println("Código do aluno: " + aluno.getId() + "Nome do aluno: " + aluno.getNome());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	
	/**
	 * Listar situação do aluno
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	public void listarSituacaoDoAluno() {
		boolean alunoExistente = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em1 = emf1.createEntityManager();

		
		
		EntityManager em2 = emf1.createEntityManager();
		//
		// verificar se o aluno existe
		//
		AlunoDao alunoDao = new AlunoDao(em2);
		Aluno aluno = null;
		try {
			aluno = alunoDao.consultarAlunoPorId(2L);
			if (aluno == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		
		CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em1);

		try {
			for (CursoAluno cursoAlunos : cursoAlunoDao.listarCursoAluno()) {
				if (cursoAlunos == null) {
					alunoExistente = false;
					System.out.println("-------------------------------------");
					System.out.println("Aluno não existente, código incorreto ! ");
					System.out.println("-------------------------------------");
				}
				System.out.println("-------------------------------------");
				System.out.println("Nome do curso: " + cursoAlunos.getNomeCurso());
				System.out.println("Nome do aluno: " + cursoAlunos.getNomeAluno());
				System.out.println("Nota do aluno: " + cursoAlunos.getNota());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
}
