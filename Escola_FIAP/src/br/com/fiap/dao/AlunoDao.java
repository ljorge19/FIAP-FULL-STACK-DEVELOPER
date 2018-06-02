package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Aluno;
import br.com.fiap.entity.Escola;


public class AlunoDao {
	private EntityManager em;

	public AlunoDao(EntityManager em) {
		this.em = em;
	}

	public Aluno salvar(Aluno aluno) throws Exception {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	     
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      if(aluno.getId() == null) {
	        //Salva os dados da pessoa.
	        em.persist(aluno);
	        System.out.println("incluido com sucesso");
	        JOptionPane.showMessageDialog(null, "incluido com sucesso");
	      } else {
	        //Atualiza os dados da pessoa.
	        aluno = em.merge(aluno);
	        System.out.println("alterado com sucesso");
	        JOptionPane.showMessageDialog(null, "alterado com sucesso");
	      }
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return aluno;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a pessoa na base de dados através do seu ID.
	      Aluno aluno = em.find(Aluno.class, id);
	      System.out.println("Excluindo o aluno: " + aluno.getNome());
	      // Remove a pessoa da base de dados.
	      em.remove(aluno);
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
	  public Aluno consultarAlunoPorId(Long id) {
	    Aluno aluno = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      aluno = em.find(Aluno.class, id);
	    } finally {
	      em.close();
	    }
	    return aluno;
	  }
	  
	  public List<Aluno> listarAlunos() {
			TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a", Aluno.class);
			return query.getResultList();
		}
	}
