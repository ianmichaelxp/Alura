package br.alura.com.financas.teste;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;
import br.alura.com.financas.modelo.TipoMovimentacao;

public class TesteJPQL {

	public static void main(String[] args) {
		
EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		String jpql = "select mov from Movimentacao mov where mov.conta = :pConta" + 
		" and mov.tipo = :pTipo" +
		" order by mov.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		List<Movimentacao> resultados = query.getResultList();
		for (Movimentacao movimentacao : resultados) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Conta.id: " + movimentacao.getConta().getId());
		}
		
				
		
		
		em.getTransaction().commit();
		
		em.close();
	}

}
