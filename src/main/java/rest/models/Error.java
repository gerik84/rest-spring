package rest.models;

/**
 * Created by redline on 19.11.16.
 */
public class Error {

    public int code;
    public String message;

    public Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
