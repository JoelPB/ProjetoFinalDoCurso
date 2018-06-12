/*
 * A Classe Operacao é a classe responsável por bolar a lógica de cada operação que a classe Escolha irá necessitar.
 * (essa classe selecionará a lógica matemática de acordo com a operação a ser utilizada pela classe Escolha para 
 * fornecer o raciocínio necessário a solicitação da classe GeraQuestão).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */

package selecao;

import java.util.Random;

import questoes.Dados;
import questoes.GeraQuestao;

public class Operacao {	
	
	static Random random = new Random();
	static Dados dado = new Dados();

	public static int soma(int nivelDificuldade, String nome, String olha) {

		int acumulador = nivelDificuldade, valor = 0, totalOperacao = 0;
		
		GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n";		
				
		while(acumulador >= 0) {
			
			if(acumulador == 10)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n";
			
			valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
			if(nivelDificuldade < 4 && valor > 10)
				valor = valor % (int)(Math.pow(10, nivelDificuldade)) + 1;
			
			if(totalOperacao > 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " +";
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " [" + valor +"]" + dado.getFruta().get(random.nextInt(dado.getFruta().size())); //Adiciona as frustas a questão
			
			totalOperacao += valor;
			acumulador--;

		}		
		
		return totalOperacao;
		
	}

	public static int subtracao(int nivelDificuldade, String nome, String olha) {

		int acumulador = nivelDificuldade - 1, valor = 0, totalOperacao = 0;
		
		while(acumulador >= 0) {
			
			if(acumulador == 10)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n";
			
			valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
			if(nivelDificuldade < 4 && valor > 10)
				valor = valor % (int)(Math.pow(10, nivelDificuldade)) + 1;
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " -";
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " [" + valor +"] " + dado.getFruta().get(random.nextInt(dado.getFruta().size()));
			
			totalOperacao -= valor;
			acumulador--;
			
		}

		return totalOperacao;
	}

	public static int multiplicacao(int nivelDificuldade, String nome, String olha) {
		
		int acumulador = nivelDificuldade, valor = 0, totalOperacao = 0;

		while(acumulador > 0) {
			valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista

			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " [" + valor +"] " + dado.getFruta().get(random.nextInt(dado.getFruta().size()));
			
			totalOperacao += valor;

			acumulador--;
		}

		return totalOperacao;

	}

	public static int divisao(int nivelDificuldade, String nome, String olha) {
		
		int totalOperacao = 0;

		GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "{";
		totalOperacao = multiplicacao(nivelDificuldade, nome, olha);
		GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "}.";

		return totalOperacao;

	}

}
