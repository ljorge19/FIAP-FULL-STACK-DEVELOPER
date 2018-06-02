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
import br.com.fiap.verificadores.VerificadorDadosViaTeclado;

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
		AlunoDao alunoDao = new AlunoDao(em);

		// setando a escola vinculada ao curso
		Escola escola = new Escola();
		escola.setId(1L);

		// setando os dados do aluno
		Aluno aluno = new Aluno();
		aluno.setNome(JOptionPane.showInputDialog("Nome do aluno -> "));
		VerificadorDadosViaTeclado verificador = new VerificadorDadosViaTeclado();
		String opcaoViaTeclado = null;
		Long cpfAluno = 0L;
		opcaoViaTeclado = JOptionPane.showInputDialog("Inserir o cpf do aluno -> ");

		// verificando dados via teclado
		verificador.verificaInteiros(opcaoViaTeclado);
		cpfAluno = Long.valueOf(opcaoViaTeclado);
		aluno.setCpf(cpfAluno);
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
		VerificadorDadosViaTeclado verificador = new VerificadorDadosViaTeclado();
		Curso curso = null;

		// dados recebidos via teclado
		String opcaoViaTeclado1 = null;
		Long codigoCurso = 0L;
		opcaoViaTeclado1 = JOptionPane.showInputDialog("Inserir o c�digo do curso -> ");

		// verificando se existe caracteres nos dados do c�digo do curso
		/*
		 * if (!opcaoViaTeclado1.matches("^[0-9]*$")) opcaoViaTeclado1 = "100";
		 * System.out.println("Op��o Inv�lida!");{ JOptionPane.showMessageDialog(null,
		 * "Op��o Inv�lida!"); System.exit(0); }
		 * 
		 * if (opcaoViaTeclado1.equals("")) { opcaoViaTeclado1 = "100";
		 * System.out.println("Op��o Inv�lida!"); JOptionPane.showMessageDialog(null,
		 * "Op��o Inv�lida!"); System.exit(0); }
		 */

		verificador.verificaInteiros(opcaoViaTeclado1);
		codigoCurso = Long.valueOf(opcaoViaTeclado1);
		try {
			curso = cursoDao.consultarCursoPorId(codigoCurso);
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

		// dados recebidos via teclado
		String opcaoViaTeclado2 = null;
		Long codigoAluno = 0L;
		opcaoViaTeclado2 = JOptionPane.showInputDialog("Inserir o c�digo do aluno -> ");

		verificador.verificaInteiros(opcaoViaTeclado2);
		codigoAluno = Long.valueOf(opcaoViaTeclado2);
		try {
			aluno = alunoDao.consultarAlunoPorId(codigoAluno);
			if (aluno == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		//
		// instanciando o CursoAluno que ser� inserido
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
		VerificadorDadosViaTeclado verificador = new VerificadorDadosViaTeclado();

		// dados recebidos via teclado
		String opcaoViaTeclado1 = null;
		Long codigoCurso = 0L;
		opcaoViaTeclado1 = JOptionPane.showInputDialog("Inserir o c�digo do curso -> ");

		verificador.verificaInteiros(opcaoViaTeclado1);
		codigoCurso = Long.valueOf(opcaoViaTeclado1);

		try {
			curso = cursoDao.consultarCursoPorId(codigoCurso);
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

		// dados recebidos via teclado
		String opcaoViaTeclado2 = null;
		Long codigoAluno = 0L;
		opcaoViaTeclado2 = JOptionPane.showInputDialog("Inserir o c�digo do aluno -> ");

		verificador.verificaInteiros(opcaoViaTeclado2);
		codigoAluno = Long.valueOf(opcaoViaTeclado2);
		try {
			aluno = alunoDao.consultarAlunoPorId(codigoAluno);
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
				System.out.println("C�DIGO DO ALUNO: " + aluno.getId()); 
				System.out.println("NOME DO ALUNO: " + aluno.getNome());
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Listar situa��o do aluno
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

		// dados recebidos via teclado
		VerificadorDadosViaTeclado verificador = new VerificadorDadosViaTeclado();
		String opcaoViaTeclado2 = null;
		Long codigoAluno = 0L;
		opcaoViaTeclado2 = JOptionPane.showInputDialog("Inserir o c�digo do aluno -> ");

		verificador.verificaInteiros(opcaoViaTeclado2);
		codigoAluno = Long.valueOf(opcaoViaTeclado2);
		try {
			aluno = alunoDao.consultarAlunoPorId(codigoAluno);
			if (aluno == null) {
				alunoExistente = false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

		CursoAlunoDao cursoAlunoDao = new CursoAlunoDao(em1);

		try {
			for (CursoAluno cursoAlunos : cursoAlunoDao.consultarSituacaoAluno(aluno)) {
				if (cursoAlunos == null) {
					alunoExistente = false;
					System.out.println("-------------------------------------");
					System.out.println("Aluno n�o existente, c�digo incorreto ! ");
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
