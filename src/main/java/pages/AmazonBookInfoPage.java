package pages;

import config.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class AmazonBookInfoPage extends BasePage {
    String name;
    String author;
    String price;
    String bestSeller;

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

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPrice() {
        return price;
    }

    public String getBestSeller() {
        return bestSeller;
    }

}
