/*
 * A Classe Bonus � a respons�vel pelo dados de bonifica��o e das mensagens utilizados pela Popup, nela est� contido todos os dados das quest�es bonus.
 * (� a classe respons�vel pelas quest�es de bonifica��o e pelas mensagens de parabeniza��o e de motiva��o, � a classe m�e de GeraQuestao e ser� respons�vel diretamente pelas quest�es e mensagens extras).
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

public class Bonus {
		
	private static int questaoBonus; //para armazenas a posi��o da respsota da quest�o de bonus
			
	private List<String> motivacional = Arrays.asList("Mesmo quando erramos aprendemos.", "Continue tentado, o  maior erro que um homem pode cometer � ter medo de errar.",
			"Continue tentado, o �nico homem que nunca comete erros � aquele que nunca faz coisa alguma.", "Continue tentado, pois um homem nunca deve envergonhar-se por reconhecer que se enganou, \npois isso equivale a dizer que hoje � mais s�bio do que era ontem.",
			"Errar � t�o importante quanto acertar, pois um � conseq��ncia do outro.", "Infelizmente n�o foi dessa vez, continue tentando, \nmesmo os pequenos erros edificam o seu aprendizado.",
			"Ter sucesso � falhar repetidamente, mas sem perder o entusiasmo.");
	
	private List<String> bonificacao = Arrays.asList("Parab�ns, seu esfor�o tem dado resultado.", "Que bom que o seu conhecimento tem aumentado, parab�ns.",
			"�timo, de passo em passo voc� tem seguido no infinito caminho do conhecimento.", "Excelente, quanto mais se pratica mais f�cil fica.",
			"Que maravilha, estou orgulhoso de voc�.", "Estou feliz pelo que voc� fez!", "Parab�ns, n�o esperava menos de voc�.", "Voc� pode chegar onde quiser.");
	
	private List<String> bonusSoma = Arrays.asList("Quando se escreve a sucess�o dos n�meros naturais, de 1 a 1000, \nquantas vezes aparece o algarismo 2 como algarismos das unidades? ", 
			"O professor Aloprado, no primeiro dia de aula, apostou que, entre os alunos daquela classe, \npelo menos dois fariam anivers�rio no mesmo dia do m�s. \nO professor tinha certeza de que ganharia a aposta, pois naquela classe \no n�mero de alunos era maior ou igual a?", 
			"Um livro tem 500 p�ginas. Quantas vezes o algarismo 1 aparece na numera��o das mesmas? ",
			"Alguns meses tem 31 dias, outros apenas 30 dias. Quantos meses tem 28 dias?");
	
	private List<Integer> respostaSoma = Arrays.asList(100, 32, 200, 12);
	
	private List<String> bonusSub = Arrays.asList("Dois pais e dois filhos foram pescar. \nTodos pescaram um peixe e pescaram ao todo 3 peixes. \nComo pode? Quantas pessoas havia?", 
			"Uma revista � composta por folhas duplas, impressas na frente e no verso, \nresultando cada folha em 4 p�ginas que s�o grampeadas umas sobre as outras. \nAs p�ginas impressas em cada folha dupla n�o podem ser consecutivas, exceto as que ficam na folha central. \nNum certo exemplar uma das folhas duplas corresponde �s p�ginas 31, 32, 85 e 86. \nQuantas p�ginas ao todo tem este exemplar? ",
			"Seis homens levam seis dias para cavar seis buracos. \nQuanto tempo levar�o 12 homens para cavarem 12 buracos? ");
	private List<Integer> respostaSub = Arrays.asList(3, 116, 6);
	
	private List<String> bonusMult = Arrays.asList("Em uma urna h� 28 bolas azuis, 20 bolas verdes, 12 bolas amarelas, 10 bolas pretas e 8 bolas brancas. \nQual � o n�mero m�nimo de bolas que devemos sacar dessa urna para termos certeza de que sacaremos pelo menos 15 bolas da mesma cor? ",
			"Um tijolo pesa 1 kg mais meio tijolo. Quanto pesa um tijolo? ",
			"Um gato persegue um rato. Enquanto o gato d� 2 pulos o rato d� 3, mas cada pulo do gato vale 2 pulos do rato. Se a dist�ncia entre eles inicialmente � de 30 pulos de gato. \nQuantos pulos o gato ter� dado at� alcan�ar o rato? ",
			"Um torneio de jud� � disputado por 10 atletas e deve ter apenas um campe�o. \nEm cada luta n�o pode haver empate e aquele que perder tr�s vezes deve ser eliminado da competi��o. \nQual o n�mero m�ximo de lutas necess�rio para se conhecer o campe�o?");
	private List<Integer> respostaMult = Arrays.asList(59, 2, 120, 29);
	
	private List<String> bonusDiv = Arrays.asList("Num conjunto de 30 pessoas, 5 s�o altas e gordas, 11 s�o baixas e 13 s�o gordas. \nQuantas s�o as altas e magras?",
			"Num conjunto de 30 pessoas, 5 s�o altas e gordas, 11 s�o baixas e 13 s�o gordas. \nQuantas s�o as baixas e magras?",
			"Uma caixa cont�m 900 cart�es, numerados de 100 a 999. \nRetiramos ao acaso (sem reposi��o) cart�es da caixa e anotamos a soma dos seus algarismos. \nQual a menor quantidade de cart�es que devem ser retirados da caixa para garantirmos que pelo menos 3 destas somas sejam iguais?",
			"Tr�s gatos comem tr�s ratos em tr�s minutos, ent�o 100 gatos comer�o 100 ratos em quantos minutos?");
	private List<Integer> respostaDiv = Arrays.asList(14, 3,  53, 3);
	
	private static String[] titulo = {"Erro!", "Parab�ns voc� ACERTOU!", "Infelizmente voc� ERROU!", "Inv�lido!", "Mudan�a de N�vel de Dificuldade!"};
	private static int seletorTitulo = 0;
	
	public static int getSeletorTitulo() {
		return seletorTitulo;
	}
	public static void setSeletorTitulo(int seletorTitulo) {
		Bonus.seletorTitulo = seletorTitulo;
	}
	public static String[] getTitulo() {
		return titulo;
	}
	public static int getQuestaoBonus() {
		return questaoBonus;
	}
	public static void setQuestaoBonus(int questaoBonus) {
		Bonus.questaoBonus = questaoBonus;
	}
	public List<String> getMotivacional() {
		return motivacional;
	}
	public List<String> getBonificacao() {
		return bonificacao;
	}
	public List<String> getBonusSoma() {
		return bonusSoma;
	}
	public List<Integer> getRespostaSoma() {
		return respostaSoma;
	}
	public List<String> getBonusSub() {
		return bonusSub;
	}
	public List<Integer> getRespostaSub() {
		return respostaSub;
	}
	public List<String> getBonusMult() {
		return bonusMult;
	}
	public List<Integer> getRespostaMult() {
		return respostaMult;
	}
	public List<String> getBonusDiv() {
		return bonusDiv;
	}
	public List<Integer> getRespostaDiv() {
		return respostaDiv;
	}
		
}
