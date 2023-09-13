package service;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile {
    private String fileName;

    public ReadWriteFile() {}

    public void writeFile(List<Product> products) {
        try {
            File fileProduct = new File("ProductFile.csv");
            BufferedWriter brProduct = new BufferedWriter(new FileWriter(fileProduct));
            for (Product product : products) {
                brProduct.write(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "," + product.getDescription());
                brProduct.newLine();
            }
            brProduct.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readFile(String fileName) {
        List<String[]> list = new ArrayList<>();
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line.split(","));
            }
        } catch (IOException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return list;
    }
}
