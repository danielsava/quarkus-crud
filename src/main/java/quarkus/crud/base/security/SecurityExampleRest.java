package quarkus.crud.base.security;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.SecurityContext;

import java.security.Principal;

@Path("user")
public class SecurityExampleRest {


    @Inject
    SecurityContext securityContext;

    @GET
    public String userName() {

        Principal user = securityContext.getUserPrincipal();

        return user != null ? user.getName() : "<NOT LOGGED IN>";
    }


}
