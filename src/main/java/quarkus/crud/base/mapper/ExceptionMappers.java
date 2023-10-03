package quarkus.crud.base.mapper;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;


@Provider
public class ExceptionMappers {

    @ServerExceptionMapper
    public RestResponse<ErrorWebResponse> mapException(WebApplicationException e) {

        int code = e.getResponse().getStatus();

        Response.Status status = Response.Status.fromStatusCode(code);
        String exceptionType = e.getClass().getName();
        String message = e.getMessage();

        ErrorWebResponse error = ErrorWebResponse.of(exceptionType, code, message);

        return RestResponse.status(status, error);
    }

}
