package br.alura.com.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Categoria;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;
import br.alura.com.financas.modelo.TipoMovimentacao;

public class TesteMovimentacaoComCategoria {

	public static void main(String[] args) {
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Almoco");
		
		Conta conta = new Conta();
		conta.setId(1);
		
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem a JP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("300.00"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);

		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem a RE");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("450.00"));
		movimentacao2.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao2.setConta(conta);
		
		
		EntityManager em = new JPAUtil().getEntityManager();
				
		em.getTransaction().begin();
//		em.persist(categoria1);
//		em.persist(categoria2);
//		
//		em.persist(movimentacao1);
//		em.persist(movimentacao2);
		Movimentacao movimentacao = em.find(Movimentacao.class, 5);
		movimentacao.setDescricao("Viagem a PE");

		em.getTransaction().commit();
		em.close();
	}

}
