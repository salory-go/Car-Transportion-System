import java.util.ArrayList;
import java.util.Scanner;

public class Trip implements MyIO{
    int tripNumber;
    String tripDate;
    int eNumber;
    String rego;
    ArrayList<TripLeg> tripLegs = new ArrayList<>();

    Trip(){}
    Trip(int tripNumber,String tripDate,int eNumber,String rego){
        this.tripNumber = tripNumber;
        this.tripDate = tripDate;
        this.eNumber = eNumber;
        this.rego = rego;
    }

    public int getNumber() {
        return eNumber;
    }

    public String getDate() {
        return tripDate;
    }

    @Override
    public String toString() {
        //根据打印的要求，在打印TripLeg对象时需要循环，则将打印内容先保存在字符串str中，再加在return语句里
        String str=tripLegs.size()+"\n";
        int i=1;
        for (TripLeg t : tripLegs) {
            str+=i+","+t.departure+","+t.destination+"\n";
            i++;
        }
        return tripNumber+","+tripDate+","+eNumber+","+rego+"\n"+str;
    }
    public void readData(Scanner sc){
    }
    public void writeData(Scanner sc){
    }
}
