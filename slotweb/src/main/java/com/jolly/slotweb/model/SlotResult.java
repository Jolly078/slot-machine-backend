package com.jolly.slotweb.model;

public class SlotResult {
    private String[] symbols;
    private int newBalance;
    private String message;

    public SlotResult(String[] symbols, int newBalance, String message) {
        this.symbols = symbols;
        this.newBalance = newBalance;
        this.message = message;
    }

    public String[] getSymbols() {
        return symbols;
    }

    public int getNewBalance() {
        return newBalance;
    }

    public String getMessage() {
        return message;
    }
}
