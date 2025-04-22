package ExceptionsAndReading;

import java.io.*;
import java.io.IOException;

public class D_PayrollCalculator {
    public static void main(String[] args) {
        try {
            // create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");
// create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
// read until there is no more data
            while ((input = bufReader.readLine()) != null) {
                System.out.println(input);
            }
// close the stream and release the resources
            bufReader.close();
        } catch (
                IOException e) {
// display stack trace if there was an error
            e.printStackTrace();
        }
    }
}