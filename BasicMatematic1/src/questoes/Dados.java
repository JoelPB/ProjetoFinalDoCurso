/*
 * A Classe Dados é a classe responssável por fornecer os dados a serem utilizados para fornecer as questões ao usuário
 * (essa classe funciona como um banco de dados para as questões geradas e manipulações matemáticas, optou-se por usar uma classe e 
 * não um banco de dados pelo fatos dos dados serem apenas consultados, assim caso fosse utilizar um banco de dados com todas as 
 * funcionalidades estaríamos apenas aumentando o tempo de consulta a cada acesso ao banco, ao acessar uma classe do próprio programa o 
 * tempo de resposta é ínfimo se comparado).
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
			"Edite", "Fabiana", "Glória","Helena", "Ingrede", "Jade", "Kátia", "Laís", "Magda", "Nair",
			"Olívia", "Perla", "Raíssa", "Sandra", "Taís", "Vânia", "Yasmin", "Zoe");
	private List<String> nomeM = Arrays.asList("André", "Bruno", "Caio", "Daniel", "Edson", 
			"Fred", "Gabriel", "Heitor", "Ivo", "João", "Kevin", "Lucas", "Marcel", "Naruto", "Olavo", "Pedro",
			"Rui", "Salomão", "Tiago", "Valber", "Yago", "Zózimo");
		
	private List<String> enunciadoL = Arrays.asList("foi a feira", "foi a fazenda", "foi ao mercado", "foi ao WalMart", "foi a budega do Zé", 
			"foi a mercearia", "foi ao sacolão", "foi ao depósito", "foi a barraca preferida");
	
	private List<String> olhaA = Arrays.asList("obteve", "conseguiu", "adquiriu", "pegou", "guardou", "pediu", "ganhou", "recebeu");
	
	private List<Integer> numeroV = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 
			22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
	
	private List<String> fruta = Arrays.asList("abacate(s)", "abacaxi(s)", "azeitona(s)", "açaí(s)", "acerola(s)", "ameixa(s)", "amora(s)", "abóbora(s)",
			"bacuri(s)", "banana(s)", "cacau(s)", "cereja(s)", "cajá(s)", "cupuaçu(s)", "carambola(s)", "coco(s)", "caqui(s)", 
			"damasco(s)", "figo(s)", "goiaba(s)", "graviola(s)", "guaraná(s)", "jabuticaba(s)", "jaca(s)", "jambo(s)", "jamelão(ões)",
			"kiwi(s)", "laranja(s)", "limão(ões) ", "maçã(s)", "manga(s)", "mangaba(s)", "maracujá(s)", "mamão(ões)", "melancia(s)", 
			"melão(ões)", "morango(s)", "pêra(s)", "pêssego(s)", "pinha(s)", "pitanga(s)", "pitomba(s)", "romã(s)",
			"seriguela(s)", "tâmara(s)", "tamarindo(s)", "tangerina(s)", "tomate(s)", "umbu(s)", "uva(s)");	
		
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
