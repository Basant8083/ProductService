package General;

import java.util.ArrayList;

public class Batch {
    ArrayList<Student> students = new ArrayList<>();
    int strength;

    public static void main(String[] args) {
        Batch b1 = new Batch();
        b1.students.add(new Student(10, "ABC"));
        Batch b2 = new Batch();
        b2.students = b1.students;
        b2.strength= b1.strength;
        b2.students.add(new Student(11, "DEF"));

        System.out.println("B1 Student Size "+ b1.students.size() );
    }
}
