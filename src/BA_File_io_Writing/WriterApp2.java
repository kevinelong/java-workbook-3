package File_io_Writing;
import java.io.*;
public class WriterApp2 {
    public static void main(String args[]) {
        try {
// create a FileWriter
            FileWriter fileWriter = new FileWriter("text.txt");
// create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
// write to the file
            String text;
            for(int i = 1; i <= 10; i++) {
                text = String.format("Counting %d\n", i);
                bufWriter.write(text);
            }
// close the writer
            bufWriter.close();
        }
        catch (IOException e) {
            System.out.println("ERROR: An unexpected error occurred");
            e.getStackTrace();
        }
    }
}