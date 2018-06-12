/*
 * A Classe GeraQuestao é a classe onde as questões são organizadas, assim como a seleção das mensagens que deverão aparecer após a resposta.
 * (é uma classe filha de Bonus e usa diretamente as classes Dados, Escolha e Estatistica para gerar as questões matemáticas, essa questão gerada será visualizada pelo usuário que deverá respondê-la).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package questoes;

import java.util.Random;
import selecao.Escolha;

public class GeraQuestao extends Bonus{

	private Escolha escolha; //Variável do tipo escolhe com as escolhas	
	
	private static int contador = 0;
	private static String[] aQuestao = {"", "", "", ""}; //variável para armazenas a questão
	private static int[] respostas = {0, 0, 0, 0}; //armazena as respostas de cada operação
	private static int controlePessoa, controleFinal;
	
	private Dados dado = new Dados(); //instancia uma variável do tipo dados
	private Random random = new Random(); //instancia uma variável randômica

	public GeraQuestao() {
		escolha = new Escolha();
	}

	public void questao() {		
		
		if((contador <=3) && Escolha.getOperacao()[contador]) {
			int total;	
			controlePessoa = controleFinal = 0;
			
			switch (Escolha.getNivelDificuldade()) { //gera questões de acordo com o nível de dificuldade

			case 1:		
				
			case 2:
				
			case 3:
				
			case 4:
				
				inicia();				
				break;
		
			case 5:
								
			case 6:
					
				controleFinal = 1;//controla a finalização
				total = inicia();
				controlePessoa = 1;//controla o início
				total += inicia();
				
				GeraQuestao.getRespostas()[contador] = total;				
				
				break;

			case 8:
				
				inicia();
				
				break;
			
			case 7:

			case 9:
				
				controleFinal = 1;//controla a finalização
				total = inicia();
				controlePessoa = 1;//controla o início
				total += inicia();
				
				GeraQuestao.getRespostas()[contador] = total;	
				
				break;
				
			case 10:
				
				controleFinal = 1;//controla a finalização
				total = inicia();	
				controlePessoa = 1;//controla o início
				total += inicia();
				controleFinal = 2;
				total += inicia();
				
				GeraQuestao.getRespostas()[contador] = total;	
				
		}
	}

	}

	public static String[] getaQuestao() {
		return aQuestao;
	}

	public static void setaQuestao(String[] aQuestao) {
		GeraQuestao.aQuestao = aQuestao;
	}

	public static int[] getRespostas() {
		return respostas;
	}

	public static void setRespostas(int[] respostas) {
		GeraQuestao.respostas = respostas;
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		GeraQuestao.contador = contador;
	}
	
	public static int getControlePessoa() {
		return controlePessoa;
	}

	public static int getControleFinal() {
		return controleFinal;
	}
	
	//inicia as perguntas
	private int inicia() {
		
		String nome = escolha.nome(random.nextInt(dado.getNomeF().size())); //Gera um nome masculino, ou feminino, para a questão				
		String olha = escolha.enunciado(nome); //Gera o enunciado da questão 				
		
		GeraQuestao.getRespostas()[contador] = escolha.itensVistos(nome, olha); //Gera os itens vitos e retorna o total da operação e armazena no array
		
		finalizaPergunta(nome, olha);
		
		return GeraQuestao.getRespostas()[contador];
				
	}

	//Finaliza a pergunta
	private void finalizaPergunta(String nome, String olha) {
		
		if((getContador() == 3) && Escolha.getOperacao()[GeraQuestao.getContador()]) {
			if(getControleFinal() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nQuantas caixas " + nome +" precisará?";
			
			else if(getControleFinal() == 1 && !(getControlePessoa()== 0) && !(Escolha.getNivelDificuldade() == 10))
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nAo final Quantas caixas necessitam?";
			
			else if(controleFinal == 2)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nQuantas seram necessárias?";
			
		}else if((getContador() == 2) && Escolha.getOperacao()[GeraQuestao.getContador()]) {	
			if(getControleFinal() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nQuantas frutas " + nome +" tem?";	
			
			else if(getControleFinal() == 1 && !(getControlePessoa()== 0) && !(Escolha.getNivelDificuldade() == 10))
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nAo final ficaram com quantas frutas?";	
			
			else if(controleFinal == 2)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nCom quantas frutas ficaram?";
			
		}else if((getContador() == 1) && Escolha.getOperacao()[GeraQuestao.getContador()]){
			if(getControleFinal() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nCom quantas frutas " + nome +" " + " ficou?";
			
			else if(getControleFinal() == 1 && !(getControlePessoa()== 0) && !(Escolha.getNivelDificuldade() == 10))
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nFicaram com quantas frutas?";	
			
			else if(controleFinal == 2)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nAo final com quantas frutas ficaram?";	
			
		}else if((getContador() == 0) && Escolha.getOperacao()[GeraQuestao.getContador()]){
			if(getControleFinal() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nQuantas frutas " + nome +" " + olha + "?";
			
			else if(getControleFinal() == 1 && !(getControlePessoa()==0) && !(Escolha.getNivelDificuldade() == 10))
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nFicaram com quantas frutas?";
			
			else if(controleFinal == 2)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nFicaram com quantas frutas?";	
		}
		
	}
	
	//Para os erros e acertos retorna mensagens, caso tenha um certo número de acerto dará uma questão bonus
	public String bonificar(int bonifica, int contador) {
		
		if(bonifica == 1) {
			
			return getBonificacao().get((random.nextInt(getBonificacao().size()))); //retorna uma parabenização/bonificação
			
		}else if(bonifica == 2) {
			
			return getMotivacional().get((random.nextInt(getMotivacional().size()))); //retornar uma mensagem motivacional
			
		}else if(bonifica > 2) {
			
			if(contador == 0) {//soma
				setQuestaoBonus(random.nextInt(getBonusSoma().size()));
				return getBonusSoma().get(getQuestaoBonus());
				
			}else if(contador == 1) {//subtração
				setQuestaoBonus(random.nextInt(getBonusSub().size()));
				return getBonusSub().get(getQuestaoBonus());
				
			}else if(contador == 2) {//multiplicação
				setQuestaoBonus(random.nextInt(getBonusMult().size()));
				return getBonusMult().get(getQuestaoBonus());
				
			}else if(contador == 3) {//divisão
				setQuestaoBonus(random.nextInt(getBonusDiv().size()));
				return getBonusDiv().get(getQuestaoBonus());
			}
		}

		return "ERRO, não existe a bonificação -> 012";

	}

}
