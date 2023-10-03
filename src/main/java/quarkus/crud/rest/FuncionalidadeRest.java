package quarkus.crud.rest;

import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.common.util.RestMediaType;
import quarkus.crud.entity.Funcionalidade;
import quarkus.crud.repository.FuncionalidadeDAO;

import java.util.List;


/**
 *
 *      Media Type (@Consumes e @Produces):
 *         - When a JSON extension is installed such as quarkus-resteasy-jackson or quarkus-resteasy-jsonb
 *           * Object:  application/json
 *           * String:  text/plain
 *           * File: application/octet-stream
 *
 *
 *      HAL+JSON
 *          * https://quarkus.io/guides/resteasy-reactive#web-links-support
 *
 *
 */


@Path("/funcionalidade")
public class FuncionalidadeRest {


    private final FuncionalidadeDAO dao;


    FuncionalidadeRest(FuncionalidadeDAO dao) {

        this.dao = dao;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, RestMediaType.APPLICATION_HAL_JSON})
    public List<Funcionalidade> listAll() {

        return dao.listAll(Sort.by("id", Sort.Direction.Descending, Sort.NullPrecedence.NULLS_LAST));
    }


    @GET
    @Path("/count")
    public Long count() {

        return dao.count();
    }


    @GET
    @Path("{id}")
    public Funcionalidade findById( @PathParam("id") Long id ) {

        return dao.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Funcionalidade com id " + id + " não encontrado", Response.Status.NOT_FOUND));
    }

    @POST
    @Transactional
    public Funcionalidade add(Funcionalidade f) {

        if(f.id != null)
            throw new WebApplicationException("Somente entidades com id nulo podem ser adicionadas", 500);

        dao.persist(f);

        return f;
    }


    @PUT
    @Path("{id}")     //@Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Funcionalidade update(Long id, Funcionalidade toSave) {


        if(!dao.existe(id))
            throw new WebApplicationException("Entidade com id " + id + " não existe.", 404);

        return dao.getEntityManager().merge(toSave);
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(Long id) {

        if(!dao.existe(id))
            throw new WebApplicationException("Entidade com id " + id + " não existe.", 404);

        dao.deleteById(id);

        return Response.ok().status(204).build();
    }


}
