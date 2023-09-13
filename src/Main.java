import controller.Menu;
import service.ProductManage;
import service.ReadWriteFile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu(new Scanner(System.in), new ProductManage(), new ReadWriteFile());
    }
}
