package AA_ExceptionsAndReading;
import java.io.*;

//    Create an Employee class as described below:
class Employee{

    //    Private data members (attributes):
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    //CONSTRUCTOR
//    Methods (function members):
//            - parameterized constructor
    Employee(int id, String name, double hours, double rate){
        this.employeeId = id;
        this.name = name;
        this.hoursWorked = hours;
        this.payRate = rate;
    }

    public String toString(){
        return String.format("%d=%s", this.employeeId, this.name); //end format
    }
    public String toLongString(){
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
    int getEmployeeId(){
        return this.employeeId;
    }

    //- getGrossPay() that calculates and returns that employee's gross pay
    //    based on their hours worked and pay rate
    double getGrossPay(){
        return this.payRate * this.hoursWorked;
    }
}


public class D_PayrollCalculator {
    public static void main(String[] args) {
        try
        {
// create a FileReader object connected to the File
            FileReader fileReader = new FileReader("employees.csv");
// create a BufferedReader to manage input stream
            BufferedReader bufReader = new BufferedReader(fileReader);
            String input;
// read until there is no more data
            int number = 0;
            while((input = bufReader.readLine()) != null) {
                if(number++ == 0){
                    continue; //skip
                }
                //System.out.println(input);
                String[] parts = input.split("\\|");

                int id = Integer.parseInt( parts[0] );
                String name = parts[1];
                double hours = Double.parseDouble( parts[2] );
                double rate = Double.parseDouble( parts[3] );

                Employee e = new Employee(id, name, hours, rate);
                System.out.println(e.toLongString());
            }
// close the stream and release the resources
            bufReader.close();
        }
        catch(IOException e) {
// display stack trace if there was an error
            e.printStackTrace();
        }
    }
}