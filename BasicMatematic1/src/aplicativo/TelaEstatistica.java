/*
 * A Classe TelaEstatistica é responsável por gerar o gráficos estatísticos
 * 
 *@author Joel de Oliveira Jacinto
 * 
 * @version 1.0
 * 
 * 11/06/2018
 */

package aplicativo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import selecao.Estatistica;

public class TelaEstatistica extends Application {

	private FlowPane pane;
	private PieChart chart; //Define o elemento gráfico chart
	private ObservableList<PieChart.Data> pieChartData;
	private Estatistica estatistica;
	private CategoryAxis abscissa;
	private NumberAxis ordenada;
	private BarChart<String, Number> barChart;
	@SuppressWarnings("rawtypes")
	private XYChart.Series serie1, serie2, serie3;
	
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		
		initComponents();
		
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("aplicativo/estilo.css");
		
		primaryStage.setTitle("Estatísticas");		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		TelaEstatistica.stage = primaryStage;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked"})
	private void initComponents() {
		
		pane = new FlowPane(20, 20);
		
		estatistica = new Estatistica();
		
		pieChartData = FXCollections.observableArrayList(
				new PieChart.Data("Acertos", estatistica.getNumeroAcerto()), //Adiciona os acertos
				new PieChart.Data("Erros", estatistica.getNumeroErro())); //Adiciona os erros
		chart = new PieChart(pieChartData); 
		chart.setTitle("Relação Acertos/Erros");
		
		abscissa = new CategoryAxis();
		abscissa.setLabel("Relações");
		
		ordenada = new NumberAxis();
		ordenada.setLabel("Nº Tentativas");
		
		barChart = new BarChart<String, Number>(abscissa, ordenada);
		barChart.setTitle("Relação Nº de Acertos/Erros/Total de Tentativas");
		
		serie1 = new XYChart.Series();
		serie1.setName("Total de Tentativas");
		serie1.getData().add(new XYChart.Data("Total de Tentativas", estatistica.getNumeroAcerto() + estatistica.getNumeroErro()));
		
		serie2 = new XYChart.Series();
		serie2.setName("Acertos");
		serie2.getData().add(new XYChart.Data<String, Integer>("Acertos", estatistica.getNumeroAcerto()));
		
		serie3 = new XYChart.Series();
		serie3.setName("Erros");
		serie3.getData().add(new XYChart.Data<String, Integer>("Erros", estatistica.getNumeroErro()));
		
		barChart.getData().addAll(serie2, serie3, serie1);
				
		pane.getChildren().addAll(chart, barChart);
		
		layout();
		
	}
	
	private void layout() {
		
		chart.setPrefSize(250, 250);
		
		barChart.setPrefSize(400, 250);
		
	}

	public static Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
