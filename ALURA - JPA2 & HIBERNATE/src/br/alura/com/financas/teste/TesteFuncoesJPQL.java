package br.alura.com.financas.teste;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;
import br.alura.com.financas.modelo.TipoMovimentacao;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		//para média: sum(mov.valor)
		//Double media = (Double) query.getSingleResult();
		
//		String jpql = "select sum(mov.valor) from Movimentacao mov where mov.conta = :pConta" + 
//		" and mov.tipo = :pTipo" +
//		" order by mov.valor desc";
//		Query query = em.createQuery(jpql);
//		query.setParameter("pConta", conta);
//		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		String jpql = "select max(mov.valor) from Movimentacao mov where mov.conta = :pConta" + 
		" and mov.tipo = :pTipo" +
		" order by mov.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		BigDecimal max = (BigDecimal) query.getSingleResult();
		
		System.out.println("max: "+max);
		
		
		em.getTransaction().commit();
		
		em.close();
	}

}
