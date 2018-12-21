package practicals.task1;

import java.lang.System;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {  //Class Tester

        Ball bl1 = new Ball("Telstar 18",               //By specifying the ball type, the radius is set dynamically;
                            Ball.Types.Soccer,            //thus; no need for the radius field.
                            "Adidas",
                            "White");
        System.out.println(bl1);

        Book bk1 = new Book("Suzanne Collins",
                            "Catching Fire",
                            "Adventure",
                            8.28,
                            LocalDate.parse("2009-09-01"));
        System.out.println(bk1);
    }
}



