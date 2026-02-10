import java.util.Scanner;

public class PrimeCheckInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        boolean prime = true;

        if (num <= 1)
            prime = false;
        else {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
        }

        if (prime)
            System.out.println("Prime Number");
        else
            System.out.println("Not Prime");
    }
}
