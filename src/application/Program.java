package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
        public static void main(String[] args) {
            Department obj = new Department(1,"books");
            Seller seller = new Seller(21, "bob", "bob@", new Date(),1000.0,"2");
            System.out.println(obj);
            System.out.println(seller);
        }
}
