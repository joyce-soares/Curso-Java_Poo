package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();


       //inserindo no banco um departamento
        System.out.println("\n=== TEST 1 department insert ===");
        Department newDepartment = new Department(null, "Drinks");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        //fazendo update em departamento no banco
        System.out.println("\n=== TEST 2 department update ===");
        Department department = departmentDao.findById(4);
        department.setName("Cosmetics");
        departmentDao.update(department);
        System.out.println("Update Completed!!");

        //fazendo delete de departamento no banco
        System.out.println("\n=== TEST 3 department delete ===");
        departmentDao.deleteById(11);
        System.out.println("Delete Completed!!");

        //procurando no banco por um determinado Id
        System.out.println("=== TEST 4: department findById ===");
        newDepartment = departmentDao.findById(3);
        System.out.println(newDepartment);


        System.out.println("\n=== TEST 4 department findAll ===");
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        List<Department> list = departmentDao.findAll();
        for(Department obj : list){
            System.out.println(obj);
        }

    }
}
