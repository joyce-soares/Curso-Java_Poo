package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        //procurando no banco por um determinado Id
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        //procurando no banco por um determinado Departamento
        System.out.println("\n=== TEST 2 seller findByDepartment ===");
        Department dp = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dp);
        for(Seller obj : list){
            System.out.println(obj);
        }

        //procurando no banco todos sem restriçao
        System.out.println("\n=== TEST 3 seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

        //inserindo no banco
        System.out.println("\n=== TEST 4 seller insert ===");
        //java.sql.Date date = new java.sql.Date();
        Seller newSeller = new Seller(null, "Rafael", "rafael@gmail", new Date(), 4000.00, dp);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

    }
}
