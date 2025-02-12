package pages;

import config.BasePage;
import storage.Book;
import org.openqa.selenium.By;

import java.util.Map;

import static com.codeborne.selenide.Selenide.$;


public class AmazonBookInfoPage extends BasePage {
    String name;
    String author;
    String price;
    String bestSeller;



    public Map<String, String> getBook() {
        return new Book(name, author, price, bestSeller).getBook();
    }

    public void setBookInfo() {
        name = $(By.id("productTitle")).text();
        author = $(By.id("bylineInfo")).$$("span").get(0).$("a").text();
        price = $("#tmm-grid-swatch-PAPERBACK").$(".slot-price").$("span").text();
        System.out.println($(By.className("a-badge-text")).exists());
        if ($("#zeitgeistBadge_feature_div").exists()) {
            bestSeller = "yes";
        } else {
            bestSeller = "no";
        }

    }
    /*
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AmazonBookInfoPage book = (AmazonBookInfoPage) obj;
        return  Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(price, book.price) &&
                Objects.equals(bestSeller, book.bestSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price, bestSeller);
    }

     */

}
