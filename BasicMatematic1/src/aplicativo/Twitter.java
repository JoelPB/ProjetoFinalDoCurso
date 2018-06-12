/*
 * A Classe Twitter, bem simplificada, serve apenas para abrir o twitter do desenvolvedor
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
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class Twitter extends Application {
	
	private WebView webView;
	@Override
	public void start(Stage primaryStage) throws Exception{
		
		initComponentes();
		
        primaryStage.setScene(new Scene(webView));
        primaryStage.show();
        
	}
	
	private void initComponentes() {
		
		webView = new WebView(); // Cria o nó que será mostrado
		webView.getEngine().load("https://twitter.com/Joel_Oliveira_"); //retorna a Engine que irá rodar o link para o site
	}

	public static void main(String[] args) {
		launch(args);
	}
}
