import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

class Item{
    String name;
    Item(String name){
        this.name = name;
    }
}
public class Search {
    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<Item>();
        list.add(new Item("paper"));
        list.add(new Item("pencil"));
        list.add(new Item("armor"));
        list.add(new Item("shield"));
        list.add(new Item("sword"));

        System.out.println("What'ch lookin' for?");
        Scanner in = new Scanner(System.in);
        String sought = in.nextLine().trim();

        for(Item item : list){
            if(item.name.contains(sought)){
                System.out.println(item.name);
            }
        }
    }

}
