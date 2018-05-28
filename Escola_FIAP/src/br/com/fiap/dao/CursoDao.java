package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Curso;



public class CursoDao {
	private EntityManager em;

	public CursoDao(EntityManager em) {
		this.em = em;
	}

	public Curso salvar(Curso curso) throws Exception {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      System.out.println("Salvando a pessoa.");
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      if(curso.getId() == null) {
	        //Salva os dados da pessoa.
	        em.persist(curso);
	      } else {
	        //Atualiza os dados da pessoa.
	        curso = em.merge(curso);
	      }
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return curso;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a pessoa na base de dados através do seu ID.
	      Curso curso = em.find(Curso.class, id);
	      System.out.println("Excluindo o curso: " + curso.getNome());
	      // Remove a pessoa da base de dados.
	      em.remove(curso);
	      // Finaliza a transação.
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
	  public Curso consultarCursoPorId(Long id) {
	    Curso curso = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      curso = em.find(Curso.class, id);
	    } finally {
	      em.close();
	    }
	    return curso;
	  }
	  
	  public List<Curso> listarCursos() {
			TypedQuery<Curso> query = em.createQuery("Select e from Curso e", Curso.class);
			return query.getResultList();
		}

	}
