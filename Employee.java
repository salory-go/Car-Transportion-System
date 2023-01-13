import java.util.Scanner;

public class Employee implements MyIO{
    int eNumber;
    String fname;
    String lname;
    String dob;
    String address;

    Employee(){}

    public int geteNumber() {
        return eNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eNumber=" + eNumber +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dob='" + dob + '\'' +
                ", address='" + address + '\''  +
                '}';
    }
    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){
    }
}
