package br.alura.com.financas.teste;

import javax.persistence.EntityManager;
import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;

public class TesteBuscaConta {

	public static void main(String[] args) {
		//Gerenciador
		EntityManager em = new JPAUtil().getEntityManager();
		//Abre uma transação
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		conta.setTitular("Ian Michael G Silva");
		conta.setBanco("001 - BANCO DO BRASIL");
		conta.setNumero("85294-5");
		System.out.println(conta.getTitular());
		em.getTransaction().commit();
		em.close();
		
/************************************************************************/
		
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();
		conta.setTitular("Joao");
		
		//Estado detached
		em2.merge(conta);
		em2.getTransaction().commit();
		em2.close();
/************************************************************************/
		EntityManager em3 = new JPAUtil().getEntityManager();
		em3.getTransaction().begin();
		
		conta = em3.find(Conta.class, 2);
		em3.remove(conta);
		
		em3.getTransaction().commit();
		em3.close();
		

	}

}
