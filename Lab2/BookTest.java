package labs.task2;

public class BookTest {
    public static void main(String[] args) { //Driver sub

        //create objects
        Book b1 = new Book("Catching Fire","Suzanne Collins","Adventure","English",2009,10.77,439,"978-0-545-22724-7");
        Book b2 = new Book("Gray Mountain","John Grisham","Legal thriller","English",2014,15.07,480,"978-0-385-53714-8");
        Book b3 = new Book("Жутко громко и запредельно близко", "Джонатан Фоер","Роман","Russian",2005,7.02,416,"978-5-699-53876-8");

        Bookshelf bks1 = new Bookshelf("Living Room labs.task2.Bookshelf","Brown",40, Bookshelf.Sort.Ascending, Bookshelf.SortBy.Author);
        Bookshelf bks2 = new Bookshelf("Couch Area Shelf","Mahogany",17, Bookshelf.Sort.Descending, Bookshelf.SortBy.Year);
        Reader re1 = new Reader("Alex",19);


        //simulate a scenario
        bks1.addBook(b1);
        bks1.addBook(b2);
        bks1.addBook(b3);
        bks1.printBooks();
        System.out.print("\n==============================\n");

        re1.acquireBook(bks1, b2);
        re1.printBooks();
        System.out.print("\n");
        bks1.printBooks();
        System.out.print("\n==============================\n");

        re1.returnBook(bks1, b2);
        bks1.printBooks();
        System.out.print("\n==============================\n");

        re1.acquireBook(bks1, b3);
        re1.returnBook(bks2, b3);
        bks1.printBooks();
        System.out.print("\n");
        bks2.printBooks();
        System.out.print("\n");

    }
}
