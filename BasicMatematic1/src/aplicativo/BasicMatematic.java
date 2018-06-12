/*
 * A classe BasicMatematic � responss�vel pela sele��o das opera��es e do n�vel de dificuldade dos exerc�cios.
 * Nela o usu�rio poder� escolher de uma a quatro das opera��es e um n�vel de dificuldade, logo depois clicar em exercitar e come�ar a fazer os exerc�cios em outra tela.
 * 
 * @author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */


package aplicativo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import questoes.Bonus;
import selecao.Escolha;

public class BasicMatematic extends Application {

	private BorderPane pane;
	private CheckBox box1, box2, box3, box4;
	private VBox vBox1, vBox2, vBox3;
	private ScrollBar barra;
	private Button btSair, btExercitar;
	private Label titulo, operacoes, dificuldade, dificuldadeNiveis;
	private Hyperlink link;
	private Popup popup;
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception{

		initComponents();		

		Scene scene = new Scene(pane); //cria o conteiner para a cena
		scene.getStylesheets().add("aplicativo/estilo.css"); //adiciona o arquivo CSS a Stylesheets

		primaryStage.initStyle(StageStyle.UNDECORATED);		
		primaryStage.setScene(scene); //especifica a cena usada
		primaryStage.show(); //mostra a janela
		BasicMatematic.stage = primaryStage;

	}	

	//nicializa os componentes do painel
	private void initComponents() {

		pane = new BorderPane(); //cria um painel para ancorar
		pane.getStyleClass().add("pane"); //define o estilo do painel atravez da folha de estilo
		
		box1 = new CheckBox("Soma (+)                      "); //cria a caixa de sele��o para a soma		
		//box1.setSelected(true);
		box1.getStyleClass().add("box"); //define o estilo do box
		box1.setCursor(Cursor.HAND); //muda o cursor do mouse para uma m�o
		
		box2 = new CheckBox("Subtra��o (-)                ");
		box2.getStyleClass().add("box");
		box2.setCursor(Cursor.HAND);
		
		box3 = new CheckBox("Multiplica��o (*)          ");
		box3.getStyleClass().add("box");
		box3.setCursor(Cursor.HAND);
		
		box4 = new CheckBox("Divis�o (/)                    ");
		box4.getStyleClass().add("box");
		box4.setCursor(Cursor.HAND);
		
		barra = new ScrollBar(); //cria a barra para selecionar a dificuldade
		barra.setPrefSize(400, 40);	//dimensiona a barra
		barra.setMax(90);
		barra.setUnitIncrement(10); //passo da barra
		barra.getStyleClass().add("barra");
		barra.setCursor(Cursor.MOVE);
		
		vBox1 = new VBox(10);
		vBox1.getStyleClass().add("menuSelecao");
		vBox2 = new VBox(150);
		vBox3 = new VBox(10);
		
		//Bot�es
		btSair = new Button("Sair");		
		btSair.getStyleClass().add("btSair");
		btSair.setCursor(Cursor.HAND);
		
		btExercitar = new Button("Exercitar");
		btExercitar.getStyleClass().add("btIniciar");
		btExercitar.setCursor(Cursor.HAND);
		
		titulo = new Label("\t\t\t\t\t\t\t\t\t\t\tBasicMatematic");
		operacoes = new Label("\n\tSelecione as opera��es  \n\tdesejadas:");
		dificuldade = new Label("\n\tSelecione o n�vel de dificuldade:\n\n\t\t\t\t\tN�vel de dificuldade: "+(int)(barra.getValue()/10 + 1));	
		dificuldadeNiveis = new Label("     1           2          3           4          5         6          7          8          9         10");
		
		link = new Hyperlink("https://twitter.com/Joel_Oliveira_"); //Define o hyperlink para o twitter
		
		popup = new Popup();
		
		layout(); //define os layouts
		initListeners(); //iniciar as a��es

	}

	//define os layouts necess�rios
	private void layout() {
		
		//Adiciona componentes aos boxes
		vBox1.getChildren().addAll(operacoes, box1, box2, box3, box4);
		vBox2.getChildren().addAll(btExercitar, btSair);
		vBox3.getChildren().addAll(dificuldade, dificuldadeNiveis, barra);
		
		barra.setOrientation(Orientation.HORIZONTAL); //Define a posi��o da barra
		
		btSair.setMinWidth(60);
		
		//adiciona os elementos a pane
		pane.setTop(titulo);
		pane.setBottom(link);
		pane.setLeft(vBox1);
		pane.setRight(vBox2);
		pane.setCenter(vBox3);
		
	}

	//A��es de sele��o
	private void initListeners() {		
		
		//define a a��o da caixa de soma
		box1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				Escolha.getOperacao()[0] = box1.isSelected();
				
			}
		});

		box2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				Escolha.getOperacao()[1] = box2.isSelected();
				
			}
		});
		
		box3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				Escolha.getOperacao()[2] = box3.isSelected();
				
			}
		});
		
		box4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				Escolha.getOperacao()[3] = box4.isSelected();
				
			}
		});
		
		//seleciona a posi��o da barra de sele��o		
		barra.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				//Mostra o n�vel de dificuldade
				dificuldade.setText("\n\tSelecione o n�vel de dificuldade:\n\n\t\t\t\t\tN�vel de dificuldade: "+(int)(barra.getValue()/10 + 1));
				
			}
		});
		
		
		btSair.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				System.exit(0); //sai do programa
				
			}
		});
		
		btExercitar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				
				try {
					
					int verifica = 0;
					for (int i = 0; i < Escolha.getOperacao().length; i++) {
						if(Escolha.getOperacao()[i]) { //verifica se alguma opera��o foi selecionada
							verifica++;
							break;
						}
					}
					
					//se houver opera��o selecionada feicha a tela e abre a tela de exerc�cio
					if(verifica != 0) {
						Escolha.setNivelDificuldade((int)(barra.getValue()/10 + 1));
						new TelaExercicio().start(new Stage());
						BasicMatematic.getStage().close();
					}
					
					//caso n�o seja selecionado uma opera��o aparece a tela popup de advert�ncia
					else {
						Bonus.setSeletorTitulo(3);
						popup.start(new Stage());
						
					}
					
				} catch (Exception e) {
					
					e.printStackTrace();	
					
				}
				
			}
		});
		
		//Mostra o Twitter do desenvolvedor com o clik do mouse
		link.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				try {
					
					new Twitter().start(new Stage());
					
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
