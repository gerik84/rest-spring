package rest.handlings;

import org.springframework.boot.autoconfigure.web.ErrorController;
import rest.config.Path;
import rest.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by redline on 19.11.16.
 */
@ControllerAdvice
@RestController
class GlobalControllerExceptionHandler extends RuntimeException implements ErrorController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, NullPointerException.class })
    public Error handleConflict500(NullPointerException e) {
        return new Error(500, e.getMessage());
    }

    @RequestMapping(Path.ERROR)
    public Error error() {
        return new Error(404, "Page not found");
    }

    @Override
    public String getErrorPath() {

        return Path.ERROR;
    }

}