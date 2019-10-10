package br.alura.com.financas.teste;

import javax.persistence.EntityManager;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;

public class TesteMovimentacaoConta {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Movimentacao movimentacao = em.find(Movimentacao.class, 13);
		Conta conta = movimentacao.getConta();
		System.out.println(conta.getTitular());
		System.out.println(conta.getMovimentacoes().size());
		
		em.getTransaction().commit();
		em.close();
	}
	
}
