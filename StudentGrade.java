import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String names[] = new String[5];
        int marks[] = new int[5];

        for(int i = 0; i < 5; i++) {

            System.out.print("Enter name of student " + (i+1) + ": ");
            names[i] = sc.nextLine();

            System.out.print("Enter marks of student " + (i+1) + ": ");
            marks[i] = sc.nextInt();
            sc.nextLine(); 
            char grade;

            if(marks[i] >= 90)
                grade = 'A';
            else if(marks[i] >= 75)
                grade = 'B';
            else if(marks[i] >= 50)
                grade = 'C';
            else
                grade = 'F';

            System.out.println("Student: " + names[i] +
                               " | Marks: " + marks[i] +
                               " | Grade: " + grade);
            System.out.println();
        }

        sc.close();
    }
}
