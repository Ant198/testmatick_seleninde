package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import config.BasePage;
import Models.Book;
import org.openqa.selenium.By;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonResultPage extends BasePage {
    private final List<Book> booksList;

    public AmazonResultPage() {
        this.booksList = new ArrayList<>();
    }

    public void setBooksList() {
        ElementsCollection books;
        String name;
        String author = "";
        String price;
        String bestSeller;
       books = $$(".s-result-item").filterBy(attribute("role", "listitem"));

        for(SelenideElement book : books) {
            name = book.find(By.xpath(".//h2"))
                    .find(By.xpath(".//span"))
                    .text();
            ElementsCollection elements = book.$$(By.className("a-size-base"));
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals("by")) {
                    author = elements.get(i + 1).text();
                    break;
                }
            }
            price = book.$$(By.className("a-offscreen")).texts().getFirst();

            if (book.$(By.className("a-badge-text")).exists()) {
                bestSeller = "yes";
            } else {
                bestSeller = "no";
            }
            booksList.add(new Book(name, author, price, bestSeller));
        }
    }

    public List<Book> getBooksList() {
        return booksList;
    }
}