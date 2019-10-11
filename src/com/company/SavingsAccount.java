package com.company;

public class SavingsAccount extends Account {

    private double interestRate;

    public SavingsAccount(double interestRate) {
        super(0);
        this.interestRate = interestRate;
    }

    @Override
    public void showInfo() {
        System.out.println("SavingsAccount, balance: "+getBalance()+", interest rate:"+interestRate);
    }
}
