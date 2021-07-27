package application;
/*
Projeto de um banco, cria uma nova conta, faz depósito e saque.
Aplicando conceitos de encapsulamento e sobrecarga em orientação
a objetos com java.
 */
import entities.Account;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Account account;

        System.out.print("Enter account number: ");
        int number = sc.nextInt();

        System.out.println("Enter account holder: ");
        sc.nextLine();
        String holder = sc.nextLine();

        System.out.println("Is there na initial deposit (y/n)? ");
        char option = sc.next().charAt(0);


        if (option == 'y'){
            System.out.println("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(number, holder, initialDeposit);
        }
        else {
            account = new Account(number, holder);
        }
        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account.toString());

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double deposit = sc.nextDouble();

        account.depositValue(deposit);

        System.out.println("Update account data: ");
        System.out.println(account);

        System.out.println();
        System.out.println("Enter a withdraw value: ");
        double withdraw = sc.nextDouble();

        account.withdrawValue(withdraw);

        System.out.println("Update account data: ");
        System.out.println(account);

        sc.close();

    }
}
