package com.qaprosoft.carina.demo.gui.hasiuk.exceptions;

public class WrongDataException extends Exception{
    public WrongDataException() {
        this("Unknown data format");
    }

    public WrongDataException(String message) {
        super(message);
    }
}
