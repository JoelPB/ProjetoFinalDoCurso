/*
 * A Classe TelaBonus é a responsável por mostrar a tela com a questão bonus para uma boa quantidade de acertos sequenciais
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package aplicativo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import questoes.Bonus;
import questoes.GeraQuestao;
import selecao.Escolha;

public class TelaBonus extends Application {
	
	private FlowPane pane;
	private TextField resposta;
	private Label questao;
	private Button btEnviar;
	private VBox boxQuestao;
	private int respostaUsuario;
	private GeraQuestao geraQuestao;
	private Popup popup;
	private CheckBox checaPopup;
	
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) {
		
		initComponents();
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("aplicativo/estilo.css");
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Questão Bonus");		
		primaryStage.setResizable(false);
		primaryStage.show();
		
		TelaBonus.stage = primaryStage;
		
	}
	
	private void initComponents() {
		
		pane = new FlowPane();
		pane.getStyleClass().add("telaBonus");
		
		resposta = new TextField("Digite a resposta aqui");
		
		btEnviar = new Button("Enviar Respsota");
		btEnviar.getStyleClass().add("btIniciar");
		
		questao = new Label();
		questao.getStyleClass().add("textoQuestao");
		
		boxQuestao = new VBox(10);
		
		checaPopup = new CheckBox("Bolquear Janela Popup!");
		checaPopup.getStyleClass().add("box");
		checaPopup.setCursor(Cursor.HAND);
		
		boxQuestao.getChildren().addAll(questao, resposta, btEnviar, checaPopup);
		
		pane.getChildren().add(boxQuestao);
		
		popup = new Popup();
		geraQuestao = new GeraQuestao();
		
		layout();
		initListeners();
		
		iniciaQuestao();
		
	}

	private void layout() {
		
		resposta.setAlignment(Pos.CENTER);
		resposta.setMaxWidth(160);
		
	}
	
	//Ações de seleção
	private void initListeners() {	

		resposta.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				acaoResposta();
				
			}
		});
		
		btEnviar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				acaoResposta();
				
			}
		});
		
	}
			
	private void acaoResposta() {
		
		try {
			
			respostaUsuario = Integer.parseInt(resposta.getText());
			//verifica se a resposta está correta
			if((respostaUsuario == geraQuestao.getRespostaSoma().get(Bonus.getQuestaoBonus()) && Escolha.getOperacao()[0]) ||
				(respostaUsuario == geraQuestao.getRespostaSub().get(Bonus.getQuestaoBonus()) && Escolha.getOperacao()[1]) ||
				(respostaUsuario == geraQuestao.getRespostaMult().get(Bonus.getQuestaoBonus()) && Escolha.getOperacao()[2]) ||
				(respostaUsuario == geraQuestao.getRespostaDiv().get(Bonus.getQuestaoBonus()) && Escolha.getOperacao()[3])) { //obs.: para cada operação há uma sequência de questões bonus diferente
								
				if(!checaPopup.isSelected()) {
					Bonus.setSeletorTitulo(1); //seta o seletor da classe bonus para a mensagem do título da janela
					popup.start(new Stage());
				}
				
				stage.close();
				
			}else {
				
				if(!checaPopup.isSelected()) {
					Bonus.setSeletorTitulo(2); //seta o seletor da classe bonus para a mensagem do título da janela
					popup.start(new Stage());
				}
				
				resposta.clear();
				
			}			
			
		} catch (Exception e) {
			
			if(!checaPopup.isSelected()) {
				Bonus.setSeletorTitulo(0); //seta o seletor da classe bonus para a mensagem do título da janela
				popup.start(new Stage());
			}
			
			resposta.clear();
		}	
		
	}
	
	//apresenta a questão na tela
	private void iniciaQuestao() {
		
		questao.setText(geraQuestao.bonificar(3, GeraQuestao.getContador()));
		
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
