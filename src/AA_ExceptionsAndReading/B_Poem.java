package ExceptionsAndReading;

import java.io.*;
import java.util.Scanner;

public class B_Poem {
    public static void main(String[] args) {
        try {
// create a FileInputStream object pointing to
// a specific file
            FileInputStream fis = new FileInputStream("poem.txt");
// create a Scanner to reference the file to be read
            Scanner scanner = new Scanner(fis);
            String input;
// read until there is no more data
            while (scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println(input);
            }
// close the scanner and release the resources
            scanner.close();
        } catch (IOException e) {
// display stack trace if there was an error
            e.printStackTrace();
        }
    }
}