package main.controller;

import javafx.util.StringConverter;
import main.model.Temperatura;

public class temperaturaConverter extends StringConverter<Temperatura> {

    @Override
    public Temperatura fromString(String temperaturaString) {
        return null;
    }

   /**
    * Si la moneda es nula, devuelve nulo, de lo contrario, devuelve el nombre de la moneda.
    * 
    * @param moneda El objeto a convertir.
    * @return El nombre de la moneda.
    */
    @Override
    public String toString(Temperatura temperatura) {
        return temperatura == null ? null : temperatura.getName();
    }

}
