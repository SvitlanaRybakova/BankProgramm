package com.company;

import java.io.Serializable;

public abstract class Account implements Serializable {

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public abstract void showInfo();
}
