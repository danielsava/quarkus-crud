package quarkus.crud.rest;

import io.quarkus.logging.Log;
import io.quarkus.panache.common.Sort;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import quarkus.crud.entity.Funcionalidade;
import quarkus.crud.repository.FuncionalidadeDAO;

import java.util.List;

@Path("/funcionalidade")
public class FuncionalidadeRest {


    private final FuncionalidadeDAO dao;


    FuncionalidadeRest (FuncionalidadeDAO dao) {

        this.dao = dao;
    }

    @GET
    public List<Funcionalidade> get() {

        return dao.listAll(Sort.by("id", Sort.Direction.Descending, Sort.NullPrecedence.NULLS_LAST));
    }

    @GET
    @Path("{id}")
    public Funcionalidade getById(Long id) {

        Funcionalidade f = dao.findById(id);

        if(f == null)
            throw new WebApplicationException("Funcionalidade com id " + id + " não encontrado", 404);

        return f;
    }

    @POST
    @Transactional
    public Response add(Funcionalidade f) {

        if(f.id != null)
            throw new WebApplicationException("Entidade com ID existente. Não permitido criar");

        dao.persist(f);

        Log.info("Funcionalidade salva!");

        return Response.ok(f).status(201).build();
    }


    @PUT
    @Path("{id}")
    @Transactional
    public Response update(Long id, Funcionalidade toSave) {

        Funcionalidade f = dao.findById(id);

        if(f == null)
            throw new WebApplicationException("Entidade com id " + id + " não existe.", 404);

        Funcionalidade salvo = dao.getEntityManager().merge(toSave);

        Log.info("Funcionalidade atualizada!");

        return Response.ok(salvo)
                .status(201)
                .build();
    }


    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(Long id) {

        Funcionalidade f = dao.findById(id);

        if(f == null)
            throw new WebApplicationException("Entidade com id " + id + " não existe.", 404);

        dao.deleteById(id);

        Log.info("Funcionalidade com id " + id + " excluída!");

        return Response.status(204).build();
    }


}
