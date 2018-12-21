package practicals.task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {    //Driver - Sub
        Student s1 = new Student(14,"Elisabeth Valko Jansink",10,3.6);
        Student s2 =  new Student(3,"Kenzie Deepika Denzel",11,3.6);
        Student s3 =  new Student(12,"Nino Euandros Sander",11,3.8);
        Student s4 =  new Student(24,"Kunibert Pepito Félix",10,4.0);
        Student s5 =  new Student(6,"Röwşen Radhika Palmeiro",10,3.7);
        Student s6 =  new Student(18,"Maximilian Mae Magro",11,4.0);
        Student s7 =  new Student(10,"Abdulah Laurits Nathans",10,4.1);

        //Task 1
        ArrayList<Student> students  = new ArrayList<>(4);
        students.add(s1);
        students.add(s4);
        students.add(s5);
        students.add(s7);

        students.sort(Comparator.comparing(Student::getiDNumber));

        for (Student s: students) {
            System.out.println(s.toString());
        }
        System.out.println("\n");


        //Task 2
        students.sort(new SortingStudentsByGPA());
        for (Student s: students) {
            System.out.println(s.toString());
        }
        System.out.println("\n");

        //Task 3
        Class c1 = new Class("10A","B245");
        c1.addStudent(s1);
        c1.addStudent(s4);
        c1.addStudent(s5);
        c1.addStudent(s7);

        Class c2 = new Class("11A","B246");
        c2.addStudent(s2);
        c2.addStudent(s3);
        c2.addStudent(s6);

        ArrayList<Student> class10A11A = new ArrayList<>();
        class10A11A.addAll(c1.getStudents());
        class10A11A.addAll(c2.getStudents());
        Collections.sort(class10A11A);

        for (Student s: class10A11A) {
            System.out.println(s.toString());
        }
    }

}
