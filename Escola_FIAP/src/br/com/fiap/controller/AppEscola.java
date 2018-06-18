package br.com.fiap.controller;

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
import br.com.fiap.service.AlunoService;
import br.com.fiap.service.CursoService;
import br.com.fiap.service.EscolaService;

public class AppEscola {

	public static void main(String[] args) {
		menu();
		// 1-incluirEscola();
		// 2-incluirAluno();
		// 3-incluirCurso();
		// 4-vincularAlunoCurso();
		// 5-incluirNotasDosAlunosPorCurso();
		// 6-listarEscolas();
		// 7-listarAlunos();
		// 8-listarCursos();
		// 9-listarSituacaoDoAluno();
	}

	private static void menu() { // menu principal
		String opcaoViaTeclado = null;
		int opcao = 0;
		EscolaService escolaService = new EscolaService();
		CursoService cursoService = new CursoService();
		AlunoService alunoService = new AlunoService();

		do {
			System.out.println("\n\n### SISCCAE - Sistema Cadastramento e Controle de aluno e escola ###");
			System.out.println("\n");
			System.out.println("             ============================================");
			System.out.println("             |     1 - Incluir/alterar dados da escola  |");
			System.out.println("             |     2 - Incluir/alterar aluno            |");
			System.out.println("             |     3 - Incluir/alterar curso            |");
			System.out.println("             |     4 - vincular aluno curso             |");
			System.out.println("             |     5 - Incluir/alterar notas Dos alunos |");
			System.out.println("             |     6 - Mostrar dados da escola          |");
			System.out.println("             |     7 - listar alunos                    |");
			System.out.println("             |     8 - listar cursos                    |");
			System.out.println("             |     9 - listar situacao Do Aluno         |");
			System.out.println("             |     0 - Sair                             |");
			System.out.println("             ============================================");
			System.out.println("\n");
			opcaoViaTeclado = JOptionPane.showInputDialog("Opções do menu -> ");
			System.out.print("\n");

			if (!opcaoViaTeclado.matches("^[0-9]*$"))
				opcaoViaTeclado = "100";

			if (opcaoViaTeclado.equals(""))
				opcaoViaTeclado = "100";

			opcao = Integer.valueOf(opcaoViaTeclado);
			switch (opcao) {
			case 1:
				escolaService.incluirEscolaJDBC();
				break;
			case 2:
				alunoService.incluirAluno();
				break;
			case 3:
				cursoService.incluirCurso();
				break;
			case 4:
				alunoService.vincularAlunoCurso();
				break;
			case 5:
				alunoService.incluirNotasDosAlunosPorCurso();
				break;
			case 6:
				escolaService.listarEscolas();
				break;
			case 7:
				alunoService.listarAlunos();
				break;
			case 8:
				cursoService.listarCursos();
				break;
			case 9:
				alunoService.listarSituacaoDoAluno();
				break;
			case 0:
				System.out.println("Programa encerrado.");
				JOptionPane.showMessageDialog(null, "Programa encerrado.");
				break;
			default:
				System.out.println("Opção Inválida!");
				JOptionPane.showMessageDialog(null, "Opção Inválida!");
				break;
			}
		} while (opcao != 0);
	}
}
