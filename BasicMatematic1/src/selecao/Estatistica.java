/*
 * A Classe Estatistica é a classe responsável por fornecer tudo o que é necessário para o tratamento estatístico
 * (é a classe responsável por gerar e fornecer as estatísticas para o usuário).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */

package selecao;

public class Estatistica {
	
	private static int numeroQuestao = 1; //Número total de questões resolvidas
	private static int numeroAcerto = 0; //Número total de acertos
	private static int acertosSeq = 0; //Número atual de acertos em sequência
	private static int acertoMax = 0; //Quantidade máxima de acertos em sequência
	private static int numeroErro = 0;; //Número total de erros
	private static int errosSeq = 0; //Número atual de erros em sequência
	private static int erroMax = 0; //Quantidade máxima de erros em sequência
	private double mediaAcerto; //Média de acertos
	private double mediaErro; //Média de Erros

		
	public int getAcertoMax() {
		return acertoMax;
	}

	public void setAcertoMax(int acertoMax) {
		Estatistica.acertoMax = acertoMax;
	}

	public int getErroMax() {
		return erroMax;
	}

	public void setErroMax(int erroMax) {
		Estatistica.erroMax = erroMax;
	}

	public int getNumeroQuestao() {
		return numeroQuestao;
	}

	public void setNumeroQuestao(int numeroQuestao) {
		Estatistica.numeroQuestao = numeroQuestao;
	}

	public int getNumeroAcerto() {
		return numeroAcerto;
	}

	public void setNumeroAcerto(int numeroAcerto) {
		Estatistica.numeroAcerto = numeroAcerto;
	}

	public int getNumeroErro() {
		return numeroErro;
	}

	public void setNumeroErro(int numeroErro) {
		Estatistica.numeroErro = numeroErro;
	}
	
	public int getAcertosSeq() {
		return acertosSeq;
	}

	public void setAcertosSeq(int acertosSeq) {
		Estatistica.acertosSeq = acertosSeq;
	}

	public int getErrosSeq() {
		return errosSeq;
	}

	public void setErrosSeq(int errosSeq) {
		Estatistica.errosSeq = errosSeq;
	}	
	
	public double getMediaAcerto() {
		return mediaAcerto;
	}

	public double getMediaErro() {
		return mediaErro;
	}
	
	//realiza os cáculos estatísticos que o usuário necessita
	public void calcularDados() {
		
		if(getNumeroAcerto() != 0) { //impede a divisão por zero
			this.mediaAcerto =  Math.abs((getNumeroAcerto())/(double)(getNumeroErro() + getNumeroAcerto()));
			
		}
		
		if(getNumeroErro() != 0) { //impede a divisão por zero
			
			this.mediaErro = Math.abs((getNumeroErro())/(double)(getNumeroErro() + getNumeroAcerto()));
		}
		
	}
	
}
