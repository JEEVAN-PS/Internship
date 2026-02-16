import java.util.Scanner;

public class ElectricBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of units consumed: ");
        int units = sc.nextInt();

        double bill;

        bill = (units <= 100) ? 
                units * 5 
                : (units <= 200) ? 
                (100 * 5) + ((units - 100) * 7) 
                : 
                (100 * 5) + (100 * 7) + ((units - 200) * 10);

        System.out.println("Total Electricity Bill = Rs. " + bill);

        sc.close();
    }
}
