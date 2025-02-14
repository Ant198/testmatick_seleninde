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
        if ($("#zeitgeistBadge_feature_div").exists()) {
            bestSeller = "yes";
        } else {
            bestSeller = "no";
        }
    }


}
