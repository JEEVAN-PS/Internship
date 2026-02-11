
class Student {

    String name;
    int age;
    float cgpa;
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("CGPA: " + cgpa);
    }
}


public class Main {

    public static void main(String[] args) {

    
        Student s1 = new Student();


        s1.name = "Jeevan";
        s1.age = 21;
        s1.cgpa = 8.3f;
        s1.display();
    }
}

