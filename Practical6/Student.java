package practicals.task6;

public class Student implements Comparable<Student>{
    private int iDNumber;
    private String name;
    private int grade;
    private double gpa;

    public int getiDNumber() {return iDNumber;}
    public void setiDNumber(int iDNumber) {this.iDNumber = iDNumber;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getGrade() {return grade;}
    public void setGrade(int grade) {this.grade = grade;}

    public double getGpa() {return gpa;}
    public void setGpa(double gpa) {this.gpa = gpa;}

    public Student(int iDNumber, String name, int grade, double gpa) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.grade = grade;
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.getName());
    }

    @Override public String toString() {
        return "practicals.task6.Student{" +
                "iDNumber=" + iDNumber +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", gpa=" + gpa +
                '}';
    }
}
