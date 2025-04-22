package CC_Collections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}

public class Store {
    public static void main(String[] args) throws FileNotFoundException {
        /// INPUT ///
        ArrayList<Product> inventory = new ArrayList<Product>();
        inventory.add(new Product(111,"pencil",0.99));
        inventory.add(new Product(222,"paper",12.99));
        FileInputStream fis = new FileInputStream("inventory.csv");
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split("\\|");
            inventory.add(new Product(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Double.parseDouble(parts[2])
            ));
        }
        scanner.close();

        /// OUTPUT ////////////////////////////////////////////
        String sought = "am";
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            if(p.getName().contains(sought)) {
                System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
            }
        }
    }
}