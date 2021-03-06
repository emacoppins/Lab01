package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancel;
    
    @FXML
    private TextArea txtTempo;
    
    
    @FXML
    void doCancel(ActionEvent event) {
    	String daCancellare=txtResult.getSelectedText();
    	elenco.cancel(daCancellare);
    		txtResult.deleteText(txtResult.getSelection());
    		txtTempo.setText(Long.toString(System.nanoTime()));
    		
    }

    @FXML
    void doInsert(ActionEvent event) {
    	
    	// inserisco parola
    	elenco.addParola(txtParola.getText());
    	
    	
    	//stampo elenco
    	String s="";
    	for(int i=0; i<elenco.getElenco().size();i++) {
    		s+=elenco.getElenco().get(i)+"\n";
    		}
    	txtResult.setText(s);
    	txtParola.deleteText(0, txtParola.getLength());
    	txtTempo.setText(Long.toString(System.nanoTime()));
    }

    @FXML
    void doReset(ActionEvent event) {
    	elenco.reset();
    	txtResult.deleteText(0, txtResult.getLength());
    	txtTempo.setText(Long.toString(System.nanoTime()));
    	
    	// TODO
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        
        elenco = new Parole() ;
    }
}
