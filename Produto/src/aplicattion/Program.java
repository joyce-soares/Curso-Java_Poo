package aplicattion;

import entities.ImportedProdutc;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Product> list = new ArrayList<>();


        System.out.print("Enter the number of products:");
        int n = sc.nextInt();
        for(int i = 1; i <=n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char op = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if(op == 'i'){
                System.out.println("Customs fee: ");
                double costumeFee = sc.nextDouble();
                list.add(new ImportedProdutc(name, price, costumeFee));
            }else if(op == 'u'){
                System.out.println("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                list.add(new UsedProduct(name, price, manufactureDate));
            }else{
                list.add(new Product(name,price));
            }
        }

        for (Product product : list){
            System.out.println(product.priceTag());
        }


    }
}
