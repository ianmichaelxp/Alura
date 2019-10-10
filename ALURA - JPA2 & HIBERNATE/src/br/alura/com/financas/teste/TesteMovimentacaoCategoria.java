package br.alura.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Categoria;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;
import br.alura.com.financas.modelo.TipoMovimentacao;

public class TesteMovimentacaoCategoria {
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "select mov from Movimentacao mov join mov.categoria c where c = :pCategoria";
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		
		List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
				
		
		
		em.getTransaction().commit();
		
		em.close();
	}	
		
		
		
	

}
