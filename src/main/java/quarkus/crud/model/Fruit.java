package quarkus.crud.model;

public class Fruit {

    public String name;

    public String description;

    /** Default construct is required by the JSON serialization layer */
    public Fruit() { }


    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }


}
