package aplicattion;

import entities.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("How many employees will be registered?");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.printf("Emplyoee #%d:\nId:\n", i + 1);
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.println("Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(name, salary, id);
            list.add(emp);
            System.out.println();

        }
        System.out.print("Enter the employee id that will have salary increase: ");
        int idIncrease = sc.nextInt();

        /*
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        --Uma outra forma de verificar se o id já existe ou não.--
        */

        Integer pos = positionId(list,idIncrease);
        if(pos == null){
            System.out.println("This id does not exist! ");
        }else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            list.get(pos).increaseSalary(percentage);
        }
        System.out.println();
        System.out.println("List of employees: ");
        for (Employee emp : list) {
            System.out.println(emp);
        }

         sc.close();
    }
    static Integer positionId(List<Employee> list, int id){
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return null;
    }

}
