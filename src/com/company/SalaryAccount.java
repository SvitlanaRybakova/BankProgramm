package com.company;

public class SalaryAccount extends Account{


    public SalaryAccount(int balance) {
        super(balance);
    }

    @Override
    public void showInfo() {
        System.out.println("SalaryAccount, balance: "+getBalance());
    }
}

