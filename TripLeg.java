import java.util.Scanner;

public class TripLeg implements MyIO{
    int legNumber;
    String departure;
    String destination;
    TripLeg(){}
    TripLeg(int legNumber, String departure,String destination){
        this.legNumber = legNumber;
        this.departure = departure;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return legNumber+","+departure+","+destination;
    }
    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){

    }
}
