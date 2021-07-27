package aplication;

import entities.Rectangle;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rectangle rectangle = new Rectangle();

        System.out.println("Enter rectangle width and heigth: ");
        rectangle.width = sc.nextDouble();
        rectangle.height = sc.nextDouble();

        double area = rectangle.area();
        double perimeter = rectangle.perimeter();
        double diagonal = rectangle.diagonal();

        System.out.printf("AREA: %.2f\nPERIMETER: %.2f \nDIAGONAL: %.2f" ,  area , perimeter , diagonal);

    }
}
