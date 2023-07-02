package jUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;

/**
 * Classe de testes unitarios
 * @author Joao Artur e Weverton Rodrigues
 * @since 2023
 * @version 1.0
 */

class Teste {
	ControleEmpresa controle = new ControleEmpresa();
	ControleFiliais controleFiliais = new ControleFiliais(controle.getDados());

	/**
	 * Verifica se a filial esta sendo cadastrada/editada
	 * corretamente na posicao do ArrayList indicada 
	 * @return void
	 */
	
	@Test
	void testeCadastroFilial() {
		String[] dadosFilial = new String[5];
		int posicao = 1;
		
		dadosFilial[0] = "Teste";
		dadosFilial[1] = "1234567890";
		dadosFilial[2] = "teste@email.com";
		dadosFilial[3] = "33213030";
		dadosFilial[4] = "UnB";
		
		assertTrue(controle.cadastrarEditarFilial(dadosFilial, posicao));	
	}
	
	/**
	 * Verifica se o patrimonio esta sendo cadastrado/editado
	 * na filial e posicao indicada do ArrayList
	 * @return void
	 */
	
	@Test
	void testeCadastrarPatrimonio() {
		String[] dadosPatrimonio = new String[5];
		int posicaoFilial = 3;
		int posicaoPatrimonio = 2;
		int op = 1;
		
		dadosPatrimonio[0] = "Apartamento 508";
		dadosPatrimonio[2] = "Apartamento";
		dadosPatrimonio[3] = "132";
		dadosPatrimonio[1] = "800555";
		dadosPatrimonio[4] = "Asa Norte";

		assertTrue(controleFiliais.cadastroPatrimonio(dadosPatrimonio, posicaoFilial, posicaoPatrimonio, op));
	}
	
	/**
	 * Verifica se o metodo 'procurarPatrimonio' retorna as posicoes corretas
	 * para o patrimonio passado como parametros
	 * @return void
	 */
	
	@Test
	void testeEncontraFilial() {
		int[] posicoes = {0,0,1};
		assertArrayEquals(posicoes, controle.procurarPatrimonio("Item0"));
	}	
}
