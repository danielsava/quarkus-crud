package quarkus.crud.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import quarkus.crud.service.GreetingService;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;


    @GET
    @Path("/greeting/{name}")
    public String greeting(String name) {

        return greetingService.greeting(name);
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Hello Quarkus";
    }

}
