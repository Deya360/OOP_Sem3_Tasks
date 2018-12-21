package labs.task2;

public class Book {
    private String id_ISBN;
    private String name;
    private String author;
    private String genre;
    private String language;
    private int published_year;  //year written
    private double price;
    private int pages;

    Book(String name, String author, String genre, String language, int published_year, double price, int pages, String id_ISBN) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.published_year = published_year;
        this.price = price;
        this.pages = pages;
        this.id_ISBN = id_ISBN;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    public String getGenre() {return genre;}
    public void setGenre(String genre) {this.genre = genre; }

    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}

    public int getPages() {return pages;}
    public void setPages(int pages) {this.pages = pages;}

    public int getPublished_year() {return published_year;}
    public void setPublished_year(int published_year) {this.published_year = published_year;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getId_ISBN() {return id_ISBN;}
    public void setId_ISBN(String id_ISBN) {this.id_ISBN = id_ISBN;}

    @Override public String toString() {
        return "labs.task2.Book{" +
                "ISBN='" + id_ISBN + '\'' +
                ", Name='" + name + '\'' +
                ", Author='" + author + '\'' +
                ", Genre='" + genre + '\'' +
                ", Language='" + language + '\'' +
                ", Year Written=" + published_year +
                ", Price=" + "$" + price +
                ", Pages=" + pages +
                '}';
    }
}
