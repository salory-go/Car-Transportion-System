import java.util.Scanner;

public class Mechanic extends Employee{
    int eNumber;
    String fname;
    String lname;
    String dob;
    String address;
    String experience;
    String ch;//设定类型
    String qualNum;
    int postcode;

    Mechanic(){}

    Mechanic(String ch, int eNumber, String fname, String lname, String dob,String address,int postcode,String qualNum,String experience){
        this.ch = ch;
        this.eNumber = eNumber;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.address = address;
        this.postcode = postcode;
        this.qualNum = qualNum;
        this.experience = experience;
    }

    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){

    }

    @Override
    public String toString() {
        return ch+","+eNumber+","+fname+","+lname+","+dob+","+address+","+postcode+","+qualNum+","+experience;
    }
}
