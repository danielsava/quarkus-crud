package quarkus.crud.base.mapper;

public record ErrorWebResponse(String exceptionType, Integer code, String message) {

    public static ErrorWebResponse of(String exceptionType, Integer code, String message) {

        return new ErrorWebResponse(exceptionType, code, message);
    }
}
