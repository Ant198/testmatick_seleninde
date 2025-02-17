package Models;

import java.util.Objects;

public class Book {
    String name;
    String author;
    String price;
    String bestSeller;

    public Book (String name, String author, String price, String bestSeller) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.bestSeller = bestSeller;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Objects.equals(name, book.name)
                && Objects.equals(author, book.author)
                && Objects.equals(price, book.price)
                && Objects.equals(bestSeller, book.bestSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price, bestSeller);
    }

}