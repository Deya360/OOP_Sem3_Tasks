package practicals.task1;

import java.time.LocalDate;

public class Book {
    private String author;
    private String name;
    private String genre;
    private double price;
    private LocalDate datePublished;

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getGenere() {return genre;}
    public void setGenere(String genre) {this.genre = genre;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public LocalDate getDatePublished() {return datePublished;}
    public void setDatePublished(LocalDate datePublished) {this.datePublished = datePublished;}

    Book(String author, String name, String genere, double price, LocalDate datePublished) {
        this.author=author;
        this.name=name;
        this.genre=genere;
        this.price=price;
        this.datePublished=datePublished;
    }

    @Override
    public String toString(){
        return "The practicals.task1.Book is called " + name + " of the genre " + genre + " written by "
                + author + " published on " + datePublished + " and is sold for $" + price;
    }
}