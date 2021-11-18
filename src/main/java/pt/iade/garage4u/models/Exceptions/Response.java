package pt.iade.garage4u.models.Exceptions;

public class Response {
    private final String message;
    private final Object object;

    public Response(String message, Object object){
        this.message = message;
        this.object = object;
    }

    public String getMessage() {return message; }

    public Object getobject()  {return object;  }

}