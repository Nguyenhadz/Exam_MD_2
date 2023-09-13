package controller;

import service.ProductManage;
import service.ReadWriteFile;

import java.util.Scanner;

public class Menu {
    public void menu(Scanner scanner, ProductManage productManage, ReadWriteFile readWriteFile) {
        productManage.loadListProduct(readWriteFile.readFile("ProductFile.csv"));
        do {
            System.out.println("MENU: ");
            System.out.println("1.Display all product.");
            System.out.println("2.Add product.");
            System.out.println("3.Edit product.");
            System.out.println("4.Remove product.");
            System.out.println("5.Sort products by ascending price.");
            System.out.println("6.Sort products by descending price.");
            System.out.println("7.Show the most expensive products.");
            System.out.println("0.Exist!!!");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayProduct();
                    break;
                case 2:
                    productManage.creatProduct();
                    break;
                case 3:
                    productManage.updateProduct();
                    break;
                case 4:
                    productManage.deleteProduct();
                    break;
                case 5:
                    productManage.sortPriceAsc();
                    break;
                case 6:
                    productManage.sortPriceDesc();
                    break;
                case 7:
                    System.out.println(productManage.findPriceMax());;
                    break;
                case 0:
                    readWriteFile.writeFile(productManage.listProduct());
                    System.exit(0);
            }
        } while (true);


    }
}
