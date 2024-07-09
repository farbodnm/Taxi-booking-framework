package com.taxi.pay.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Controller class for handling custom error pages related to payment errors.
 * This class implements ErrorController to handle generic errors like 404 and 500.
 */
@Controller
public class PayErrorController implements ErrorController {

    /**
     * Handles errors and redirects to appropriate custom error pages based on the error status code.
     *
     * @param request the HttpServletRequest containing the error status code
     * @return the name of the custom error page to display
     */
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get error status code
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404"; // return custom error page for 404
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500"; // return custom error page for 500
            }
        }

        return "error"; // return generic error page
    }

}
