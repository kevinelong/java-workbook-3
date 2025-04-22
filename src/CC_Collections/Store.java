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
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
// this method loads product objects into inventory
// and its details are not shown
        inventory.add(new Product(111,"pencil",0.99));
        inventory.add(new Product(222,"paper",12.99));


        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream("inventory.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split("\\|");
            inventory.add(new Product(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    Double.parseDouble(parts[2])
            ));
        }
        scanner.close();
        return inventory;
    }
}