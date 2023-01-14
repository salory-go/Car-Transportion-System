import java.util.Scanner;

public class Truck extends Vehicle {
    double capacity;
    double weight;
    Truck(){}
    Truck(String type,String rego,double capacity,double weight){
        this.type = type;
        this.rego = rego;
        this.capacity = capacity;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return type+","+rego+","+capacity+","+ weight;
    }
    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){

    }
}
