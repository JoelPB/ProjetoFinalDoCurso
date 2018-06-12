/*
 * A Classe Estatistica � a classe respons�vel por fornecer tudo o que � necess�rio para o tratamento estat�stico
 * (� a classe respons�vel por gerar e fornecer as estat�sticas para o usu�rio).
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */

package selecao;

public class Estatistica {
	
	private static int numeroQuestao = 1; //N�mero total de quest�es resolvidas
	private static int numeroAcerto = 0; //N�mero total de acertos
	private static int acertosSeq = 0; //N�mero atual de acertos em sequ�ncia
	private static int acertoMax = 0; //Quantidade m�xima de acertos em sequ�ncia
	private static int numeroErro = 0;; //N�mero total de erros
	private static int errosSeq = 0; //N�mero atual de erros em sequ�ncia
	private static int erroMax = 0; //Quantidade m�xima de erros em sequ�ncia
	private double mediaAcerto; //M�dia de acertos
	private double mediaErro; //M�dia de Erros

		
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
	
	//realiza os c�culos estat�sticos que o usu�rio necessita
	public void calcularDados() {
		
		if(getNumeroAcerto() != 0) { //impede a divis�o por zero
			this.mediaAcerto =  Math.abs((getNumeroAcerto())/(double)(getNumeroErro() + getNumeroAcerto()));
			
		}
		
		if(getNumeroErro() != 0) { //impede a divis�o por zero
			
			this.mediaErro = Math.abs((getNumeroErro())/(double)(getNumeroErro() + getNumeroAcerto()));
		}
		
	}
	
}
