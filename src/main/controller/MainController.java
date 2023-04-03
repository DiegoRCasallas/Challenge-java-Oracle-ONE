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
import main.model.Moneda;
import main.model.Temperatura;

public class MainController implements Initializable {

    // VARIABLES
    /* vars currencyConverter */
    private Moneda monedaOrigen;
    private Moneda monedaDestino;
    private Double inputValue;
    private Double outputValue;
    /* vars Temperature converter */

    private Temperatura temperatureOrigen;
    private Temperatura temperatureDestino;
    private Double inputTemperature;
    private Double outputTemperature;

    /* Variables desde la vista principal */
    @FXML
    private TextArea txtInputCurrency, txtOutputCurrency, txtInputTemperature, txtOutputTemperature;
    @FXML
    private Button btnConvertCurrency, btnConvertTemperatureButton;
    @FXML
    private ComboBox<Moneda> cbCurrency1, cbCurrency2;
    @FXML
    private ComboBox<Temperatura> cbTemperature1, cbTemperature2;

    /* Escucha de eventos en Combobox */

    // currency converter events
    @FXML
    private void cbEventCurrOrigen(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbCurrency1)) {
            // Seleccionamos Moneda y asidnamos a moneda origen
            setMonedaOrigen(cbCurrency1.getSelectionModel().getSelectedItem());
            System.out.println(this.monedaOrigen.getTag());
        }
    }

    @FXML
    private void cbEventCurrDestino(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbCurrency2)) {
            // Seleccionamos Moneda y asidnamos a moneda origen
            setMonedaDestino(cbCurrency2.getSelectionModel().getSelectedItem());
            System.out.println(this.monedaDestino.getTag());
        }

    }

    // Temperature converter events
    @FXML
    private void cbEventTempOrigen(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbTemperature1)) {
            // Seleccionamos Moneda y asidnamos a moneda origen
            this.temperatureOrigen = (cbTemperature1.getSelectionModel().getSelectedItem());
            System.out.println(this.temperatureOrigen.getTag());
        }
    }

    @FXML
    private void cbEventTempDestino(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbTemperature2)) {
            // Seleccionamos Moneda y asidnamos a moneda origen
            this.temperatureDestino = (cbTemperature2.getSelectionModel().getSelectedItem());
            System.out.println(this.temperatureDestino.getTag());
        }
    }

    @FXML
    private void btnEventCurrency() {

        try {
            System.out.println("convertir moneda");
            /* 1.Caputurar el valor del input */
            setInputValue(Double.parseDouble(txtInputCurrency.getText()));
            /* 2. Convertir valor a dolares */
            /* 3.Convertir valor a moneda destino */
            currencyConverter();
            txtOutputCurrency.setText(String.valueOf(outputValue));
            System.out.println(this.outputValue);
        } catch (RuntimeException err) {
        
            if (err.getClass() == NumberFormatException.class) {
                txtOutputCurrency.setText("ERROR: debe ingresar numeros unicamente");
                txtInputCurrency.setText("");
            }
            if (err.getClass() == NullPointerException.class) {
                txtOutputCurrency.setText("ERROR: debe seleccionar ambos campos");
            }
            
        }

    }

    @FXML
    private void btnEventTemperature() {
        try {
            System.out.println("convertir a Temperatura");
            this.inputTemperature = Double.parseDouble(txtInputTemperature.getText());
            temperatureConverter();
            txtOutputTemperature.setText(String.valueOf(outputTemperature));
            System.out.println(this.outputTemperature);

        } catch (RuntimeException err) {
            if (err.getClass() == NumberFormatException.class) {
                txtOutputCurrency.setText("ERROR: debe ingresar numeros unicamente");
                txtInputCurrency.setText("");
            }
            if (err.getClass() == NullPointerException.class) {
                txtOutputCurrency.setText("ERROR: debe seleccionar ambos campos");
            }
            
        }
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

        /* 1. monedas */
        cbCurrency1.getItems().addAll(createCollection());
        cbCurrency2.getItems().addAll(createCollection());
        /* 2.Temperaturas */
        cbTemperature1.getItems().addAll(createCollectionTemperatures());
        cbTemperature2.getItems().addAll(createCollectionTemperatures());

        /*
         * Configuración del convertidor para el ComboBox,
         * para que me retorne el nombre de la moneda/Temperatura
         */

        /* 1.monedas */
        cbCurrency1.setConverter(new monedaConverter());
        cbCurrency2.setConverter(new monedaConverter());
        /* 2.Temperaturas */
        cbTemperature1.setConverter(new temperaturaConverter());
        cbTemperature2.setConverter(new temperaturaConverter());

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

    /* Metodos conversion de moneda */
    public Double conversionToDollarValue(Moneda moneda, Double value) {
        return value / moneda.getValue();
    }

    public Double conversionFromDollarValue(Moneda moneda, Double value) {
        return value * moneda.getValue();
    }

    public void currencyConverter() {
        if (monedaOrigen.getTag() != "USD") {
            ArrayList<Moneda> monedasList = createCollection();
            Double result;
            for (int i = 0; i < monedasList.size(); i++) {
                String tagCurrency = monedasList.get(i).getTag();
                if (tagCurrency == monedaOrigen.getTag()) {
                    Double toDollarValue = conversionToDollarValue(this.monedaOrigen, inputValue);
                    result = conversionFromDollarValue(this.monedaDestino, toDollarValue);
                    setOutputValue(result);
                }
            }

        } else {
            Double result = conversionFromDollarValue(this.monedaDestino, inputValue);
            setOutputValue(result);
        }

    }

    /* Metodos conversion de Temperatura */

    private ArrayList<Temperatura> createCollectionTemperatures() {
        ArrayList<Temperatura> temperaturasList = new ArrayList<>();
        temperaturasList.add(new Temperatura("Grados Centigrados", "C"));
        temperaturasList.add(new Temperatura("Grados Fahrenheit", "F"));
        temperaturasList.add(new Temperatura("Grados Kelvin", "K"));
        return temperaturasList;
    }

    public double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9 / 5) + 32;
        return fahrenheit;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsius;
    }

    public double celsiusToKelvin(double celsius) {
        double kelvin = celsius + 273.15;
        return kelvin;
    }

    public double kelvinToCelsius(double kelvin) {
        double celsius = kelvin - 273.15;
        return celsius;
    }

    public void temperatureConverter() {
        Double result;
        if (temperatureOrigen.getTag() != "C") {
            if (temperatureOrigen.getTag() == temperatureDestino.getTag()) {
                this.outputTemperature = this.inputTemperature;
            }
            if (temperatureOrigen.getTag() == "K") {
                Double value = kelvinToCelsius(inputTemperature);
                result = celsiusToFahrenheit(value);
                this.outputTemperature = result;
            }
            if (temperatureOrigen.getTag() == "F") {
                Double value = fahrenheitToCelsius(inputTemperature);
                result = celsiusToKelvin(value);
                this.outputTemperature = result;
            }
        } else {
            if (temperatureDestino.getTag() == "F") {
                result = celsiusToFahrenheit(this.inputTemperature);
                this.outputTemperature = result;
            }
            if (temperatureDestino.getTag() == "K") {
                result = celsiusToKelvin(this.inputTemperature);
                this.outputTemperature = result;
            }

        }

    }

}
