import java.util.Scanner;

public class Vehicle implements MyIO{
    String rego;
    String type; //设定类型

    Vehicle(){}

    @Override
    public String toString() {
        return "Vehicle{" +
                "rego='" + rego + '\'' +
                '}';
    }

    public String getRego() {
        return rego;
    }
    public void readData(Scanner sc){}
    public void writeData(Scanner sc){}
}
