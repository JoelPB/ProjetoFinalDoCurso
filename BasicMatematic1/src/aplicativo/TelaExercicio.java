/*
 * A Classe TelaExercicio � a responss�vel pelo exerc�cio em se, � onde o usu�rio responde as quest�es e pode visualizar as estat�sticas, sendo que � fornecido
 * a psibilidade de voltar a tela BasicMatematic para mudar o n�vel de dificuldade, ou as opera��es.
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
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import questoes.Bonus;
import questoes.GeraQuestao;
import selecao.Escolha;
import selecao.Estatistica;

public class TelaExercicio extends Application {
	
	private BorderPane painel;
	private AnchorPane paneResposta, erroAcertoSeq;
	private FlowPane pane;
	private StackPane exibeEstatistica; 
	private ScrollPane exibeQuestao;
	private TextField resposta;
	private Button btEnviar, btVoltar, btEstatistica, btTelaCheia, btSairTelaCheia;	
	private Label label, numeroAcerto, numeroErro, numeroQuestao, acertosSeq, errosSeq, acertoMax, erroMax; //Cria uma label onde ser� exibida a quest�o	
	private VBox boxRespsota, boxEstatistica, boxTela;
	private HBox boxErroAcerto;
	private CheckBox checaPopup;
	private GeraQuestao questao; //utilizar para as quest�es
	private int respostaUsuario;
	private int armazenaContador = 4; //utilizado para reiniciar o contador posteriormente
	private boolean verificador = false;
	private Popup popup;
	private TelaBonus bonus;
	
	private Estatistica estatistica;
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
		initComponents();
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("aplicativo/estilo.css");
		
		primaryStage.setTitle("BasicMatematic"); //fornece o t�tulo do programa
		primaryStage.setScene(scene); //define a cena
		primaryStage.setResizable(false); //n�o exibe o bot�o maximizar
		primaryStage.setFullScreen(true); //deixa em tela cheia
		primaryStage.setFullScreenExitHint("Aperte o bot�o \"Sair Tela Cheia\"\nPara sair do modo tela cheia");//mostra a mensagem no in�cio da tela cheia
		
		primaryStage.show();
		
		TelaExercicio.stage = primaryStage;
		
	}

	private void initComponents() {
		
		pane = new FlowPane(); //exibe eum painel no qual os componentes se ajustam de acordo com a orienta��o		
		
		pane.getStyleClass().add("pane");
		
		painel = new BorderPane();	
		
		exibeQuestao = new ScrollPane();
		exibeQuestao.setMaxSize(600, 400);
		exibeQuestao.setHmax(1.5);
		exibeQuestao.setVmax(2);
		exibeQuestao.setPadding(Insets.EMPTY); //determina a margem do preenchimento
		exibeQuestao.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		exibeQuestao.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		
		paneResposta = new AnchorPane();
		paneResposta.setPrefSize(40, 20);
		
		exibeEstatistica = new StackPane();
		exibeEstatistica.setPrefWidth(200);
				
		boxRespsota = new VBox();
		boxEstatistica = new VBox();
		boxTela = new VBox();
		
		boxErroAcerto = new HBox();
		boxErroAcerto.getStyleClass().add("boxErroAcerto");
		
		erroAcertoSeq = new AnchorPane();
		erroAcertoSeq.getStyleClass().add("boxErroAcerto");
		
		resposta = new TextField();
		resposta.setPromptText("Digite a sua resposta aqui...");
		resposta.setCursor(Cursor.TEXT); 
		
		btEnviar = new Button("Enviar resposta");
		btEnviar.getStyleClass().add("btIniciar");
		btEnviar.setCursor(Cursor.HAND);
		
		btVoltar = new Button("\t<--\tVoltar ao\n\tmenu de sele��o\t");
		btVoltar.getStyleClass().add("btVoltar");
		btVoltar.setCursor(Cursor.HAND);
		
		btEstatistica = new Button("    Visualizar estat�sticas   ");
		btEstatistica.getStyleClass().add("btEstatistica");
		btEstatistica.setCursor(Cursor.HAND);
		
		btTelaCheia = new Button("    Tela Cheia   ");
		btTelaCheia.setOpacity(0); //deixa o bot�o invis�vel
		btTelaCheia.getStyleClass().add("btSair");
		btTelaCheia.setCursor(Cursor.HAND);
		
		btSairTelaCheia = new Button("Sair Tela Cheia");
		btSairTelaCheia.getStyleClass().add("btSair");
		btSairTelaCheia.setCursor(Cursor.HAND);
		
		checaPopup = new CheckBox("Bolquear Janela Popup!");
		checaPopup.getStyleClass().add("box");
		checaPopup.setCursor(Cursor.HAND);
		
		popup = new Popup();
		estatistica = new Estatistica();
		bonus = new TelaBonus();
		
		layout();
		initListeners();
		
		questao = new GeraQuestao();
		
		//Verifica se h� opera��o ativa
		for (int i = 0; i < Escolha.getOperacao().length; i++) {
			if(Escolha.getOperacao()[i]) {
				GeraQuestao.setContador(i);
				armazenaContador = i;
				break;
			}
			
		}
		
		if(armazenaContador <=3)
			chamaQuestoes();
		
	}
	
	//Define os layout dos elementos
	private void layout() {		
		
		resposta.setAlignment(Pos.CENTER);
		resposta.setMaxWidth(160);
		
		btEnviar.setPrefWidth(160);
		
		btEstatistica.setMaxWidth(260);
		
		btSairTelaCheia.setPrefWidth(200);
		
		checaPopup.setMaxWidth(260);
		
		boxRespsota.getChildren().addAll(resposta, btEnviar); //adiciona os elementos ao box
		
		boxEstatistica.getChildren().addAll(btEstatistica, boxErroAcerto, erroAcertoSeq, checaPopup);
		
		exibeEstatistica.getChildren().add(boxEstatistica);
		
		exibeQuestao.setMinSize(700, 300);
		
		boxTela.getChildren().addAll(btTelaCheia, btSairTelaCheia);
		
		paneResposta.getChildren().add(boxRespsota);
		
		boxRespsota.setLayoutX(650);
		
		painel.setCenter(exibeQuestao);
		painel.setTop(btVoltar);
		painel.setRight(exibeEstatistica);
		painel.setBottom(paneResposta);
		
		pane.getChildren().addAll(painel, boxTela);
				
	}

	private void initListeners() {
				
		//envia a resposta digitada pelo usu�rio
		resposta.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				acaoResposta();
				
			}
		});
		
		btEnviar.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				
				acaoResposta();
				
			}

			
		});
		
		//Volta a tela de sele��o de n�vel de dificuldade e opera��es 
		btVoltar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				try {
					
					if(estatistica.getNumeroQuestao() > 1)
						estatistica.setNumeroQuestao(estatistica.getNumeroQuestao() - 1); //Decrementa o n�mero de quest�es, pois outra quest�o ser� lan�ada
					//Reinicia as quest�es
					for (int i = 0; i < GeraQuestao.getaQuestao().length; i++) {
						GeraQuestao.getaQuestao()[i] = "";						
					}
					//zera o contador
					GeraQuestao.setContador(0);
					
					//Reinicia as opera��es
					Escolha.getOperacao()[0] = Escolha.getOperacao()[1] = Escolha.getOperacao()[2] = Escolha.getOperacao()[3] = false;
					
					new BasicMatematic().start(new Stage()); //volta a tela de sele��o de opera��o e n�vel
					TelaExercicio.getStage().close(); // fecha a tela atual
					
				} catch (Exception e) {
										
					e.printStackTrace();
					
				}
				
			}
		});
		
		btEstatistica.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				new TelaEstatistica().start(new Stage()); //abre a tela de estat�sticas
				
			}
		});
		
		btTelaCheia.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				getStage().setFullScreen(true); //deixa em tela cheia
				btTelaCheia.setOpacity(0); //oculpra o bot�o de tela cheia
				btSairTelaCheia.setOpacity(1); //deixa vis�vel o bot�o de sair de tela cheia
				
			}
		});
		
		btSairTelaCheia.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				getStage().setFullScreen(false); //sai da tela cheia
				btTelaCheia.setOpacity(1);  //deixa vis�vel o bot�o de tela cheia
				btSairTelaCheia.setOpacity(0); //oculta o bot�o de sair de tela cheia
				
			}
		});
		
	}
	
	//realiza a a��o ap�s o envio da resposta
	private void acaoResposta() {

		try {
							
			respostaUsuario = Integer.parseInt(resposta.getText()); //passa a resposta do usu�rio para inteiro
						
			if(respostaUsuario == GeraQuestao.getRespostas()[GeraQuestao.getContador()]) {						
								
				estatistica.setNumeroAcerto(estatistica.getNumeroAcerto() + 1);
				estatistica.setAcertosSeq(estatistica.getAcertosSeq() + 1);
				estatistica.setErrosSeq(0);
				
				if(estatistica.getAcertosSeq()>0 && (estatistica.getAcertosSeq()%5)==0) {
					bonus.start(new Stage());
				}				
				
				//determina o n�mero m�ximo de acertos em sequ�ncia
				if(estatistica.getAcertosSeq() > estatistica.getAcertoMax()) {
					estatistica.setAcertoMax(estatistica.getAcertosSeq());
					acertoMax.setText("Seq. de acerto M�x.\n" + estatistica.getAcertoMax());
				}
				
				GeraQuestao.getaQuestao()[GeraQuestao.getContador()] = ""; //Zera o array para a quest�o j� visualizada		
				numeroAcerto.setText(null); //zera a amostragem para mostrar novamente
				numeroErro.setText(null);
				numeroQuestao.setText(null);
				acertosSeq.setText(null);
				acertoMax.setText(null);
				erroMax.setText(null);
				
				errosSeq.setVisible(false);
				acertosSeq.setVisible(true);
				
				//sugere a mudan�a de n�vel de dificuldade
				if((estatistica.getAcertosSeq() > 6 && Escolha.getNivelDificuldade() < 10)){
					Bonus.setSeletorTitulo(4); //seta o seletor da classe bonus para a mensagem do t�tulo da janela
					popup.start(new Stage());
				}
				
				for (int j = GeraQuestao.getContador() + 1; j < GeraQuestao.getRespostas().length; j++) {
					if(Escolha.getOperacao()[j]) {
						GeraQuestao.setContador(j); //define o contador para a pr�xima opera��o
						verificador = true;
						break;
					}
				}
				//Se n�o tiver mais opera��o, reinicia as opera��es
				if(!verificador) {
					GeraQuestao.setContador(armazenaContador);
				}			
								
				if(!checaPopup.isSelected()) {
					Bonus.setSeletorTitulo(1); //seta o seletor da classe bonus para a mensagem do t�tulo da janela
					popup.start(new Stage());
				}
					
				resposta.clear();
				chamaQuestoes();
				
				
			}else {
				
				estatistica.setNumeroErro(estatistica.getNumeroErro() + 1); //incremente o n�mero de erros
				estatistica.setErrosSeq(estatistica.getErrosSeq() + 1);
				estatistica.setAcertosSeq(0);
				
				//determina o n�mero m�ximo de erros em sequ�ncia
				if(estatistica.getErrosSeq() > estatistica.getErroMax()) {
					estatistica.setErroMax(estatistica.getErrosSeq());
					erroMax.setText("Seq. de erro M�x.\n" + estatistica.getErroMax());
				}
				
				if((estatistica.getErrosSeq() > 5 && Escolha.getNivelDificuldade() > 1)){
					Bonus.setSeletorTitulo(4); //seta o seletor da classe bonus para a mensagem do t�tulo da janela
					popup.start(new Stage());
				}
				
				estatistica.calcularDados();
				numeroAcerto.setText("Acertos:\n" + estatistica.getNumeroAcerto() + "\nPercentual:\n" + String.format("%.2f", (estatistica.getMediaAcerto()*100)) + "%");
				numeroErro.setText("\t\tErros:\n\t\t" + estatistica.getNumeroErro() + "\n\t\tPercentual:\n\t\t" + String.format("%.2f", (estatistica.getMediaErro()*100)) + "%"); //exibe o n�mero de erros na label
				
				acertosSeq.setVisible(false);
				errosSeq.setVisible(true);
				errosSeq.setText("N� de erros sequenciais: " + estatistica.getErrosSeq());
				
				if(!checaPopup.isSelected()) {
					Bonus.setSeletorTitulo(2); //seta o seletor da classe bonus para a mensagem do t�tulo da janela
					popup.start(new Stage());
				}
				
				resposta.clear();
				
			}
								
			
		} catch (Exception e) {
			
			Bonus.setSeletorTitulo(0);
			resposta.clear();			
			popup.start(new Stage());
			
		}

	}
	
	private void chamaQuestoes() {

		estatistica.calcularDados(); //calcula as m�dias
		
		if((GeraQuestao.getContador()<=3) && Escolha.getOperacao()[GeraQuestao.getContador()]) {
						
			questao.questao();			
			
			numeroAcerto = new Label();
			numeroAcerto.setText("Acertos:\n" + estatistica.getNumeroAcerto() + "\nPercentual:\n" + String.format("%.2f", (estatistica.getMediaAcerto()*100)) + "%");
			numeroAcerto.getStyleClass().add("numeroAcerto");
			
			numeroErro = new Label();
			numeroErro.setText("\t\tErros:\n\t\t" + estatistica.getNumeroErro() + "\n\t\tPercentual:\n\t\t" + String.format("%.2f", (estatistica.getMediaErro()*100)) + "%");
			numeroErro.getStyleClass().add("numeroErro");	
			
			acertosSeq = new Label();
			acertosSeq.setText("N� de acertos sequenciais: " + estatistica.getAcertosSeq());
			acertosSeq.setLayoutY(30);
			acertosSeq.getStyleClass().add("acertoSeq");
			
			errosSeq = new Label();			
			errosSeq.setLayoutY(30);
			errosSeq.getStyleClass().add("erroSeq");
			
			acertoMax = new Label();
			acertoMax.setLayoutY(55);
			acertoMax.setText("Seq. de acerto M�x.\n" + estatistica.getAcertoMax());
			acertoMax.getStyleClass().add("acertoSeq");
			
			erroMax = new Label();
			erroMax.setLayoutX(120);
			erroMax.setLayoutY(55);
			erroMax.setText("Seq. de erro M�x.\n" + estatistica.getErroMax());
			erroMax.getStyleClass().add("erroSeq");
			
			boxErroAcerto.getChildren().addAll(numeroAcerto, numeroErro);
			
			erroAcertoSeq.getChildren().addAll(acertosSeq, errosSeq, acertoMax, erroMax);
			
			numeroQuestao = new Label();
			numeroQuestao.setText("\t\tQuest�o: N� " + (estatistica.getNumeroQuestao()) + "\n\n\n\n***[Dificuldade -> " + Escolha.getNivelDificuldade() +"]***");
			numeroQuestao.getStyleClass().add("numeroQuestao");
			
			painel.setLeft(numeroQuestao);
						
			label = new Label();		
			label.setText(GeraQuestao.getaQuestao()[GeraQuestao.getContador()]);						
			label.getStyleClass().add("textoQuestao");
			label.setMinSize(700, 300);
						
			exibeQuestao.setContent(label); // adiciona a label ao Painel

			verificador = false;
		
		}
		
		estatistica.setNumeroQuestao(estatistica.getNumeroQuestao() + 1); //incrementa a quantidade de quest�es
		
	}

	private static Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
