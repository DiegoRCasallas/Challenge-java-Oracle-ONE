package main.model;

public class Moneda {

    private String name;
    private String tag;
    private Double value;

    public Moneda(String name, String tag, Double value) {
        this.name = name;
        this.tag = tag;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
