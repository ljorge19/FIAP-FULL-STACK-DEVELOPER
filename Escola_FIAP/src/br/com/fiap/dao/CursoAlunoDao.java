package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Curso;
import br.com.fiap.entity.CursoAluno;



public class CursoAlunoDao {
	private EntityManager em;

	public CursoAlunoDao(EntityManager em) {
		this.em = em;
	}

	public CursoAluno salvar(CursoAluno cursoAluno) throws Exception {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Verifica se a elemento ainda não está salva no banco de dados.
	      if(cursoAluno.getId() == null) {
	        //Salva os dados da elemento.
	        em.persist(cursoAluno);
	        System.out.println("Solicitação executada com sucesso");
	        JOptionPane.showMessageDialog(null, "Solicitação executada com sucesso");
	      } else {
	        //Atualiza os dados da elemento.
	    	  cursoAluno = em.merge(cursoAluno);
	    	  System.out.println("Solicitação executada com sucesso");
	    	  JOptionPane.showMessageDialog(null, "Solicitação executada com sucesso");
	      }
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return cursoAluno;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a elemento na base de dados através do seu ID.
	      CursoAluno cursoAluno = em.find(CursoAluno.class, id);
	      System.out.println("Excluindo o relacionamento entre curso id= "  + cursoAluno.getCurso().getNome() + "Aluno id= " + cursoAluno.getAluno().getNome());
	      // Remove a elemento da base de dados.
	      em.remove(cursoAluno);
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	  }
	
	 /**
	   * Consulta o elemento pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	
	public List<CursoAluno> consultarCursoAlunoPorId(Aluno aluno, Curso curso) {
		TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.aluno = :aluno and e.curso = :curso", CursoAluno.class);
		query.setParameter("aluno", aluno);
		query.setParameter("curso", curso);
		return query.getResultList();
	}
	  
	  public List<CursoAluno> consultarSituacaoAluno(Aluno aluno) {
			TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.aluno = :aluno", CursoAluno.class);
			query.setParameter("aluno", aluno);
			return query.getResultList();
		}
	  
	  public List<CursoAluno> listarCursoAluno() {
			TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e", CursoAluno.class);
			return query.getResultList();
		}

	}
