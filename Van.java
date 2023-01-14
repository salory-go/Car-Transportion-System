import java.util.Scanner;

public class Van extends Vehicle {
    String purpose;
    Van(){}
    Van(String type,String rego,String purpose){
        this.type = type;//设定类型
        this.rego = rego;
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return type+","+rego+","+purpose;
    }
    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){

    }
}
