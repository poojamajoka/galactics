package com.galactice.Galactics.exception;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(String message) {
        super(message);
        System.out.println(">> Thrown SatelliteNotFoundException");
    }
}
