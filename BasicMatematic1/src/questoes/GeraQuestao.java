/*
 * A Classe GeraQuestao � a classe onde as quest�es s�o organizadas, assim como a sele��o das mensagens que dever�o aparecer ap�s a resposta.
 * (� uma classe filha de Bonus e usa diretamente as classes Dados, Escolha e Estatistica para gerar as quest�es matem�ticas, essa quest�o gerada ser� visualizada pelo usu�rio que dever� respond�-la).
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

	private Escolha escolha; //Vari�vel do tipo escolhe com as escolhas	
	
	private static int contador = 0;
	private static String[] aQuestao = {"", "", "", ""}; //vari�vel para armazenas a quest�o
	private static int[] respostas = {0, 0, 0, 0}; //armazena as respostas de cada opera��o
	private static int controlePessoa, controleFinal;
	
	private Dados dado = new Dados(); //instancia uma vari�vel do tipo dados
	private Random random = new Random(); //instancia uma vari�vel rand�mica

	public GeraQuestao() {
		escolha = new Escolha();
	}

	public void questao() {		
		
		if((contador <=3) && Escolha.getOperacao()[contador]) {
			int total;	
			controlePessoa = controleFinal = 0;
			
			switch (Escolha.getNivelDificuldade()) { //gera quest�es de acordo com o n�vel de dificuldade

			case 1:		
				
			case 2:
				
			case 3:
				
			case 4:
				
				inicia();				
				break;
		
			case 5:
								
			case 6:
					
				controleFinal = 1;//controla a finaliza��o
				total = inicia();
				controlePessoa = 1;//controla o in�cio
				total += inicia();
				
				GeraQuestao.getRespostas()[contador] = total;				
				
				break;

			case 8:
				
				inicia();
				
				break;
			
			case 7:

			case 9:
				
				controleFinal = 1;//controla a finaliza��o
				total = inicia();
				controlePessoa = 1;//controla o in�cio
				total += inicia();
				
				GeraQuestao.getRespostas()[contador] = total;	
				
				break;
				
			case 10:
				
				controleFinal = 1;//controla a finaliza��o
				total = inicia();	
				controlePessoa = 1;//controla o in�cio
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
		
		String nome = escolha.nome(random.nextInt(dado.getNomeF().size())); //Gera um nome masculino, ou feminino, para a quest�o				
		String olha = escolha.enunciado(nome); //Gera o enunciado da quest�o 				
		
		GeraQuestao.getRespostas()[contador] = escolha.itensVistos(nome, olha); //Gera os itens vitos e retorna o total da opera��o e armazena no array
		
		finalizaPergunta(nome, olha);
		
		return GeraQuestao.getRespostas()[contador];
				
	}

	//Finaliza a pergunta
	private void finalizaPergunta(String nome, String olha) {
		
		if((getContador() == 3) && Escolha.getOperacao()[GeraQuestao.getContador()]) {
			if(getControleFinal() == 0)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\nQuantas caixas " + nome +" precisar�?";
			
			else if(getControleFinal() == 1 && !(getControlePessoa()== 0) && !(Escolha.getNivelDificuldade() == 10))
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nAo final Quantas caixas necessitam?";
			
			else if(controleFinal == 2)
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] += "\n\nQuantas seram necess�rias?";
			
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
	
	//Para os erros e acertos retorna mensagens, caso tenha um certo n�mero de acerto dar� uma quest�o bonus
	public String bonificar(int bonifica, int contador) {
		
		if(bonifica == 1) {
			
			return getBonificacao().get((random.nextInt(getBonificacao().size()))); //retorna uma parabeniza��o/bonifica��o
			
		}else if(bonifica == 2) {
			
			return getMotivacional().get((random.nextInt(getMotivacional().size()))); //retornar uma mensagem motivacional
			
		}else if(bonifica > 2) {
			
			if(contador == 0) {//soma
				setQuestaoBonus(random.nextInt(getBonusSoma().size()));
				return getBonusSoma().get(getQuestaoBonus());
				
			}else if(contador == 1) {//subtra��o
				setQuestaoBonus(random.nextInt(getBonusSub().size()));
				return getBonusSub().get(getQuestaoBonus());
				
			}else if(contador == 2) {//multiplica��o
				setQuestaoBonus(random.nextInt(getBonusMult().size()));
				return getBonusMult().get(getQuestaoBonus());
				
			}else if(contador == 3) {//divis�o
				setQuestaoBonus(random.nextInt(getBonusDiv().size()));
				return getBonusDiv().get(getQuestaoBonus());
			}
		}

		return "ERRO, n�o existe a bonifica��o -> 012";

	}

}
