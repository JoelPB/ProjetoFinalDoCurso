/*
 * A Classe TelaInicial � a classe onde � feita a aprensenta��o do software e dado a op��o de inicir e sair
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
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TelaInicial extends Application {

	private BorderPane pane;
	private AnchorPane anchorPane;
	private VBox vBox;
	private Button btIniciar, btSair;
	private Label label, label2;
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) {

		initComponents();

		Scene scene = new Scene(pane); //Componente visual da aplica��o
		scene.getStylesheets().add("aplicativo/estilo.css"); //adiciona o arquivo CSS a Stylesheets
		
		
		primaryStage.setTitle("BasicMatematic"); //fornece o t�tulo do programa
		primaryStage.sizeToScene();
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.UNDECORATED); //some a barra de tarefas
		primaryStage.show();
		TelaInicial.stage = primaryStage;

	}

	private void initComponents() {

		pane = new BorderPane();
		pane.setPrefSize(500, 180);
		pane.getStyleClass().add("paneI");
		
		anchorPane = new AnchorPane();
		anchorPane.setPrefSize(200, 200);
		anchorPane.getStyleClass().add("pane");
		
		btIniciar = new Button("Iniciar");
		btIniciar.getStyleClass().add("btIniciar");
		btIniciar.setCursor(Cursor.HAND);
				
		btSair = new Button("Sair");
		btSair.getStyleClass().add("btSair");
		btSair.setCursor(Cursor.HAND);
		
		label = new Label("\t\t\t\t\t\t\t\t\t\t\t\tBem vindo ao BasicMatematic\t\t\t\t\t\t\t\t\t\t\t\t\n"
				+ "\n\t\t\t\t\t\t\t\t\tO primeiro passo � sempre o come�o de uma grande jornada. \t\t\n"
				+ "\t\t\t\t\t\t\tFicamos contentes em lhe ajudar nessa grande caminhada do conhecimento...\n\t\t\t\t\t\t\t\t\t\t\t\t\tVamos exercitar!\n\n");
		label.getStyleClass().add("textoInicialTitulo");//Adiciona um id do CSS
		
		label2 = new Label("\t\"Se voc� quer transformar o mundo, experimente primeiro promover o seu aperfei�oamento pessoal e realizar inova��es no seu pr�prio interior."
				+ "\n\tEstas atitudes se refletir�o em mudan�as positivas no seu ambiente familiar. "
				+ "Deste ponto em diante, as mudan�as se expandir�o em propor��es\n\tcada vez maiores. "
				+ "Tudo o que fazemos produz efeito, causa algum impacto.\"\n\n" 
				+ "\tDalai Lama\n\n");
		label2.getStyleClass().add("textoInicialParagrafo");		
		
		vBox = new VBox(pane.getPrefHeight() + 8); //cria um box vertical com uma dist�ncia determinada entre eles
		vBox.getStyleClass().add("boxCor");
				
		layout();
		initListeners();

	}

	//Define os layouts
	private void layout() {
		
		vBox.getChildren().addAll(btIniciar, btSair);
		
		anchorPane.getChildren().addAll(label, label2);
		
		pane.setRight(vBox);
		pane.setCenter(anchorPane);
		
		label.setMinWidth(450);
			
		label2.setLayoutY(120);
		label2.setMinWidth(450);
		
		btIniciar.setMinWidth(50);
		btIniciar.setLayoutY(80);
		
		btSair.setMinWidth(50);
		btSair.setLayoutY(80);
		
	}

	//Define as a��es dos bot�es
	private void initListeners() {

		btSair.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				System.exit(0);

			}
		});
		
		btIniciar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					new BasicMatematic().start(new Stage());
					TelaInicial.getStage().close();
					
				} catch (Exception e) {					
					e.printStackTrace();
					
				}

			}
		});

	}	

	private static Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
