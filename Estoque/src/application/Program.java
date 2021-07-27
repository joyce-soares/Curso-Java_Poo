package application;

/*

Programa que faz operações simples de estoque como:
Adicionar e remover produtos.
Mostrar quantidade em estoque.
Projeto em java usando programação orientada a objetos.

*/
import entities.Product;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product product = new Product();
        System.out.print("Enter product data:\nNome: ");
        product.name = sc.nextLine();
        System.out.print("Price: $");
        product.price = sc.nextDouble();
        System.out.print("Quantity: ");
        product.quantity = sc.nextInt();

        System.out.println("\nProduct data: " + product);
        System.out.println("\nEnter the number of products to be added in stock: ");
        int quantity = sc.nextInt();

        product.addProducts(quantity);
        System.out.println("\nUpdate data: \n" + product);

        System.out.println("Enter the number of products to be removed from stock: ");
        quantity = sc.nextInt();

        product.removeProducts(quantity);
        System.out.println("\nUpdate data: \n" + product);


        sc.close();

    }
}
