package com.company;

import java.util.ArrayList;

public class BankProgram {

    ArrayList<Account> accounts = new ArrayList<>();

    public BankProgram(){

    }

    public void start(){

        for (BankAccountFactory.AccountType sveta : BankAccountFactory.AccountType.values()){
            Account account1 = BankAccountFactory.createAccount(sveta);
            if (account1 != null)
                accounts.add(account1);
        }
        //создание объекта
        View sveta = View.getInstance();// нужен что бы у нас ьыл 1 объект, если он уже был создан то View.getInstance() вернет уже существующий

        View.MenuItem menuItem;

        do{
            menuItem = sveta.showMenuAndGetChoice();// инициализация menuItem, showMenuAndGetChoice() возвращает выбор меню от пользователя
            switch (menuItem){
                case ADD_SALARY_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.SALARY);
                    break;
                case ADD_SAVINGS_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.SAVINGS);
                    break;
                case ADD_INVESTMENT_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.INVESTMENT);
                    break;
                case ADD_LOAN_ACCOUNT:
                    addAccount(BankAccountFactory.AccountType.LOAN);
                    break;
                case LOAD_FROM_FILE:
                    accounts = (ArrayList<Account>)FileUtils.readObject("accounts.ser");
                    break;
                case SAVE_TO_FILE:
                    FileUtils.writeObject("accounts.ser",accounts);
                    break;
                case SHOW_ACCOUNTS:
                    showAccounts();
                    break;
                case QUIT:
                    break;
                default:
                    sveta.showErrorMessage("No such menuitem: "+menuItem.toString());
            }

        }while(menuItem != View.MenuItem.QUIT);

    }

    private void addAccount(BankAccountFactory.AccountType accountType){
        Account account = BankAccountFactory.createAccount(accountType);
        if (account != null){
            accounts.add(account);
        }
    }

    private void showAccounts(){
        //System.out.println(accounts.size());
        for(Account account : accounts){
            account.showInfo();
        }
    }

}
