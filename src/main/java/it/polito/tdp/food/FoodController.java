/**
 * Sample Skeleton for 'Food.fxml' Controller Class
 */

package it.polito.tdp.food;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.food.model.Connessi;
import it.polito.tdp.food.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FoodController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCalorie"
    private TextField txtCalorie; // Value injected by FXMLLoader

    @FXML // fx:id="txtPassi"
    private TextField txtPassi; // Value injected by FXMLLoader

    @FXML // fx:id="btnAnalisi"
    private Button btnAnalisi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorrelate"
    private Button btnCorrelate; // Value injected by FXMLLoader

    @FXML // fx:id="btnCammino"
    private Button btnCammino; // Value injected by FXMLLoader

    @FXML // fx:id="boxPorzioni"
    private ComboBox<String> boxPorzioni; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCammino(ActionEvent event) {
    	txtResult.clear();
    	String tipo = this.boxPorzioni.getValue();
    	if(tipo==null) {
    		txtResult.appendText("Inserisci un tipo di porzione dopo aver creato il grafo!");
    	}
    	String step = this.txtPassi.getText();
    	try {
    		int passi = Integer.parseInt(step);
    		if(passi<=0) {
    			txtResult.appendText("Inserisci un numero di passi maggiore di 0");
    			return;
    		}
    		List<String> best = this.model.getPercorsoMigliore(passi, tipo);
    		txtResult.appendText("peso migliore = "+this.model.getPesoBest());
    		txtResult.appendText("\n percorso migliore : ");
    		for(String s : best)
    			txtResult.appendText(s+" ; ");
    		
    	}catch(NumberFormatException e){
    		e.printStackTrace();
    		txtResult.appendText("Inserisci un numero di passi maggiore di 0");
    	}
    }

    @FXML
    void doCorrelate(ActionEvent event) {
    	txtResult.clear();
        String tipo = this.boxPorzioni.getValue();
    	if(tipo==null) {
    		txtResult.appendText("Inserisci un tipo di porzione dopo aver creato il grafo!");
    	}
    	List<Connessi> tipiConnessi = this.model.getConnessi(tipo);
    	if(tipiConnessi==null)
    		return;
    	for(Connessi c : tipiConnessi)
    		txtResult.appendText(c+"\n");
    }

    @FXML
    void doCreaGrafo(ActionEvent event) {
    	txtResult.clear();
    	String kcal = this.txtCalorie.getText();
    	try {
    		int cal = Integer.parseInt(kcal);
    		if(cal<=0) {
    			txtResult.appendText("inserisci un numero maggiore di zero in Calorie");
    			return;
    		}
    		this.model.creaGrafo(cal);
    		txtResult.appendText("#VERTICI : "+this.model.getNVertici());
    		txtResult.appendText("\n#ARCHI : "+this.model.getNArchi());
    		
    		this.boxPorzioni.getItems().addAll(this.model.getVertici());
    		
    	}catch (NumberFormatException e) {
    		e.printStackTrace();
    		txtResult.appendText("inserisci un numero maggiore di zero in Calorie");
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCalorie != null : "fx:id=\"txtCalorie\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtPassi != null : "fx:id=\"txtPassi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnAnalisi != null : "fx:id=\"btnAnalisi\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCorrelate != null : "fx:id=\"btnCorrelate\" was not injected: check your FXML file 'Food.fxml'.";
        assert btnCammino != null : "fx:id=\"btnCammino\" was not injected: check your FXML file 'Food.fxml'.";
        assert boxPorzioni != null : "fx:id=\"boxPorzioni\" was not injected: check your FXML file 'Food.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Food.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
}
