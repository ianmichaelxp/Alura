package br.alura.com.financas.teste;

import javax.persistence.EntityManager;
import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;

public class TesteConta {

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("3331");
		conta.setBanco("bb");
		conta.setTitular("Ian Michael");
		conta.setNumero("0");

		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();;
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
	}

}
