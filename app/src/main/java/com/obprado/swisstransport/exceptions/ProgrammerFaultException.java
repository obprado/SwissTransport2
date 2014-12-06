package com.obprado.swisstransport.exceptions;

/**
 * Created by omar on 06/12/2014.
 */
public class ProgrammerFaultException extends RuntimeException{

    public ProgrammerFaultException(Throwable throwable) {
        super(throwable);
    }
}
