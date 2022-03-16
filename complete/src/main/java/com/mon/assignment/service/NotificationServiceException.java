package com.mon.assignment.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;
@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
public class NotificationServiceException extends RuntimeException {


    public NotificationServiceException() {
        super();
    }

    public NotificationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotificationServiceException(String message) {
        super(message);
    }

    public NotificationServiceException(Throwable cause) {
        super(cause);
    }

}
