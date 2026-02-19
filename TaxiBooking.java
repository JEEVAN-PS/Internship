import java.util.*;

class Trip {
    int bookingId, customerId, pickupTime, dropTime, amount;
    char from, to;

    Trip(int bid,int cid,char f,char t,int p,int d,int amt){
        bookingId=bid;
        customerId=cid;
        from=f;
        to=t;
        pickupTime=p;
        dropTime=d;
        amount=amt;
    }
}

class Taxi {
    int id;
    char location='A';
    int freeTime=0;
    int earnings=0;
    List<Trip> trips=new ArrayList<>();

    Taxi(int id){
        this.id=id;
    }
}

public class TaxiBooking {

    static int bookingId=1;

    static int pos(char c){ return c-'A'; }

    static int distance(char a,char b){
        return Math.abs(pos(a)-pos(b))*15;
    }

    static int fare(char a,char b){
        int d=distance(a,b);
        if(d<=5) return 100;
        return 100+(d-5)*10;
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        List<Taxi> taxis=new ArrayList<>();
        for(int i=1;i<=4;i++) taxis.add(new Taxi(i));

        while(true){

            try{

                System.out.println("\n1.Book Taxi");
                System.out.println("2.Show Taxi Details");
                System.out.println("3.Exit");
                System.out.print("Enter choice: ");

                int ch=sc.nextInt();

                if(ch==1){

                    System.out.print("Customer ID: ");
                    int cid=sc.nextInt();

                    System.out.print("Pickup point(A-F): ");
                    char from=sc.next().toUpperCase().charAt(0);

                    System.out.print("Drop point(A-F): ");
                    char to=sc.next().toUpperCase().charAt(0);

                    System.out.print("Pickup time: ");
                    int time=sc.nextInt();

                    if(from==to){
                        System.out.println("Pickup and Drop same!");
                        continue;
                    }

                    List<Taxi> available=new ArrayList<>();

                    for(Taxi t:taxis){

                        int reach=Math.abs(pos(t.location)-pos(from));

                        if(t.freeTime+reach<=time)
                            available.add(t);
                    }

                    if(available.isEmpty()){
                        System.out.println("No taxi available");
                        continue;
                    }

                    available.sort((a,b)->{

                        int d1=Math.abs(pos(a.location)-pos(from));
                        int d2=Math.abs(pos(b.location)-pos(from));

                        if(d1!=d2) return d1-d2;
                        return a.earnings-b.earnings;
                    });

                    Taxi taxi=available.get(0);

                    int trip=Math.abs(pos(from)-pos(to));
                    int dropTime=time+trip;

                    int money=fare(from,to);

                    taxi.location=to;
                    taxi.freeTime=dropTime;
                    taxi.earnings+=money;

                    taxi.trips.add(new Trip(
                        bookingId++,cid,from,to,time,dropTime,money));

                    System.out.println("Taxi-"+taxi.id+" allotted");

                }

                else if(ch==2){

                    for(Taxi t:taxis){

                        System.out.println("\nTaxi-"+t.id+
                        " Total Earnings: "+t.earnings);

                        for(Trip tr:t.trips){

                            System.out.println(
                            tr.bookingId+" "+
                            tr.customerId+" "+
                            tr.from+" "+tr.to+" "+
                            tr.pickupTime+" "+
                            tr.dropTime+" "+
                            tr.amount);
                        }
                    }
                }

                else if(ch==3){
                    break;
                }

                else{
                    System.out.println("Invalid choice");
                }

            }


            catch(InputMismatchException e){
                System.out.println("Invalid input! Enter correct type.");
                sc.nextLine();
            }

            catch(Exception e){
                System.out.println("Unexpected error: "+e.getMessage());
                sc.nextLine();
            }

            finally{
                System.out.println("Operation completed.");
            }
        }

        sc.close();
    }
}