package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void init() {
        /*
         * Este el el primer metodo que se ejecuta al crear un obj aplication similar a
         * un constructor
         */
        System.out.println("metodo init ejecutandose");
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("view/ventana-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);
        stage.setTitle("Conversor Challenge OneOracle");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        /* Se ejecutaré este metodo al cerrar la ventana, sirve para cerrar procesos */
        System.out.println("Cerramos aplicacion");

    }

    public static void main(String[] args) {
        launch();
    }
}