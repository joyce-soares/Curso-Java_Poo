package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        int numberContract = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        double contractValue = sc.nextDouble();

        Contract contract = new Contract(numberContract, date, contractValue);

        System.out.print("Enter number of installments: ");
        int installment = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());
        cs.processContract(contract, installment);

        System.out.println("Installments:");
        for(Installment it : contract.getInstallments()){
            System.out.println(it);

        }
        sc.close();
    }
}
