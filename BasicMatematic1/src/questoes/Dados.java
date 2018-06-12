/*
 * A Classe Dados � a classe responss�vel por fornecer os dados a serem utilizados para fornecer as quest�es ao usu�rio
 * (essa classe funciona como um banco de dados para as quest�es geradas e manipula��es matem�ticas, optou-se por usar uma classe e 
 * n�o um banco de dados pelo fatos dos dados serem apenas consultados, assim caso fosse utilizar um banco de dados com todas as 
 * funcionalidades estar�amos apenas aumentando o tempo de consulta a cada acesso ao banco, ao acessar uma classe do pr�prio programa o 
 * tempo de resposta � �nfimo se comparado).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package questoes;

import java.util.Arrays;
import java.util.List;

public class Dados {
	
	private List<String> nomeF = Arrays.asList("Ana", "Bia", "Carmen", "Diana", 
			"Edite", "Fabiana", "Gl�ria","Helena", "Ingrede", "Jade", "K�tia", "La�s", "Magda", "Nair",
			"Ol�via", "Perla", "Ra�ssa", "Sandra", "Ta�s", "V�nia", "Yasmin", "Zoe");
	private List<String> nomeM = Arrays.asList("Andr�", "Bruno", "Caio", "Daniel", "Edson", 
			"Fred", "Gabriel", "Heitor", "Ivo", "Jo�o", "Kevin", "Lucas", "Marcel", "Naruto", "Olavo", "Pedro",
			"Rui", "Salom�o", "Tiago", "Valber", "Yago", "Z�zimo");
		
	private List<String> enunciadoL = Arrays.asList("foi a feira", "foi a fazenda", "foi ao mercado", "foi ao WalMart", "foi a budega do Z�", 
			"foi a mercearia", "foi ao sacol�o", "foi ao dep�sito", "foi a barraca preferida");
	
	private List<String> olhaA = Arrays.asList("obteve", "conseguiu", "adquiriu", "pegou", "guardou", "pediu", "ganhou", "recebeu");
	
	private List<Integer> numeroV = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 
			22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
	
	private List<String> fruta = Arrays.asList("abacate(s)", "abacaxi(s)", "azeitona(s)", "a�a�(s)", "acerola(s)", "ameixa(s)", "amora(s)", "ab�bora(s)",
			"bacuri(s)", "banana(s)", "cacau(s)", "cereja(s)", "caj�(s)", "cupua�u(s)", "carambola(s)", "coco(s)", "caqui(s)", 
			"damasco(s)", "figo(s)", "goiaba(s)", "graviola(s)", "guaran�(s)", "jabuticaba(s)", "jaca(s)", "jambo(s)", "jamel�o(�es)",
			"kiwi(s)", "laranja(s)", "lim�o(�es) ", "ma��(s)", "manga(s)", "mangaba(s)", "maracuj�(s)", "mam�o(�es)", "melancia(s)", 
			"mel�o(�es)", "morango(s)", "p�ra(s)", "p�ssego(s)", "pinha(s)", "pitanga(s)", "pitomba(s)", "rom�(s)",
			"seriguela(s)", "t�mara(s)", "tamarindo(s)", "tangerina(s)", "tomate(s)", "umbu(s)", "uva(s)");	
		
	public List<String> getNomeF() {
		return nomeF;
	}
	public List<String> getNomeM() {
		return nomeM;
	}	
	public List<String> getEnunciadoL() {
		return enunciadoL;
	}
	public List<String> getOlhaA() {
		return olhaA;
	}
	public List<Integer> getNumeroV() {
		return numeroV;
	}
	public List<String> getFruta() {
		return fruta;
	}
	
	@Override
		public String toString() {			
			return super.toString();
		}	
}
