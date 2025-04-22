package CC_Collections;

import java.util.ArrayList;
import java.util.HashMap;

class InventoryItem {
    private int id;
    private String name;
    private double price;
    private String department;
    public InventoryItem(int id, String name, double price, String department) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.department = department;
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
    public String getDepartment() {
        return this.department;
    }
}
public class Products {
    public static void main(String[] args) {
        HashMap<String, ArrayList<InventoryItem>> departments = new HashMap<String, ArrayList<InventoryItem>>();

        //INPUT
        ArrayList<InventoryItem> assorted = new ArrayList<InventoryItem>();
        assorted.add(new InventoryItem(111,"carmel", 0.99, "Candy"));
        assorted.add(new InventoryItem(111,"pencil", 0.99, "Office Supplies"));
        assorted.add(new InventoryItem(222,"paper", 12.99, "Office Supplies"));
        assorted.add(new InventoryItem(333,"mouse", 29.99, "Computer Accessories"));
        assorted.add(new InventoryItem(111,"ruler", 0.99, "Office Supplies"));
        assorted.add(new InventoryItem(222,"eraser", 12.99, "Office Supplies"));
        assorted.add(new InventoryItem(333,"keyboard", 29.99, "Computer Accessories"));

        // CATEGORIZE - GROUP BY DEPARTMENT NAME
        for(InventoryItem item : assorted){
            String departmentName = item.getDepartment();
            if(!departments.containsKey(departmentName)){ //Have we heard of this department?
                //NO? Cool, we'll create a new empty list under that department's name.
                departments.put(departmentName, new ArrayList<InventoryItem>() );
            }
            departments.get(departmentName).add(item); // add to this specific department's list
        }

        //OUTPUT
        for(String departmentName : departments.keySet()){
            System.out.println(departmentName.toUpperCase());
            ArrayList<InventoryItem> departmentItems = departments.get(departmentName);
            for(InventoryItem item : departmentItems){
                System.out.println("\t" + item.getName());
            }
        }
    }
}
