package main.model;

public class Temperatura {
    private String name;
    private String tag;
    private Double value;
    
    public Temperatura(String name, String tag) {
        this.name = name;
        this.tag = tag;
        
    }
    public Temperatura(String name, String tag,Double value) {
        this.name = name;
        this.tag = tag;
        this.value=value;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
    public Double getValue(){
        return this.value;
    }
    public void setValue(Double value){
        this.value=value;
    }
    

}
