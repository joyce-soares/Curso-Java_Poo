package application;

public class Employee {
    public String name;
    public double grossSalary;
    public double tax;

    public double netSalary(){
       return grossSalary - tax;
    }

    public void increaseSalary(double percentage){
        double increase = (grossSalary * (percentage / 100));
        double newSalary = (grossSalary + increase) - tax;
        System.out.printf("\nUpdate data: %s, $%.2f", name, newSalary );
    }
}
