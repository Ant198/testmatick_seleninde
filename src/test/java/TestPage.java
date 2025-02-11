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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonBookInfoPage;
import pages.AmazonResultPage;
import pages.AmazonSearchPage;
import storage.BooksList;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestPage {
    ElementsCollection books;
    BooksList booksList;
    AmazonBookInfoPage bookInfo;
    String bookPageUrl = "https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_3?dib=eyJ2IjoiMSJ9.VhdqJr59jl-7CJ3ERsIzDhwY0Yqmtq6zSQ3g-YBLqcuH4jbxNxHxI_oaEJ34po07SuLg5VeaNDQSHs0b7IdSteKVObRDXSpWsnrJnaOk_jnbqJ6cG5Iov4rmDUctlouQ6jc8Nlgu0fjfRedgr6fThsNLGcBZaVUtUtoxqTCXdprGIIOGGOEKqJ7Ftvu7ZR3qsZ-dObChiFblwTaFQh9hG65ByHgb-OnPk_hWafBE25E.u6ZcV2uYDzTAJIF7BT6z4WyyCgQjC4m8qR-hYxBO7jg&dib_tag=se&keywords=Java&qid=1728470947&s=books&sr=1-3 (дані про книгу теж потрібно витягти з її сторінки)";

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

        booksList.saveBookInfo(books);

        AmazonBookInfoPage bookInfoPage = open(bookPageUrl, AmazonBookInfoPage.class);

        bookInfoPage.setBookInfo();
        bookInfoPage.getBookInfo();

        Assert.assertTrue(bookInfoPage.isEquals(booksList.getBooksInfoList()), "book not found");

    }
}
