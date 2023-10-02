package quarkus.crud.rest;

import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import quarkus.crud.entity.Funcionalidade;
import quarkus.crud.repository.FuncionalidadeDAO;

import java.util.List;

@Path("/funcionalidade")
public class FuncionalidadeRest {


    private final FuncionalidadeDAO dao;


    FuncionalidadeRest(FuncionalidadeDAO dao) {

        this.dao = dao;
    }

    @GET
    public List<Funcionalidade> listAll() {

        return dao.listAll(Sort.by("id", Sort.Direction.Descending, Sort.NullPrecedence.NULLS_LAST));
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
            throw new WebApplicationException("Somente entidades com id nulo podem ser adicionadas");

        dao.persist(f);

        return f;
    }


    @PUT
    @Path("{id}")
    @Transactional
    public Funcionalidade update(Long id, Funcionalidade toSave) {

        Funcionalidade f = dao.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Entidade com id " + id + " não existe.", 404));

        return dao.getEntityManager().merge(toSave);
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(Long id) {

        Funcionalidade f = dao.findByIdOptional(id)
                .orElseThrow(() -> new WebApplicationException("Entidade com id " + id + " não existe.", 404));

        dao.deleteById(id);

        return Response.ok().status(204).build();
    }


}
