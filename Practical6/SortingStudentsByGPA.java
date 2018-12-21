package practicals.task6;

import java.util.Comparator;

class SortingStudentsByGPA implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return Double.compare(a.getGpa(),b.getGpa());
    }
}