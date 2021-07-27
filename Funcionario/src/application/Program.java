package application;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Employee employee = new Employee();

        System.out.print("Name: ");
        employee.name = sc.nextLine();
        System.out.println("Gross salary: ");
        employee.grossSalary = sc.nextDouble();
        System.out.println("Tax: ");
        employee.tax = sc.nextDouble();

        double netSalary = employee.netSalary();
        System.out.printf("\nEmployee: %s, $%.2f", employee.name, employee.netSalary());

        System.out.println("\nWhich percentage to increase salary? ");
        double percentage = sc.nextDouble();
        employee.increaseSalary(percentage);




    }
}
