package com.galactice.Galactics.exception;


public class DuplicateSatelliteException extends RuntimeException {
    public DuplicateSatelliteException(String message) {
        super(message); // Allows calling e.getMessage()
    }
}
