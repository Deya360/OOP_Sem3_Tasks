package labs.task2;

import java.util.*;

public class Bookshelf {
    private  ArrayList<Book> books;
    private String name;
    private String color;
    private int capacity;
    private int max_capacity;

    public enum Sort {
        Ascending,
        Descending
    }
    private Sort sort;

    public enum SortBy {
        Author,
        Genre,
        Year
    }
    private SortBy sortBy;

    Bookshelf(String name, String color, int max_capacity, Sort sort, SortBy sortBy) {
        this.books = new ArrayList<>();
        this.name = name;
        this.color = color;
        this.max_capacity = max_capacity;
        this.sort = sort;
        this.sortBy = sortBy;
    }

    private void arrange() {
        if (sortBy == SortBy.Author) {
            books.sort(Comparator.comparing(Book::getAuthor));
        } else if(sortBy == SortBy.Year) {
            books.sort(Comparator.comparing(Book::getPublished_year));
        } else if (sortBy == SortBy.Genre) {
            books.sort(Comparator.comparing(Book::getGenre));
        }
        if (sort == Sort.Descending) Collections.reverse(books);
    }

    public void addBook(Book newBook) {
        if (capacity < max_capacity) {
            books.add(newBook);
            capacity++;
            arrange();
        }
    }

    public void removeBook(Book presentBook) {
        books.remove(presentBook);
        capacity--;
    }

    public void printBooks() {
        for (Book bk: books) System.out.println(bk);
    }

    @Override public String toString() {
        return "labs.task2.Bookshelf{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", current capacity=" + capacity +
                ", maximum capacity=" + max_capacity +
                ", sort=" + sort +
                ", sortBy=" + sortBy +
                '}';
    }
}
