package br.alura.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;

public class TesteTodasMovimentacoes {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select c from Conta c join fetch c.movimentacoes";
		Query query = em.createQuery(jpql);
		
		List<Conta> tdsContas = query.getResultList();
		for (Conta conta : tdsContas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Movimentações: ");
			System.out.println(conta.getMovimentacoes());
		}
		
		
		em.getTransaction().commit();
		em.close();
	}
	
	
	
	

}
