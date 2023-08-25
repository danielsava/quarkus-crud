package quarkus.crud.rest;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import quarkus.crud.model.Fruit;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;


/**
 *
 *   JSON Serialized/Deserialized
 *     - The Fruit objects will be automatically serialized/deserialized by JSON-B or Jackson, depending on the extension you chose
 *
 *
 *   Application Media: @Produces, @Consumes
 *     - Object: application/json (default)
 *     - String: text/plain
 *     - File: application/octet-stream
 *
 *
 */

@Path("/fruits")
public class FruitResource {

    public Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));


    public FruitResource() {
        fruits.add(new Fruit("Apple", "Winter fruit"));
        fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }


    @GET
    public Set<Fruit> list() {

        return this.fruits;
    }


    @POST
    public Set<Fruit> add(Fruit f) {

        fruits.add(f);
        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit f) {

        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(f.name));
        return fruits;
    }

}

