package br.alura.com.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.alura.com.financas.Util.JPAUtil;
import br.alura.com.financas.modelo.Conta;
import br.alura.com.financas.modelo.Movimentacao;

public class TesteTesteLazyInserirMov {

	public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        Conta conta = em.find(Conta.class, 1);

        List<Movimentacao> movimentacoes = conta.getMovimentacoes();

       

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }
        
        em.close();

    }
}
