package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

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
	      // Verifica se a elemento ainda não está salva no banco de dados.
	      if(escola.getId() == null) {
	        //Salva os dados da elemento.
	        em.persist(escola);
	        System.out.println("Solicitação executada com sucesso");
	        JOptionPane.showMessageDialog(null, "Solicitação executada com sucesso");
	      } else {
	        //Atualiza os dados da elemento.
	        escola = em.merge(escola);
	        System.out.println("alterado com sucesso");
	        JOptionPane.showMessageDialog(null, "alterado com sucesso");
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
	      // Consulta a elemento na base de dados através do seu ID.
	      Escola escola = em.find(Escola.class, id);
	      System.out.println("Excluindo o escola: " + escola.getNome());
	      // Remove a elemento da base de dados.
	      em.remove(escola);
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
	  public Escola consultarEscolaPorId(Long id) {
	    Escola escola = null;
	    try {
	      //Consulta uma elemento pelo seu ID.
	      escola = em.find(Escola.class, id);
	    } finally {
	      em.close();
	    }
	    return escola;
	  }
	  
	  public List<Escola> listarEscolas() {
			TypedQuery<Escola> query = em.createQuery("Select e from Escola e", Escola.class);
			return query.getResultList();
		}

	}
