package ExceptionsAndReading;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class A_Kids {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            String[] names = {
                    "Ezra", "Elisha", "Ian",
                    "Siddalee", "Pursalane", "Zephaniah"
            };
            System.out.print("Pick a kid (select #1 - #6): ");
            int index = scanner.nextInt();
            index--; // change number from range 1-6 to range 0-5
// as long as the user entered a number in the range
// of 1 to 6, this will work. Otherwise the index
// will be out of range.
            System.out.println(names[index]);
        }
        catch (Exception e) {
            System.out.println("Your number was out of range!");
            e.printStackTrace();
        }
        scanner.close();
    }
}
/*
TRANSCRIPT OF TERMINAL SESSION
Pick a kid (select #1 - #6): 12
Your number was out of range!
 */