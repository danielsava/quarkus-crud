package quarkus.crud.rest;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("usuario")
public class UsuarioService {


    @Inject
    FuncionalidadeService funcionalidadeService;


    @GET
    public Long count() {

        return funcionalidadeService.count();
    }


}
