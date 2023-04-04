package main.model;

public class Temperatura {
    private String name;
    private String tag;
    
    public Temperatura(String name, String tag) {
        this.name = name;
        this.tag = tag;
        
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
}
