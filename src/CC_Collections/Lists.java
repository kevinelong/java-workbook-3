package CC_Collections;

import java.util.ArrayList;

public class Lists {
    public static void main(String[] args) {
        ArrayList<String> kids = new ArrayList<String>();
        kids.add("Natalie");
        kids.add("Brittany");
        kids.add("Zachary");

        System.out.println("Before Brittany removed: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(i  + " : " + kids.get(i));
        }

        kids.remove(1);
        System.out.println("After Brittany removed: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(i + " : " + kids.get(i));
        }

        kids.add("Brittany");
        System.out.println("After Brittany re-added: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(i + " : " + kids.get(i));
        }

        //insert between 1st and 2nd at index 1
        kids.add(1, "Aaron");
        System.out.println("After Brittany re-added: ");
        for (int i = 0; i < kids.size(); i++) {
            System.out.println(i + " : " + kids.get(i));
        }
    }
}