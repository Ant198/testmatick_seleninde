import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.url;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonResultPage;
import pages.AmazonSearchPage;
import storage.BooksList;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestPage {
    ElementsCollection books;
    SelenideElement book;
    BooksList booksList;

   static {
        Configuration.timeout = 10000; // 10 seconds
    }


    @Test
    public void test() {
        booksList = new BooksList();
        AmazonSearchPage searchPage = open("https://www.amazon.com", AmazonSearchPage.class);

        searchPage.setFilter();
        AmazonResultPage resultsPage = searchPage.typeText();
        System.out.println("Found: " + $$("div").size());
        BooksList booksList = new BooksList();
        books = resultsPage.getBooks();

        System.out.println(books.size());

        for(SelenideElement book : books) {
            String authorBook = "";
            String priceBook = "";
            boolean isBestSeller = false;
            String nameBook = book.find(By.xpath(".//h2"))
                    .find(By.xpath(".//span"))
                    .text();
            booksList.putBookInfo("name", nameBook);
            System.out.println(nameBook);

            ElementsCollection elements = book.$$(By.className("a-size-base"));
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals("by")) {
                    authorBook = elements.get(i + 1).text();
                    break;
                }
            }
            System.out.println(authorBook);
            booksList.putBookInfo("auther", authorBook);

            priceBook = book.$$(By.className("a-offscreen")).texts().get(0);
            System.out.println(priceBook);
            booksList.putBookInfo("price", priceBook);

            isBestSeller = book.$(By.className("a-badge-text")).exists();
            if (isBestSeller) {
                booksList.putBookInfo("best seller", "yes");
            } else {
                booksList.putBookInfo("best seller", "no");
            }

            System.out.println(isBestSeller);

            booksList.setBooksInfoList(booksList.getBookInfo());
        }
        System.out.println(booksList.getBooksInfoList().size());
    }
}
