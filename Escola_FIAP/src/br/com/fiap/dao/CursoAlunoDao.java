package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.CursoAluno;



public class CursoAlunoDao {
	private EntityManager em;

	public CursoAlunoDao(EntityManager em) {
		this.em = em;
	}

	public CursoAluno salvar(CursoAluno disciplina) throws Exception {
	    try {
	      // Inicia uma transa��o com o banco de dados.
	      em.getTransaction().begin();
	      System.out.println("Salvando a pessoa.");
	      // Verifica se a pessoa ainda n�o est� salva no banco de dados.
	      if(disciplina.getId() == null) {
	        //Salva os dados da pessoa.
	        em.persist(disciplina);
	      } else {
	        //Atualiza os dados da pessoa.
	        disciplina = em.merge(disciplina);
	      }
	      // Finaliza a transa��o.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return disciplina;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transa��o com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a pessoa na base de dados atrav�s do seu ID.
	      CursoAluno disciplina = em.find(CursoAluno.class, id);
	      System.out.println("Excluindo o disciplina: " + disciplina.getNomeCurso());
	      // Remove a pessoa da base de dados.
	      em.remove(disciplina);
	      // Finaliza a transa��o.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	  }
	
	 /**
	   * Consulta o pessoa pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	  public CursoAluno consultarCursoAlunoPorId(Long aluno, Long curso) {
	    CursoAluno cursoAlunoRetorno = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	    	TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.aluno = :aluno and e.curso = :curso ", CursoAluno.class);
	    } finally {
	      em.close();
	    }
	    return cursoAlunoRetorno;
	  }
	  
	 /* public CursoAluno consultarAlunoPorId(Long aluno) {
		    CursoAluno alunoRetorno = null;
		    try {
		      //Consulta uma pessoa pelo seu ID.
		    	TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.aluno = :aluno ", CursoAluno.class);
		    } finally {
		      em.close();
		    }
		    return alunoRetorno;
		  }*/
	  
	  public List<CursoAluno> consultarSituacaoAluno(Long aluno) {
			TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e where e.aluno = :aluno ", CursoAluno.class);
			return query.getResultList();
		}
	  
	  public List<CursoAluno> listarCursoAluno() {
			TypedQuery<CursoAluno> query = em.createQuery("Select e from CursoAluno e", CursoAluno.class);
			return query.getResultList();
		}

	}
