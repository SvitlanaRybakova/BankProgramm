package com.company;

public class BankAccountFactory {

    public enum AccountType{
        SALARY,
        SAVINGS,
        INVESTMENT,
        LOAN
    }

    public static Account createAccount(AccountType accountType){
        switch(accountType){
            case SALARY:
                return new SalaryAccount(100);
            case SAVINGS:
                return new SavingsAccount(1.5);
            case INVESTMENT:
                return new InvestmentAccount();
            case LOAN: //TODO: implement later...
            default:
                View.getInstance().showErrorMessage("Could not create account of type:"+accountType.toString());
                return null;
        }

    }
}
