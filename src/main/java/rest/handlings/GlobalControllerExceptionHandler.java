package rest.handlings;

import rest.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by redline on 19.11.16.
 */
@ControllerAdvice
@RestController
class GlobalControllerExceptionHandler extends RuntimeException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleConflict() {
       return new Error(404, "Not found page");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class })
    public Error handleConflict500() {
        return new Error(500, "Internal server error");
    }

//
//
//    @ExceptionHandler(value = Exception.class)
//    @RequestMapping(value = Path.ERROR, produces = "text/json")
//    public Error error() {
//        return new Error(404, "M");
//    }


}