package main.controller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import main.model.Moneda;

public class temperatureController implements Initializable {
    /* */
    @FXML
    private TextArea txtInputCurrency, txtOutputCurrency;
    @FXML
    private Button btnConvertCurrency;
    @FXML
    private ComboBox<Moneda> cbCurrency2, cbCurrency1;

    private Moneda monedaDestino;

    @FXML
    private void cbEvent(ActionEvent e) {
        Object evento = e.getSource();
        if (evento.equals(cbCurrency2)) {
           setmonedaDestino(cbCurrency2.getSelectionModel().getSelectedItem());
           System.out.println(this.monedaDestino.getTag());
           txtOutputCurrency.setText(this.monedaDestino.getTag());
        }

    }

    // GET Y SET
    public Moneda getmonedaDestino() {
        return monedaDestino;
    }

    public void setmonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
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
        cbCurrency2.getItems().addAll(createCollection());

        /*
         * Configuración del convertidor para el ComboBox,
         * para que me retorne el nombre de la moneda
         */
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

}
