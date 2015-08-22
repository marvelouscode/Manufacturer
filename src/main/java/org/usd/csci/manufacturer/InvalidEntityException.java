package org.usd.csci.manufacturer;

/**
 * Class to be thrown when an error occurs when during the session.
 *
 * @author Joseph Mammo
 */
public class InvalidEntityException extends Exception {
    /**
     * Default Constructor
     */
    public InvalidEntityException() {

    }
    /**
     * Constructor InvalidEntityException with the specified detail message
     * @param msg 
     */
    public InvalidEntityException(String msg) {
        super(msg);
    }
}
