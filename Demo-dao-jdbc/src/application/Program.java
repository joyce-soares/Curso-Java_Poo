package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        //procurar no banco por um determinado Id
        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        //procurar no banco por um determinado Departamento
        System.out.println("\n=== TEST 2 seller findByDepartment ===");
        Department dp = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(dp);
        for(Seller obj : list){
            System.out.println(obj);
        }

        //procurar no banco todos sem restriçao
        System.out.println("\n=== TEST 3 seller findAll ===");
        list = sellerDao.findAll();
        for(Seller obj : list){
            System.out.println(obj);
        }

    }
}
