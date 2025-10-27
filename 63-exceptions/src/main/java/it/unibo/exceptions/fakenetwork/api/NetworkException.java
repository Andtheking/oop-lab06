package it.unibo.exceptions.fakenetwork.api;

import java.io.IOException;
/* 
 * Create a `NetworkException extends IOException` with two constructors.
 * The 0-ary constructor must create an Exception whose message is "Network error: no response".
 * The 1-ary constructor must take a String as input, and create a message "Network error while sending message: <message>" 
 */
public class NetworkException extends IOException {
    public NetworkException() {
        super("Network error: no response");
    }

    public NetworkException(String message) {
        super("Network error while sending message: "+message);
    }
}
