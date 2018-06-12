 /*
 * A Classe Popup é a responsável por mostrar as janelas popup das mensagem de erros e de acertos logo após o usuário responder, ou as mensagens popup 
 * que aparecem em vários eventos do uso do aplicativo.
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
		
		primaryStage.setTitle(Bonus.getTitulo()[Bonus.getSeletorTitulo()]); //Criar uma variável na classe Bonus para isso
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
			label.setText("\n\nValor inválidio!\nDigite um valor INTEIRO!");
			label.getStyleClass().add("label0");
			pane.getStyleClass().add("popupPane0");
			pane.setMinSize(200, 40);
		}else if(Bonus.getTitulo()[Bonus.getSeletorTitulo()].equals("Inválido!")) {// gera a mensagem quando ocorre um ato inválido
			label.setText("\n\t\tAção inválida!\n\nSelecione pelo menos uma operação.");
			label.getStyleClass().add("label1");
			pane.getStyleClass().add("popupPane1");
			pane.setMinSize(200, 40);
		}else if(Bonus.getSeletorTitulo() == 1 || Bonus.getSeletorTitulo() == 2){//Mostra o popup parebenização, ou mensagem motivacional
			label.setText(mensagem.bonificar(Bonus.getSeletorTitulo(), GeraQuestao.getContador()));
			if(Bonus.getSeletorTitulo() == 1) { //modifica o layout da janela
				label.getStyleClass().add("label2");
				pane.getStyleClass().add("popupPane2");
			}else {
				label.getStyleClass().add("label0");
				pane.getStyleClass().add("popupPane0");
			}
		}else if(Bonus.getTitulo()[Bonus.getSeletorTitulo()].equals("Mudança de Nível de Dificuldade!")) {//gera o popup para as mensagens de mudança de nível
			if(estatistica.getAcertosSeq() > 0) {
				label.setText("\n\t\tVocê tem ido muito bem!\n\nAcredito que já esteja na hora de aumentar o nível.\nSempre que estiver muito fácil acrescente um nível de dificuldade.");
				label.getStyleClass().add("label2");
				pane.getStyleClass().add("popupPane1");			
			}else {
				label.setText("\n\t\tInfelizmente parece que você não tem conseguido bons resultados!\n\nAcredito que esteja na hora de diminuir o nível.\nSempre que estiver muito difícil diminua um nível de dificuldade.");
				label.getStyleClass().add("label0");
				pane.getStyleClass().add("popupPane0");	
			}
				
		}			
				
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
