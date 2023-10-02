package quarkus.crud.base.mapper;

import io.quarkus.logging.Log;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;


@Provider
public class ErrorMapper implements ExceptionMapper<Exception> {


    @Override
    public Response toResponse(Exception e) {

        int code = 500;

        if(e instanceof WebApplicationException)
            code = ((WebApplicationException) e).getResponse().getStatus();
        else
            Log.error("Erro inesperado", e);

        String exceptionType = e.getClass().getName();
        String message = e.getMessage();

        ErrorWebResponse error = ErrorWebResponse.of(exceptionType, code, message);

        return Response.status(code)
                .entity(error)
                .build();
    }
}
