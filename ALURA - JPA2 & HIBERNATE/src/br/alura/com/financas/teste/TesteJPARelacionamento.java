package br.alura.com.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;
import br.alura.com.financas.modelo.TipoMovimentacao;

public class TesteJPARelacionamento {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("3331");
		conta.setBanco("BB");
		conta.setNumero("85294");
		conta.setTitular("Ian Michael");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Pizzaria");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("25.00"));
		
		movimentacao.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(conta);
		em.persist(movimentacao);
		
		
		em.getTransaction().commit();
		em.close();

	}

}
