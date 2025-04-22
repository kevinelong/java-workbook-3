package ExceptionsAndReading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class C_BedtimeStories {
    public static void main(String[] args) {
        System.out.println("""
Enter the name of a story (e.g. 
    "goldilocks.txt", 
    "hansel_and_gretel.txt", 
    or "mary_had_a_little_lamb.txt"
):""");
        Scanner in = new Scanner(System.in);
        String story = in.nextLine().trim();
        try {
// create a FileInputStream object pointing to
// a specific file
            FileInputStream fis = new FileInputStream(story);
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
/*
Enter the name of a story: goldilocks.txt
1. Goldilocks and the Three Bears
2.
3. Once upon a time a girl named Goldilocks lived in
4. a house at the edge of the woods. In those days
5. curls of hair were called "locks." She was
6. "Goldilocks" because golden hair ran down her head
7. and shoulders.
 */