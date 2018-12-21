package labs.task2;

import java.util.*;

public class Reader {
    private  ArrayList<Book> booksInPossession;
    private String name;
    private int age;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public Reader(String name, int age) {
        this.booksInPossession = new ArrayList<>();
        this.name = name;
        this.age = age;
    }

    public void acquireBook(Bookshelf originBks, Book newBook) {
        originBks.removeBook(newBook);
        booksInPossession.add(newBook);

    }

    public void returnBook(Bookshelf originBks, Book presentBook) {
        booksInPossession.remove(presentBook);
        originBks.addBook(presentBook);
    }

    public void printBooks() { for (Book bk: booksInPossession) System.out.println(bk); }

    @Override public String toString() {
        return "labs.task2.Reader{" +
                "name='" + name + '\'' +
                ", age=" + age + " years" +
                '}';
    }
}
