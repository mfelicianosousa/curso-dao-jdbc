package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class App {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
	    SellerDao sellerDao = DaoFactory.createSellerDao();

	    System.out.println("=== Test1: seller findById ====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
	    System.out.println("\n=== Test2: seller findByDepartment ====");
	    
	    Department department = new Department(2, null);
	    
	    List<Seller> list = sellerDao.findByDepartment(department);
	    for (Seller obj : list) {
	    	System.out.println(obj);
	    }
	    
	    System.out.println("\n=== Test3: seller findByAll ====");
	    list = sellerDao.findAll();
	    for (Seller obj : list) {
	    	System.out.println(obj);
	    }
	
	    
	    System.out.println("\n=== Test4: seller insert ====");
	    Seller newSeller = new Seller(0, "Frida", "frida@gmail.com", new Date(), 3500.0, department );
	    sellerDao.insert(newSeller);
	    System.out.println("Inserted! New id = "+newSeller.getId());
	    
	    
	    System.out.println("\n=== Test5: seller update ====");
	    // old name Bob Brown
	    seller = sellerDao.findById(1);
	    seller.setName("Marta Waine");
	    
	    sellerDao.update(seller) ;
	    System.out.println("Update completed! ");
	    
	    System.out.println("\n=== Test5: seller update ====");
	    System.out.println("Enter id for delete test: ");
	    int id = sc.nextInt();
	    sellerDao.deleteById(id);
	    System.out.println("Delete completed! ");
	    sc.close();
	    
	}
}
