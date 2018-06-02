package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

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
	      // Verifica se a elemento ainda não está salva no banco de dados.
	      if(curso.getId() == null) {
	        //Salva os dados da elemento.
	        em.persist(curso);
	        System.out.println("incluido com sucesso");
	        JOptionPane.showMessageDialog(null, "incluido com sucesso");
	      } else {
	        //Atualiza 
	        curso = em.merge(curso);
	        System.out.println("alterado com sucesso");
	        JOptionPane.showMessageDialog(null, "alterado com sucesso");
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
	      // Consulta a elemento na base de dados através do seu ID.
	      Curso curso = em.find(Curso.class, id);
	      System.out.println("Excluindo o curso: " + curso.getNome());
	      // Remove a elemento da base de dados.
	      em.remove(curso);
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
	  public Curso consultarCursoPorId(Long id) {
	    Curso curso = null;
	    try {
	      //Consulta uma elemento pelo seu ID.
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
