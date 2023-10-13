package com.ppc.user.servcie.UserService.exceptions;

public class ResoruceNotFoundException extends RuntimeException{
    public ResoruceNotFoundException()
    {
        super("Resource not found on server!! ");
    }

    public ResoruceNotFoundException(String message) {
        super(message);
    }
}
