/*
 * A Classe Bonus é a responsável pelo dados de bonificação e das mensagens utilizados pela Popup, nela está contido todos os dados das questões bonus.
 * (é a classe responsável pelas questões de bonificação e pelas mensagens de parabenização e de motivação, é a classe mãe de GeraQuestao e será responsável diretamente pelas questões e mensagens extras).
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
		
	private static int questaoBonus; //para armazenas a posição da respsota da questão de bonus
			
	private List<String> motivacional = Arrays.asList("Mesmo quando erramos aprendemos.", "Continue tentado, o  maior erro que um homem pode cometer é ter medo de errar.",
			"Continue tentado, o único homem que nunca comete erros é aquele que nunca faz coisa alguma.", "Continue tentado, pois um homem nunca deve envergonhar-se por reconhecer que se enganou, \npois isso equivale a dizer que hoje é mais sábio do que era ontem.",
			"Errar é tão importante quanto acertar, pois um é conseqüência do outro.", "Infelizmente não foi dessa vez, continue tentando, \nmesmo os pequenos erros edificam o seu aprendizado.",
			"Ter sucesso é falhar repetidamente, mas sem perder o entusiasmo.");
	
	private List<String> bonificacao = Arrays.asList("Parabéns, seu esforço tem dado resultado.", "Que bom que o seu conhecimento tem aumentado, parabéns.",
			"Ótimo, de passo em passo você tem seguido no infinito caminho do conhecimento.", "Excelente, quanto mais se pratica mais fácil fica.",
			"Que maravilha, estou orgulhoso de você.", "Estou feliz pelo que você fez!", "Parabéns, não esperava menos de você.", "Você pode chegar onde quiser.");
	
	private List<String> bonusSoma = Arrays.asList("Quando se escreve a sucessão dos números naturais, de 1 a 1000, \nquantas vezes aparece o algarismo 2 como algarismos das unidades? ", 
			"O professor Aloprado, no primeiro dia de aula, apostou que, entre os alunos daquela classe, \npelo menos dois fariam aniversário no mesmo dia do mês. \nO professor tinha certeza de que ganharia a aposta, pois naquela classe \no número de alunos era maior ou igual a?", 
			"Um livro tem 500 páginas. Quantas vezes o algarismo 1 aparece na numeração das mesmas? ",
			"Alguns meses tem 31 dias, outros apenas 30 dias. Quantos meses tem 28 dias?");
	
	private List<Integer> respostaSoma = Arrays.asList(100, 32, 200, 12);
	
	private List<String> bonusSub = Arrays.asList("Dois pais e dois filhos foram pescar. \nTodos pescaram um peixe e pescaram ao todo 3 peixes. \nComo pode? Quantas pessoas havia?", 
			"Uma revista é composta por folhas duplas, impressas na frente e no verso, \nresultando cada folha em 4 páginas que são grampeadas umas sobre as outras. \nAs páginas impressas em cada folha dupla não podem ser consecutivas, exceto as que ficam na folha central. \nNum certo exemplar uma das folhas duplas corresponde às páginas 31, 32, 85 e 86. \nQuantas páginas ao todo tem este exemplar? ",
			"Seis homens levam seis dias para cavar seis buracos. \nQuanto tempo levarão 12 homens para cavarem 12 buracos? ");
	private List<Integer> respostaSub = Arrays.asList(3, 116, 6);
	
	private List<String> bonusMult = Arrays.asList("Em uma urna há 28 bolas azuis, 20 bolas verdes, 12 bolas amarelas, 10 bolas pretas e 8 bolas brancas. \nQual é o número mínimo de bolas que devemos sacar dessa urna para termos certeza de que sacaremos pelo menos 15 bolas da mesma cor? ",
			"Um tijolo pesa 1 kg mais meio tijolo. Quanto pesa um tijolo? ",
			"Um gato persegue um rato. Enquanto o gato dá 2 pulos o rato dá 3, mas cada pulo do gato vale 2 pulos do rato. Se a distância entre eles inicialmente é de 30 pulos de gato. \nQuantos pulos o gato terá dado até alcançar o rato? ",
			"Um torneio de judô é disputado por 10 atletas e deve ter apenas um campeão. \nEm cada luta não pode haver empate e aquele que perder três vezes deve ser eliminado da competição. \nQual o número máximo de lutas necessário para se conhecer o campeão?");
	private List<Integer> respostaMult = Arrays.asList(59, 2, 120, 29);
	
	private List<String> bonusDiv = Arrays.asList("Num conjunto de 30 pessoas, 5 são altas e gordas, 11 são baixas e 13 são gordas. \nQuantas são as altas e magras?",
			"Num conjunto de 30 pessoas, 5 são altas e gordas, 11 são baixas e 13 são gordas. \nQuantas são as baixas e magras?",
			"Uma caixa contém 900 cartões, numerados de 100 a 999. \nRetiramos ao acaso (sem reposição) cartões da caixa e anotamos a soma dos seus algarismos. \nQual a menor quantidade de cartões que devem ser retirados da caixa para garantirmos que pelo menos 3 destas somas sejam iguais?",
			"Três gatos comem três ratos em três minutos, então 100 gatos comerão 100 ratos em quantos minutos?");
	private List<Integer> respostaDiv = Arrays.asList(14, 3,  53, 3);
	
	private static String[] titulo = {"Erro!", "Parabéns você ACERTOU!", "Infelizmente você ERROU!", "Inválido!", "Mudança de Nível de Dificuldade!"};
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
