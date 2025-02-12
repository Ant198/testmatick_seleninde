package pages;

import com.codeborne.selenide.ElementsCollection;
import config.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonResultPage extends BasePage {
    ElementsCollection books;

    public ElementsCollection getBooks() {
        System.out.println();

        books = $$(".s-result-item")
                .filterBy(attribute("role", "listitem"));
        return books;
    }
}
