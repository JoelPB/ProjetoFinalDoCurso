 /*
 * A Classe Popup � a respons�vel por mostrar as janelas popup das mensagem de erros e de acertos logo ap�s o usu�rio responder, ou as mensagens popup 
 * que aparecem em v�rios eventos do uso do aplicativo.
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package aplicativo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import questoes.Bonus;
import questoes.GeraQuestao;
import selecao.Estatistica;

public class Popup extends Application {

	private AnchorPane pane;
	private Label label;
	private GeraQuestao mensagem;
	private Estatistica estatistica;
		
	@Override
	public void start(Stage primaryStage) {
		
		initComponents();
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("aplicativo/estilo.css");
		
		primaryStage.setTitle(Bonus.getTitulo()[Bonus.getSeletorTitulo()]); //Criar uma vari�vel na classe Bonus para isso
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
				
	}
	
	private void initComponents() {
		
		label = new Label();
		label.getStyleClass().add("popupLabel");
		
		mensagem = new GeraQuestao();
		estatistica = new Estatistica();
		
		pane = new AnchorPane();
		pane.setMinSize(340, 50);
		pane.getChildren().add(label);
		
		if(Bonus.getTitulo()[Bonus.getSeletorTitulo()].equals("Erro!")) {//Grera o popup de erro
			label.setText("\n\nValor inv�lidio!\nDigite um valor INTEIRO!");
			label.getStyleClass().add("label0");
			pane.getStyleClass().add("popupPane0");
			pane.setMinSize(200, 40);
		}else if(Bonus.getTitulo()[Bonus.getSeletorTitulo()].equals("Inv�lido!")) {// gera a mensagem quando ocorre um ato inv�lido
			label.setText("\n\t\tA��o inv�lida!\n\nSelecione pelo menos uma opera��o.");
			label.getStyleClass().add("label1");
			pane.getStyleClass().add("popupPane1");
			pane.setMinSize(200, 40);
		}else if(Bonus.getSeletorTitulo() == 1 || Bonus.getSeletorTitulo() == 2){//Mostra o popup parebeniza��o, ou mensagem motivacional
			label.setText(mensagem.bonificar(Bonus.getSeletorTitulo(), GeraQuestao.getContador()));
			if(Bonus.getSeletorTitulo() == 1) { //modifica o layout da janela
				label.getStyleClass().add("label2");
				pane.getStyleClass().add("popupPane2");
			}else {
				label.getStyleClass().add("label0");
				pane.getStyleClass().add("popupPane0");
			}
		}else if(Bonus.getTitulo()[Bonus.getSeletorTitulo()].equals("Mudan�a de N�vel de Dificuldade!")) {//gera o popup para as mensagens de mudan�a de n�vel
			if(estatistica.getAcertosSeq() > 0) {
				label.setText("\n\t\tVoc� tem ido muito bem!\n\nAcredito que j� esteja na hora de aumentar o n�vel.\nSempre que estiver muito f�cil acrescente um n�vel de dificuldade.");
				label.getStyleClass().add("label2");
				pane.getStyleClass().add("popupPane1");			
			}else {
				label.setText("\n\t\tInfelizmente parece que voc� n�o tem conseguido bons resultados!\n\nAcredito que esteja na hora de diminuir o n�vel.\nSempre que estiver muito dif�cil diminua um n�vel de dificuldade.");
				label.getStyleClass().add("label0");
				pane.getStyleClass().add("popupPane0");	
			}
				
		}			
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
