package br.alura.com.financas.teste;

import javax.persistence.EntityManager;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Cliente;
import br.alura.com.financas.modelo.Conta;

public class TesteContaCliente {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Joao Pedro");
		cliente1.setEndereco("Joao Wallig, 45");
		cliente1.setProfissao("Gamer");
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Pedro Henrique");
		cliente2.setEndereco("Joao Wallig, 4");
		cliente2.setProfissao("Youtuber");
		
		Conta conta = new Conta();
		conta.setId(1);
		
		cliente1.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(cliente1);
//		em.persist(cliente2);
		
		em.getTransaction().commit();
		
		em.close();
	}

}
