package rest.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;

/**
 * Created by redline on 19.11.16.
 */

class BaseRestController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

}
