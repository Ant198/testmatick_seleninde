package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;

public class AmazonResultPage {
    ElementsCollection books;
    private List<String> name = new ArrayList<>();
    private List<String> author = new ArrayList<>();
    private List<String> price = new ArrayList<>();
    private boolean isBestSeller;
    ElementsCollection bookCollection;

    public ElementsCollection getBooks() {
        System.out.println();

        books = $$(".s-result-item")
                .filterBy(attribute("role", "listitem"));
        return books;
    }
}
