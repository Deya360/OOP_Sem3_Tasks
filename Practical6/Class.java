package practicals.task6;

import java.util.ArrayList;

public class Class {
    private String name;
    private String formClass;
    private ArrayList<Student> students;

    public Class(String name, String formClass, ArrayList<Student> students) {
        this.name = name;
        this.formClass = formClass;
        this.students = students;
    }

    public Class(String name, String formClass) {
        this.name = name;
        this.formClass = formClass;
        this.students = new ArrayList<>();
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getFormClass() {return formClass;}
    public void setFormClass(String formClass) {this.formClass = formClass;}

    public ArrayList<Student> getStudents() {return students;}
    public void setStudents(ArrayList<Student> students) {this.students = students;}
    public void addStudent(Student s) {this.students.add(s);}
    public void removeStudent(Student s) {this.students.remove(s);}

    @Override public String toString() {
        return "practicals.task6.Class{" +
                "name='" + name + '\'' +
                ", formClass='" + formClass + '\'' +
                ", students=" + students +
                '}';
    }
}
