package main.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import main.model.ConversorCurrency;
import main.model.Moneda;

public class MainController implements Initializable {

    /*vars */
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private Double inputValue;
    private Double outputValue;
  
    /*Variables desde la vista principal*/
    @FXML
    private TextArea txtInputCurrency, txtOutputCurrency,txtInputTemperature, txtOutputTemperature;
    @FXML
    private Button btnConvertCurrency,btnConvertTemperatureButton;
    @FXML
    private ComboBox<Moneda> cbCurrency1, cbCurrency2, cbTemperature1, cbTemperature2;
    
    /*Escucha de eventos en Combobox */
    @FXML
    private void cbEvent(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbCurrency2)) {
            setMonedaDestino(cbCurrency2.getSelectionModel().getSelectedItem());
            System.out.println(this.monedaDestino.getTag());
            txtOutputCurrency.setText(this.monedaDestino.getTag());
        }

    }
    @FXML
    private void cbEventCurrOrigen(ActionEvent e){
        Object evento= e.getSource();
        if(evento.equals(cbCurrency1)){
            //Seleccionamos Moneda y asidnamos a moneda origen
            setMonedaOrigen(cbCurrency1.getSelectionModel().getSelectedItem());
            System.out.println(this.monedaOrigen.getTag());
        }
    }
    @FXML
    private void cbEventCurrDestino(ActionEvent e){
        Object evento= e.getSource();
        if(evento.equals(cbCurrency2)){
            //Seleccionamos Moneda y asidnamos a moneda origen
            setMonedaOrigen(cbCurrency2.getSelectionModel().getSelectedItem());
            System.out.println(this.monedaOrigen.getTag());
        }

    }
    @FXML
    private void cbEventTempOrigen(){

    }
    @FXML
    private void cbEventTempDestino(){

    }
    
    @FXML
    private void btnEventCurrency(){
        System.out.println("convertir moneda");
        /*1.Caputurar el valor del input */
        setInputValue(Double.parseDouble(txtInputCurrency.getText()));
        /*1.5 Validar mondeda origen y monedaDestino */
        
        /*2. Convertir valor a dolares */

        /*3.Convertir valor a moneda destino */
        System.out.println(this.inputValue);
    }
    @FXML
    private void btnEventTemperature(){
        System.out.println("convertir a Temperatura");
    }

    // GET Y SET
    public Moneda getMonedaOrigen() {
        return monedaOrigen;
    }
    public void setMonedaOrigen(Moneda monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }
    public Moneda getMonedaDestino() {
        return monedaDestino;
    }
    public void setMonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
    }
    public Double getInputValue() {
        return inputValue;
    }
    public void setInputValue(Double inputValue) {
        this.inputValue = inputValue;
    }
    public Double getOutputValue() {
        return outputValue;
    }
    public void setOutputValue(Double outputValue) {
        this.outputValue = outputValue;
    }

    // METODODS

   
    /**
     * Esta función se llama cuando se carga el archivo FXML y se usa para
     * inicializar el controlador.
     * 
     * @param location  La ubicación utilizada para resolver rutas relativas para el
     *                  objeto raíz, o nula
     *                  si no se conoce la ubicación.
     * @param resources Los recursos usados para localizar el objeto raíz, o nulo si
     *                  el objeto raíz no
     *                  estaba localizado.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Agregando la colección al ComboBox.
        cbCurrency1.getItems().addAll(createCollection());
        cbCurrency2.getItems().addAll(createCollection());

        /*Configuración del convertidor para el ComboBox,
        para que me retorne el nombre de la moneda*/
        cbCurrency1.setConverter(new monedaConverter());
        cbCurrency2.setConverter(new monedaConverter());


    }

    /**
     * Crea una nueva ArrayList de objetos Moneda, le agrega 6 objetos Moneda y
     * devuelve la ArrayList
     * 
     * @return Una colección de objetos Moneda.
     */
    private ArrayList<Moneda> createCollection() {
        ArrayList<Moneda> monedas = new ArrayList<>();
        monedas.add(new Moneda("Dolar USA", "USD", 1.0));
        monedas.add(new Moneda("Peso Mexicano", "MXN", 18.23));
        monedas.add(new Moneda("Peso Colombiano", "COP", 4600.0));
        monedas.add(new Moneda("Euro", "EUR", 0.92));
        monedas.add(new Moneda("Yen Japonés", "YEN", 132.6));
        monedas.add(new Moneda("Won Surcoreano", "KRW", 1305.65));
        return monedas;
    }

    /*Metodos conversion de com */


}
