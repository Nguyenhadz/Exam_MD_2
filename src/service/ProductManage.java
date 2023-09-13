package service;

import model.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    private List<Product> products;
    private final Scanner scanner;

    public ProductManage() {
        products = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    public void changeIndexProduct() {
        Product.INDEX = products.get(products.size() -1).getId();
    }

    public void loadListProduct(List<String[]> productList) {
        for (String[] string : productList) {
            String name = string[1];
            double price = Double.parseDouble(string[2]);
            int quantity = Integer.parseInt(string[3]);
            String description = string[4];
            Product product = new Product(name, price, quantity, description);
            products.add(product);
        }
        if (!products.isEmpty()) {
            changeIndexProduct();
        }
    }

    public void creatProduct() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        double price = ExceptionManager.exceptionPrice();
        int quantity = ExceptionManager.exceptionQuantity();
        System.out.println("Enter description: ");
        String description = scanner.nextLine();
        products.add(new Product(name, price, quantity, description));
    }

    public Product findById() {
        System.out.println("Enter Id you want: ");
        int id = Integer.parseInt((scanner.nextLine()));

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void updateProduct() {
        if (!products.isEmpty()) {
            displayProduct();
            Product product = findById();
            if (product != null) {
                System.out.println("Enter new name: ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) {
                    product.setName(name);
                }

                double price = ExceptionManager.exceptionPrice();
                product.setPrice(price);

                int quantity = ExceptionManager.exceptionQuantity();
                product.setQuantity(quantity);

                System.out.println("Enter new description: ");
                String description = scanner.nextLine();
                if (!description.isEmpty()) {
                    product.setDescription(description);
                }
                System.out.println("Edit successfully!!!");
            } else {
                System.out.println("Product not exist!!!");
            }
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public void deleteProduct() {
        if (!products.isEmpty()) {
            displayProduct();
            Product product = findById();
            if (product != null) {
                System.out.println("Enter 1 to delete.");
                int choice = ExceptionManager.exceptionChoice();
                if (choice == 1) {
                    products.remove(product);
                    System.out.println("Remove successfully");
                }

            } else {
                System.out.println("Product not exist!!!");
            }
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public void sortPriceAsc() {
        if (!products.isEmpty()) {
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o1.getPrice() - o2.getPrice());
                }
            });
            System.out.println("Sort successfully");
        } else {
            System.out.println("Product not exist!!!");
        }
    }

    public void sortPriceDesc() {
        if (!products.isEmpty()){
            products.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return (int) (o2.getPrice() - o1.getPrice());
                }
            });
            System.out.println("Sort successfully");
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public Product findPriceMax() {
        if (!products.isEmpty()) {
            double priceMax = products.get(0).getPrice();
            int indexMax = 0;
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getPrice() >priceMax) {
                    priceMax = products.get(i).getPrice();
                    indexMax = i;
                }
            }
            return products.get(indexMax);
        } else {
            System.out.println("Product not exist!!!");
        }
        return null;
    }

    public void displayProduct() {
        if (!products.isEmpty()) {
            for (Product product : products) {
                System.out.println(product);
            }
        } else {
            System.out.println("Product not exist!!!");
        }

    }

    public List<Product> listProduct() {
        return products;
    }

}