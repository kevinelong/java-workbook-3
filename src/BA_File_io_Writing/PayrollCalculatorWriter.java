package BA_File_io_Writing;

import java.io.*;
import java.util.Scanner;


//    Create an Employee class as described below:
class Employee {

    //    Private data members (attributes):
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    //CONSTRUCTOR
//    Methods (function members):
//            - parameterized constructor
    Employee(int id, String name, double hours, double rate) {
        this.employeeId = id;
        this.name = name;
        this.hoursWorked = hours;
        this.payRate = rate;
    }

    public String toString() {
        return String.format("%d=%s", this.employeeId, this.name); //end format
    }

    public String toLongString() {
        return String.format(
                "%d \"%s\" %.2f(hours) @ $%.2f = $%.2f",
                this.employeeId,
                this.name,
                this.hoursWorked,
                this.payRate,
                this.getGrossPay()
        ); //end format
    }

    //- getEmployeeId() and getters/setters for other attributes
    int getEmployeeId() {
        return this.employeeId;
    }

    //- getGrossPay() that calculates and returns that employee's gross pay
    //    based on their hours worked and pay rate
    double getGrossPay() {
        return this.payRate * this.hoursWorked;
    }
}

public class PayrollCalculatorWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("\nEmployees Input File Name e.g. employees.csv: ");
        String inputFilename = in.nextLine().trim();
        if (inputFilename.isEmpty()) {
            inputFilename = "employees.csv";
        }

        System.out.print("\nPayroll Output File Name e.g. payroll.csv: ");
        String outputFileName = in.nextLine().trim();
        if (outputFileName.isEmpty()) {
            outputFileName = "payroll.csv";
        }

        try {
// create a FileReader object connected to the File
            FileReader fileReader = new FileReader(inputFilename);
// create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;

            // create a FileWriter
            FileWriter fileWriter = new FileWriter(outputFileName);
            // create a BufferedWriter
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
            bufWriter.write("id|name|gross pay\n");
// read until there is no more data
            int number = 0;
            while ((input = bufReader.readLine()) != null) {
                if (number++ == 0) {
                    continue; //skip
                }
                //System.out.println(input);
                String[] parts = input.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);

                Employee e = new Employee(id, name, hours, rate);
                bufWriter.write(String.format("%d|%s|%.2f\n", e.employeeId, e.name, e.getGrossPay()));
            }//end while
// close the stream and release the resources
            bufReader.close();
            bufWriter.close();
            System.out.printf("\nOutput Complete. %d lines written to: %s\n", number, outputFileName);
        } catch (IOException e) {
// display stack trace if there was an error
            e.printStackTrace();
        }
    }
}