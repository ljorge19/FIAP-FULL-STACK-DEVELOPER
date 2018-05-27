package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Escola;


public class EscolaDao {
	private EntityManager em;

	public EscolaDao(EntityManager em) {
		this.em = em;
	}

	public Escola salvar(Escola escola) throws Exception {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      System.out.println("Salvando a pessoa.");
	      // Verifica se a pessoa ainda não está salva no banco de dados.
	      if(escola.getId() == null) {
	        //Salva os dados da pessoa.
	        em.persist(escola);
	      } else {
	        //Atualiza os dados da pessoa.
	        escola = em.merge(escola);
	      }
	      // Finaliza a transação.
	      em.getTransaction().commit();
	    } finally {
	      em.close();
	    }
	    return escola;
	  }
	
	public void excluir(Long id) {
	    try {
	      // Inicia uma transação com o banco de dados.
	      em.getTransaction().begin();
	      // Consulta a pessoa na base de dados através do seu ID.
	      Escola escola = em.find(Escola.class, id);
	      System.out.println("Excluindo o escola: " + escola.getNome());
	      // Remove a pessoa da base de dados.
	      em.remove(escola);
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
	  public Escola consultarEscola(Long id) {
	    Escola escola = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      escola = em.find(Escola.class, id);
	    } finally {
	      em.close();
	    }
	    return escola;
	  }
	}
