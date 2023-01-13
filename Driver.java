import java.util.Scanner;

public class Driver extends Employee {
    int eNumber;
    String fname;
    String lname;
    String dob;
    String address;
    String status;
    String ch;//设定类型
    int licence;
    int postcode;
    Driver(){}
    Driver(String ch, int eNumber, String fname, String lname, String dob,String address,int postcode,int licence,String status){
        this.ch = ch;
        this.eNumber = eNumber;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
        this.licence = licence;
        this.status = status;
    }

    public void readData(Scanner sc){}
    public void writeData(Scanner sc){}

    @Override
    public String toString() {
        return ch+","+eNumber+","+fname+","+lname+","+dob+","+address+","+postcode+","+licence+","+status;
    }

}
