/*
 * A Classe Escolha � a classe onde as quest�es realmente s�o geradas com uma l�gica diferente para cada opera��o e n�vel de dificuldade
 * (essa classe escolhe a linha de racioc�nio da quest�o de acordo com o n�vel de dificuldade e a opera��o, 
 * tal escolha ser� utilizada pela classe GeraQuestao para desenvolver a quest�o de forma adequada).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package selecao;

import java.util.Random;
//import java.util.Scanner;

//import aplicativo.BasicMatematic;
import questoes.Dados;
import questoes.GeraQuestao;

public class Escolha {
	
	private static boolean[] operacao = {false, false, false, false}; //armazena as quatro posibilidades de opera��es
	private static int nivelDificuldade; //armazena o n�vel de dificuldade	
	private Dados dado;
	private Random random;
	
	public Escolha() {
		
		dado = new Dados(); //instancia uma vari�vel do tipo Dados
		random = new Random(); //instancia uma vari�vel do tipo Random
		
	}
	
	public static boolean[] getOperacao() {
		return operacao;
	}

	public static void setOperacao(boolean[] operacao) {
		Escolha.operacao = operacao;
	}
	
	public static int getNivelDificuldade() {
		return nivelDificuldade;
	}

	public static void setNivelDificuldade(int nivelDificuldade) {
		Escolha.nivelDificuldade = nivelDificuldade;
	}
	
	public String nome(int numero) { //Gera nomes de pessoas para as quest�es

		String nome = null;

		if(numero % 2 == 0) {
			nome = dado.getNomeF().get(random.nextInt(dado.getNomeF().size())); //Gera um nome feminino
		}else {
			nome = dado.getNomeM().get(random.nextInt(dado.getNomeM().size())); //Gera um nome masculino
		}
		return nome;
	}

	public String enunciado(String nome) { //gera o enunciado da quest�o

		String olha = dado.getOlhaA().get(random.nextInt(dado.getOlhaA().size()));
		
		if((GeraQuestao.getContador() == 0) && getOperacao()[GeraQuestao.getContador()]) {
			if(GeraQuestao.getControlePessoa() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSoma: dever� utilizar a l�gica das rela��es de SOMA para responder.";
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\n" + nome + " " + dado.getEnunciadoL().get(random.nextInt(dado.getEnunciadoL().size())) + " e " + olha + ":";
					
		}else if((GeraQuestao.getContador() == 1) && getOperacao()[GeraQuestao.getContador()]) { 
			if(GeraQuestao.getControlePessoa() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSubtra��o: dever� utilizar a l�gica das rela��es de SUBTRA��O para responder.";			
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\n" + nome + " " + dado.getEnunciadoL().get(random.nextInt(dado.getEnunciadoL().size())) + " e " + olha + ":";
			
		}else if((GeraQuestao.getContador() == 2) && getOperacao()[GeraQuestao.getContador()]) {
			
			if(GeraQuestao.getControlePessoa() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nMultiplica��o: dever� utilizar a l�gica das rela��es de MULTIPLICA��O para responder.";			
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\n" + nome + " " + dado.getEnunciadoL().get(random.nextInt(dado.getEnunciadoL().size())) + " e " + olha + ":\n";
						
		}else if((GeraQuestao.getContador() == 3) && getOperacao()[GeraQuestao.getContador()]) { 
				
			if(GeraQuestao.getControlePessoa() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nDivis�o: dever� utilizar a l�gica das rela��es de DIVIS�O para responder.";			
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\n" + nome + " " 	+ dado.getEnunciadoL().get(random.nextInt(dado.getEnunciadoL().size())) + " e " + olha + ":\n";
								
		}			

		return olha;
	}

	public int itensVistos(String nome, String olha) { //Mostra os itens que foram visualizados

		int acumulador, valor; 
				
		acumulador = getNivelDificuldade(); 

		if((GeraQuestao.getContador() == 0) && getOperacao()[GeraQuestao.getContador()]) {//Gera os itens e armazena o total dos itens da soma		

			GeraQuestao.getRespostas()[GeraQuestao.getContador()] = Operacao.soma(getNivelDificuldade(), nome, olha);	//Come�a a armazenar uma poss�vel resposta
			
			if((getNivelDificuldade() >= 6 && !(GeraQuestao.getControlePessoa() == 0)) && (getNivelDificuldade() % 2) == 0) {
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLembrando que " + nome + "  ir� ganhar [" + valor +"] fruta(s) do seu av� para o lanche da escola.";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
			}
			
			if((getNivelDificuldade() > 6) && (getNivelDificuldade() < 9)) {

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que " + nome + " havia ganho [" + valor + "] fruta(s).";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				
				if (!(getNivelDificuldade() == 8)) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nHoje " + nome + " colheu no seu quintal [" + valor + "] fruta(s)";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;	
					
				}else {
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nHoje " + nome + " colheu no seu quintal:";	
					valor = Operacao.soma(getNivelDificuldade()*2, nome, olha);					
												
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;	
					
				}
								
				if((getNivelDificuldade() >= 6 && !(GeraQuestao.getControlePessoa() == 0)) && (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % 2) == 0) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " ganhou de seu primo [" + valor + "] fruta(s) e ";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "[" + valor + "] fruta(s) de seu melhor amigo.";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
				}else {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " ganhou de seu tio [" + valor + "] fruta(s) e ";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "[" + valor + "] fruta(s) de sua melhor amiga.";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
				}

			}else if(getNivelDificuldade() > 8) {
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%2 == 0) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));				
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que " + nome + " havia ganho [" + valor + "] fruta(s).\n";								
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
				}
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "Os amigos de " + nome + " resolveram lhe presentear com:\n";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += Operacao.soma(getNivelDificuldade()/2, nome, olha);
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%3 == 0) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));								
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + " colheu no seu quintal [" + valor + "] fruta(s).";				
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
					
				}

			}			
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n";
			
			return GeraQuestao.getRespostas()[GeraQuestao.getContador()];
			
		}else if((GeraQuestao.getContador() == 1) && getOperacao()[GeraQuestao.getContador()]) {//Gera os itens e armazena o total dos itens da subtra��o		
			
			if(getNivelDificuldade() <= 4)
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())) * acumulador* acumulador; //retorna um valor de uma lista
			else 
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())) * acumulador;

			if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] < 50)
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] =  GeraQuestao.getRespostas()[GeraQuestao.getContador()] + 50;
			
			GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] frutas, resolveu d� a seus amigos as frutas: \n";			
			GeraQuestao.getRespostas()[GeraQuestao.getContador()] += Operacao.subtracao(getNivelDificuldade(), nome, olha);
			
			if((getNivelDificuldade() >= 6 && !(GeraQuestao.getControlePessoa() == 0)) && (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % 2) == 0) {
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + "  tem que d� [" + valor +"] fruta(s) para o lanche de seu irm�o.";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor;
				
			}		
			
			if((getNivelDificuldade() > 6) && (getNivelDificuldade() < 9)) {

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
								
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " havia doado [" + valor + "] fruta(s).\n";			
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor;
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "Levando em conta que " + nome + " deixou [" + valor + "] apodrecer";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor;
				
				if(getNivelDificuldade() == 8) {
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nCom a informa��o que " + nome + "  para uma institui��o de caridade as fruta(s):\n";
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += Operacao.subtracao(getNivelDificuldade()/2, nome, olha);
				}
				
			}else if(getNivelDificuldade() > 8) {
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] - valor >= 20) {
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que " + nome + " havia doado [" + valor + "] fruta(s).";		
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor;
					
				}
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%2 == 0)
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nOs amigos de " + nome + " lhe pediram:";
				else
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome +" dou ao asilo municipal:";
				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += Operacao.subtracao(getNivelDificuldade()/2, nome, olha);
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));

				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] - valor >= 30) {
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + " deixou [" + valor + "] apodrecer";					
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor;
					
				}				
			}
		}else if((GeraQuestao.getContador() == 2) && getOperacao()[GeraQuestao.getContador()]) {//Gera os itens e armazena o total dos itens da multiplica��o	

			int multiplica = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
			
			if(multiplica>10 && getNivelDificuldade()<4)
				multiplica = multiplica / 10;
			
			if(getNivelDificuldade() <= 4)
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = (dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()))) % 10 + 1; //retorna um valor de uma lista
			else
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = (dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()))); //retorna um valor de uma lista
			
			if (getNivelDificuldade() == 1) {
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] caixas de fruta(s).\nSabendo que cada caixa tem [" + multiplica +"] " + "fruta(s).\n";
			
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()] * multiplica; //realiza a primeira opera��o
			
			}else if((getNivelDificuldade() > 1) && (getNivelDificuldade() < 5)) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] caixa(s) de fruta(s).\nSabendo que cada caixa tem as seguintes fruta(s):\n";
				multiplica = Operacao.multiplicacao(getNivelDificuldade(), nome, olha);
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()] * multiplica;
				
			}else if((getNivelDificuldade() > 4) && (getNivelDificuldade() < 7)) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] caixa(s) de fruta(s).\nSabendo que cada caixa tem as seguintes fruta(s):\n";
				multiplica = Operacao.multiplicacao(getNivelDificuldade()/2, nome, olha);
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()] * multiplica;
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				if(valor > 30)
					valor = valor / 30 + 1;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " j� tinha em sua casa [" + valor + "] caixa(s) de fruta(s)";
				
				if((GeraQuestao.getControlePessoa()== 0)) {
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += ", cada caixa com [" + multiplica + "] fruta(s).";
					
				}else {
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += ". Como cada caixa possui [" + multiplica + "] fruta(s).\n";
					
				}

				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * multiplica;

			}else if((getNivelDificuldade() > 6) && (getNivelDificuldade() < 9)) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] caixa(s) de fruta(s).\nSabendo que cada caixa tem a(as) seguinte(s) fruta(s):\n";
				multiplica = Operacao.multiplicacao(getNivelDificuldade()/2, nome, olha);
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()] * multiplica;

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 50)
					valor = valor / 50 + 1;
				multiplica = valor + (valor % 9);
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " havia colhido em seu quintal [" + valor + "] caixa(s) de fruta(s), " + "com [" + multiplica + "] fruta(s) em cada caixa.";
				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * multiplica;

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 50)
					valor = valor / 50 + 1;
				multiplica = valor + (valor % 9);
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + " havia armazenado em seu galp�o [" + valor + "] caixa(s), com [" + multiplica + "] fruta(s) em cada caixa";
				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * multiplica;
				
				if(getNivelDificuldade() == 8) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nCom a informa��o que " + nome + " ir� pegar [" + valor+ "] caixa(s) no frigor�fico de sua cidade, cada caixa com a(as) fruta(s):\n";
					multiplica = Operacao.multiplicacao(getNivelDificuldade()/2, nome, olha);
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * multiplica;
					
				}

			}else if(getNivelDificuldade() > 8) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] caixa(s) de fruta(s).\nSabendo que cada caixa tem a(as) seguinte(s) fruta(s):\n";
				multiplica = Operacao.multiplicacao(getNivelDificuldade()/2, nome, olha);
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()] * multiplica;
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%2 == 0) {
					
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					if(valor > 10)
						valor = valor / 10;
					multiplica = valor + (valor % 9);
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que " + nome + " guanhou [" + valor + "] caixa(s), com [" + multiplica + "] fruta(s) em cada caixa.\n";				
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * multiplica;
					
				}
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				
				if(valor > 30)
					valor = valor / 30;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "Os amigos de " + nome + " lhe deram [" + valor + "] caixa(s) de fruta(s), cada caixa com:\n";
				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * Operacao.multiplicacao(getNivelDificuldade()/2, nome, olha);

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 30)
					valor = valor / 30;
				multiplica = valor + (valor % 5);

				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + " deu ao seu vizino [" + valor + "] sacola(s) de fruta(s), com [" + multiplica + "] fruta(s) em cada sacola\n";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] -= valor * multiplica;

			}
			
		}else if((GeraQuestao.getContador() == 3) && getOperacao()[GeraQuestao.getContador()]) {//Gera os itens e armazena o total dos itens da divis�o	

			int divide = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())) % 20 + 1; //retorna um valor de uma lista
			GeraQuestao.getRespostas()[GeraQuestao.getContador()] = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
			
			if(getNivelDificuldade() <= 1 && GeraQuestao.getRespostas()[GeraQuestao.getContador()] > 40)
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = GeraQuestao.getRespostas()[GeraQuestao.getContador()]/getNivelDificuldade() + 1;
			
			if (getNivelDificuldade() == 1 && divide > 10 )
				divide = divide%10 + 1;
						
			if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide > 0 && getNivelDificuldade() == 1) { //Deixa a divis�o exata
				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += divide - (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide);
			}
			if (getNivelDificuldade() == 1) {

				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " [" + GeraQuestao.getRespostas()[GeraQuestao.getContador()] +"] fruta(s).\nSabendo que cada caixa de fruta que " + nome + " possui cabe [" + divide +"] " + "fruta(s).\n";
			
			}else if(getNivelDificuldade()>1 && getNivelDificuldade() <= 4) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " a(s) seguinte(s) fruta(s):\n";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = Operacao.divisao(getNivelDificuldade(), nome, olha);
				
				if(divide > 20)
					divide = divide / (getNivelDificuldade()) + 1;
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide > 0) { //Deixa a divis�o exata				
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " mantinha guardado em sua casa [" + (divide - (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide)) +"] fruta(s).\n";
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += divide - (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide);
				}
								
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que cada caixa cabe [" + divide +"] fruta(s).";
				
			}else if((getNivelDificuldade() > 4) && (getNivelDificuldade() < 7)) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " a(s) seguinte(s) fruta(s):\n";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = Operacao.divisao(getNivelDificuldade()/2, nome, olha);

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				if(valor > 30)
					valor = valor / 30 + 1;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " j� tinha em sua fruteira [" + valor + "] fruta(s)";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				
				if((GeraQuestao.getControlePessoa()== 0)) {
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += " e ainda colheu no seu quintal [" + valor + "] fruta(s).\n";
					
				}else {
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += ". Sabendo que seu entregador ainda trar� [" + valor + "] fruta(s).\n";
					
				}

				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				
				divide = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				if(divide > 30)
					divide = divide / 30 + 1;
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "Levendo em conta que suas caixas cabem [" + divide + "] fruta(s).\n";

			}else if((getNivelDificuldade() > 6) && (getNivelDificuldade() < 9)) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " a(s) seguinte(s) fruta(s):\n";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = Operacao.divisao(getNivelDificuldade()/2, nome, olha);
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 50)
					valor = valor / 40;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n" + nome + " havia colhido em seu quintal [" + valor + "] fruta(s). ";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;

				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 50)
					valor = valor / 30;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que " + nome + " havia armazenado em seu galp�o [" + valor + "] fruta(s)";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				
				if(getNivelDificuldade() == 8) {
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nCom a informa��o que " + nome + "  para o Zool�gico a(s) fruta(s):\n";
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += Operacao.subtracao(getNivelDificuldade()/2, nome, olha);
				}
				
				divide = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				if(divide > 30)
					divide = divide / 30 + 1;
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevendo em conta que suas caixas cabem [" + divide + "] fruta(s).\n";
				

			}else if(getNivelDificuldade() > 8) {
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += olha + " a(s) seguinte(s) fruta(s):\n";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] = Operacao.divisao(getNivelDificuldade()/2, nome, olha);
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%2 == 0) {
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					if(valor > 50)
						valor = valor / 20;				
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nSabendo que " + nome + " guanhou [" + valor + "] fruta(s).\n";				
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				}
				
				if(GeraQuestao.getRespostas()[GeraQuestao.getContador()]%5 == 0) {
					valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
					if(valor > 80)
						valor = valor / 10;
					
					GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nOs amigos de " + nome + " lhe deram [" + valor + "] caixa(s), com a(s) seguinte(s) fruta(s) em cada caixa:\n";				
					GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor * Operacao.divisao(getNivelDificuldade()/2, nome, olha);
				}
				
				valor = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size()));
				if(valor > 100)
					valor = valor / 15;
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nLevando em conta que o vizinho de " + nome + " lhe deu [" + valor + "] fruta(s)";
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += valor;
				
				divide = dado.getNumeroV().get(random.nextInt(dado.getNumeroV().size())); //retorna um valor de uma lista
				if(divide > 50)
					divide = divide / 40;
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nComo cada uma de suas caixas cabe [" + divide + "] fruta(s).\n";
				
			}			
			
			if(GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide > 0) { //Deixa a divis�o exata
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nN�o esque�a que " + nome + " recebeu [" + (divide - (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide)) + "] fruta(s) do seu av�.\n";				
				GeraQuestao.getRespostas()[GeraQuestao.getContador()] += divide - (GeraQuestao.getRespostas()[GeraQuestao.getContador()] % divide);
			}
			
			GeraQuestao.getRespostas()[GeraQuestao.getContador()] /= divide;
			
		}

		return GeraQuestao.getRespostas()[GeraQuestao.getContador()];
				
	}


}
