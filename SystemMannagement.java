import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SystemMannagement {
    static ArrayList<Employee> employees = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Trip> trips = new ArrayList<>();
    //设定退出循环的boolean变量
    static boolean flag = true;
    SystemMannagement(){}

    public static void main(String[] args) throws IOException {
        //循环主菜单
        while(flag){
            //在循环主菜单时增加延时时间
            try { TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ie){
                System.out.println("延时失败");
            }
            System.out.println("\n\n");
            System.out.println("1.   Load Data");
            System.out.println("2.   Display all employees");
            System.out.println("3.   Display all vehicles");
            System.out.println("4.   Display all trips");
            System.out.println("5.   Fina a employee");
            System.out.println("6.   Fina a vehicle");
            System.out.println("7.   Fina a trip");
            System.out.println("8.   Add a trip");
            System.out.println("9.   Save data");
            System.out.println("0.   Exit");
            System.out.println("\nPlease select one from the menu:");
            //主菜单输入选项
            Scanner sc = new Scanner(System.in);
            switch (sc.nextInt()){
                case 1:Load_data();break;
                case 2:Display_all_employees(); break;
                case 3:Display_all_vehicles();break;
                case 4:Display_all_trips();break;
                case 5:Fina_a_employee();break;
                case 6:Fina_a_vehicle();break;
                case 7:Fina_a_trip();break;
                case 8:Add_a_trip();break;
                case 9:Save_data();break;
                case 0:Exit();break;
                default:
                    System.out.println("Please input correct number!");
            }
        }
    }

    private static void Load_data() throws IOException {
        //打开文件
        FileReader file1 = new FileReader("vehicles.txt");
        FileReader file2= new FileReader("employees.txt");
        FileReader file3 = new FileReader("trips.txt");

        //用字符流打开文件
        BufferedReader reader1 = new BufferedReader(file1);
        BufferedReader reader2 = new BufferedReader(file2);
        BufferedReader reader3= new BufferedReader(file3);

        //先读，作为循环的条件
        String read = reader1.readLine();
        while(read!=null){
            //将读出的数据以“,”分割，再把分割的字符串作为参数构造车辆的对象
            String[] str = read.split(",");
            if(str[0].equals("T")){//先判断车辆的类型，在构造对象
                Truck T = new Truck(str[0],str[1],Double.parseDouble(str[2]),Double.parseDouble(str[3]));
                vehicles.add(T);//把对象加入静态集合中
            }
            else {
                Van V = new Van(str[0],str[1],str[2]);
                vehicles.add(V);//把对象加入静态集合中
            }
            read = reader1.readLine();//重复读取数据
        }
        System.out.println("Input vehicle file name :vehicles.txt\nLoad succeeds.");

        //先读，作为循环的条件
        read = reader2.readLine();
        while(read!=null){
            //将读出的数据以“,”分割，再把分割的字符串作为参数构造员工的对象
            String[] str = read.split(",");
            if(str[0].equals("D")){//先判断员工的类型，在构造对象
                Driver D = new Driver(str[0],Integer.parseInt(str[1]),str[2],str[3],str[4],str[5],Integer.parseInt(str[6]),Integer.parseInt(str[7]),str[8]);
                employees.add(D);//把对象加入静态集合中
            }
            else {
                Mechanic M = new Mechanic(str[0],Integer.parseInt(str[1]),str[2],str[3],str[4],str[5],Integer.parseInt(str[6]),str[7],str[8]);
                employees.add(M);//把对象加入静态集合中
            }
            read = reader2.readLine();//重复读取数据
        }
        System.out.println("Input employee file name :employees.txt\nLoad succeeds.");

        read = reader3.readLine();//先读，作为循环的条件
        while (read!=null){
            String[] str = read.split(",");//将读出的数据以“,”分割，再把分割的字符串作为参数构造行程的对象

            Trip T = new Trip(Integer.parseInt(str[0]),str[1],Integer.parseInt(str[2]),str[3]);
            //读入下一行数据，得出有多少个TripLeg对象，并把数据存储在read中
            read = reader3.readLine();
            int I = Integer.parseInt(read);

            for(int i=0;i<I;i++){//根据读到的数据确定循环次数
                read = reader3.readLine();
                String[] s = read.split(",");//将读出的数据以“,”分割，再把分割的字符串作为参数构造TripLeg的对象
                TripLeg t = new TripLeg(Integer.parseInt(s[0]),s[1],s[2]);
                T.tripLegs.add(t);//把对象加入构造好的Trip对象中
            }
            trips.add(T);//把对象加入静态集合中
            read = reader3.readLine();
        }
        System.out.println("Input trip file name :trips.txt\nLoad succeeds.");//打印完成的提示

        //关闭文件
        file1.close();
        file3.close();
        file2.close();
        reader1.close();
        reader2.close();
        reader3.close();

    }

    public static void Display_all_employees(){
        //循环打印对象
        for(Employee e:employees){
            System.out.println(e);
        }
    }

    public static void Display_all_vehicles(){
        //循环打印对象
        for(Vehicle v:vehicles){
            System.out.println(v);
        }
    }

    public static void Display_all_trips(){
        //循环打印对象
        for(Trip t:trips){
            System.out.print(t);
        }
    }

    public static void Fina_a_employee(){
        System.out.print("Please input the eNumber:");
        //键盘读取eNumber
        Scanner sc = new Scanner(System.in);
        String enumber = sc.nextLine();
        int number = Integer.parseInt(enumber);//将读入的字符串转为Int类型
        if(number>20){//员工号码不会超过20，以此为判断条件
            System.out.println("The employee does not exist.");
        }

        else {
            for(Employee e:employees){//循环遍历静态集合
                if(e.getClass().getName().equals("Driver")){//判断员工类型
                    Driver d = (Driver)e;//将对象employee强制转换成Driver
                    if(d.eNumber==number){
                        System.out.println(d);//打印寻找的员工
                        break;
                    }
                }
                else if (e.getClass().getName().equals("Mechanic")){//判断员工类型
                    Mechanic d = (Mechanic) e;//将对象employee强制转换成Driver
                    if(d.eNumber==number){
                        System.out.println(d);//打印寻找的员工
                        break;
                    }

                }
            }
        }
    }

    public static void Fina_a_vehicle(){
        System.out.print("Please input the registration:");
        //键盘读取车辆的rego
        Scanner sc = new Scanner(System.in);
        String Rego = sc.nextLine();
        //构建迭代器
        Iterator<Vehicle> it = vehicles.iterator();
        while(true){
            //遍历结束跳出循环
            if(!it.hasNext()){
                System.out.println("The Vehicle does not exist");
                break;
            }
            Vehicle v =it.next();//指针v指向读到的Vehicle对象
            if (v.getClass().getName().equals("Truck")){//判断车辆类型
                Truck T =(Truck) v;
                if(T.rego.equals(Rego)){
                    System.out.println(T);
                    break;
                }
            }
            else if (v.getClass().getName().equals("Van")){//判断车辆类型
                Van V = (Van) v;
                if(V.rego.equals(Rego)){
                    System.out.println(V);
                    break;
                }
            }
        }
    }
    public static void Fina_a_trip(){
        System.out.print("Please input the trip date:");
        //键盘录入行程日期
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        Iterator<Trip> it = trips.iterator();//创建迭代器
        ArrayList<Trip> arr = new ArrayList<>();//创建集合，可能该日期由多个行程，也方便判断该日期是否存在行程
        while(it.hasNext()){//循遍历寻找该日期的行程
            Trip T = it.next();
            if(T.tripDate.equals(date)){
                arr.add(T);//收集该日程
            }
        }
        if(arr.size()==0){//如果没有符合的行程，则打印“不存在”
            System.out.println("The Trip does not exist");
        }
        else {//打印所有的行程
            for(Trip t:arr){
                System.out.print(t);
            }
        }
    }
    public static void Add_a_trip(){
        //键盘录入信息
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a trip number:");
        int tripN = sc.nextInt();
        System.out.print("Input a trip date:");
        String date = sc.next();
        System.out.print("Input a employee number:");
        int eN = sc.nextInt();
        System.out.print("Input a vehicle rego:");
        String rego = sc.next();
        System.out.print("Input the number of trip legs:");
        int size = sc.nextInt();
        //创建TripLeg集合对象，有些行程有多个TripLeg
        ArrayList<TripLeg> ts = new ArrayList<>();
        for(int i=0;i<size;i++){//根据TripLeg个数设定循环次数
            //录入信息
            System.out.print("Input a leg number:");
            int lnumber = sc.nextInt();
            System.out.print("Input a departure:");
            String dep = sc.next();
            System.out.print("Input a destination:");
            String des = sc.next();
            ts.add(new TripLeg(lnumber,dep,des));
        }
        //创建新日程对象并存储在集合中
        Trip t = new Trip(tripN, date, eN, rego);
        t.tripLegs = ts;
        trips.add(t);
        System.out.println("The trip has been added.");
    }
    public static void Save_data() throws IOException {
        //打开文件
        File f = new File("newTrips.txt");
        File F = new File("Trips.txt");
        FileWriter file = new FileWriter("Trips.txt");
        BufferedWriter writer = new BufferedWriter(file);
        //讲集合内容写入
        for(Trip T:trips){
            String t = T.toString();
            writer.write(t);
        }

        //关闭文件
        writer.close();
        file.close();
        if(F.renameTo(f))//改名
        {
            System.out.println("Input trip filename : newTrips.txt Save succeeds.");
        }
        else
        {
            System.out.println("Input trip filename : newTrips.txt Save fails");
        }


    }
    public static void Exit(){
        flag = false;//使菜单循环跳出
        System.out.println("Bye");
    }
}

