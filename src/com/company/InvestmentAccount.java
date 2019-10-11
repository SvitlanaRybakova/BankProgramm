package com.company;

public class InvestmentAccount extends Account{

    public InvestmentAccount() {
        super(0);
    }

    @Override
    public void showInfo() {
        System.out.println("InvestmentAccount, balance: "+getBalance());
    }
}
