package br.com.fiap.aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.dao.AlunoDao;
import br.com.fiap.dao.CursoAlunoDao;
import br.com.fiap.dao.CursoDao;
import br.com.fiap.dao.EscolaDao;
import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.CursoAluno;
import br.com.fiap.entity.Escola;

public class AppEscola {

	public static void main(String[] args) {

		incluirEscola();
		incluirAluno();
		incluirCurso();
		/*
		 * vincularAlunoCurso(); notasDosAlunosPorCurso();
		 */
		// listarEscolas();
	}

	/**
	 * Metodo para incluir uá escola
	 * 
	 * 
	 * 
	 * @noReturn
	 */
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

	/**
	 * Metodo para incluir um aluno
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	private static void incluirAluno() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();

		// setando a escola que será vinculada ao curso
		Escola escola = new Escola();
		escola.setId(1L);

		AlunoDao alunoDao = new AlunoDao(em);
		Aluno aluno = new Aluno();
		aluno.setNome("Leandro Jorge");
		aluno.setCpf(36272435878L);

		try {
			alunoDao.salvar(aluno);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	/**
	 * Metodo para incluir um curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	private static void incluirCurso() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		CursoDao cursoDao = new CursoDao(em);

		Curso curso = new Curso();
		curso.setNome("Aula de Java");
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
	 * Vincular aluno ao curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	private static void vincularAlunoCurso() {
		boolean alunoExistente = true;
		boolean cursoExistente = true;
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em1 = emf1.createEntityManager();

		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em2 = emf2.createEntityManager();

		EntityManagerFactory emf3 = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em3 = emf3.createEntityManager();

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
			aluno = alunoDao.consultarAlunoPorId(1L);
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
		CursoAluno cursoAluno = new CursoAluno();
		cursoAluno.setNomeAluno(aluno.getNome());
		cursoAluno.setAluno(aluno);
		cursoAluno.setNomeCurso(curso.getNome());
		cursoAluno.setCurso(curso);

		CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em3);
		try {
			cursoAlunoDao.salvar(cursoAluno);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Vincular nota do aluno ao curso
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	/*
	 * private static void notasDosAlunosPorCurso() { EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("jpaPU"); EntityManager em =
	 * emf.createEntityManager(); AlunoDao alunoDao = new AlunoDao(em);
	 * CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em);
	 * 
	 * try {
	 * 
	 * cursoAlunoDao.salvar(disciplina);
	 * 
	 * } } catch (Exception e) { JOptionPane.showMessageDialog(null, "ERRO: " +
	 * e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); e.printStackTrace(); } }
	 */

	/**
	 * Listar escolas
	 * 
	 * 
	 * 
	 * @noReturn
	 */
	private static void listarEscolas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
		EntityManager em = emf.createEntityManager();
		EscolaDao escolaDao = new EscolaDao(em);

		try {
			for (Escola escola : escolaDao.listarEscolas()) {
				System.out.println("-------------------------------------");
				System.out.println("Id: " + escola.getId());
				System.out.println("Descrição: " + escola.getEndereço());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/*
	 * private static void listaNotasDosAlunosPorCurso() { EntityManagerFactory emf
	 * = Persistence.createEntityManagerFactory("jpaPU"); EntityManager em =
	 * emf.createEntityManager(); AlunoDao alunoDao = new AlunoDao(em);
	 * CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em);
	 * 
	 * try { for (Aluno alunos : alunoDao.listarAlunos()) { Notas notas =
	 * notasDao.consultarNotasPorId(alunos.getId());
	 * System.out.println("-------------------------------------");
	 * System.out.println("NOME ALUNO: " + alunos.getNome());
	 * System.out.println("CPF: " + alunos.getCpf()); System.out.println("CURSO: " +
	 * notas.getNome()); System.out.println("NOTA: " + notas.getNota());
	 * System.out.println("-------------------------------------"); } } catch
	 * (Exception e) { JOptionPane.showMessageDialog(null, "ERRO: " +
	 * e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE); e.printStackTrace(); }
	 */
}
