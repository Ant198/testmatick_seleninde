import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import config.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonBookInfoPage;
import pages.AmazonResultPage;
import pages.AmazonSearchPage;
import storage.BooksList;

public class AmazonBookSearchAndVerificationTest extends BaseTest {
    ElementsCollection books;
    BooksList booksList;
    String basePageUrl = "https://www.amazon.com/";
    String bookPageUrl = "https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_3?dib=eyJ2IjoiMSJ9.VhdqJr59jl-7CJ3ERsIzDhwY0Yqmtq6zSQ3g-YBLqcuH4jbxNxHxI_oaEJ34po07SuLg5VeaNDQSHs0b7IdSteKVObRDXSpWsnrJnaOk_jnbqJ6cG5Iov4rmDUctlouQ6jc8Nlgu0fjfRedgr6fThsNLGcBZaVUtUtoxqTCXdprGIIOGGOEKqJ7Ftvu7ZR3qsZ-dObChiFblwTaFQh9hG65ByHgb-OnPk_hWafBE25E.u6ZcV2uYDzTAJIF7BT6z4WyyCgQjC4m8qR-hYxBO7jg&dib_tag=se&keywords=Java&qid=1728470947&s=books&sr=1-3 (дані про книгу теж потрібно витягти з її сторінки)";

    static {
        Configuration.timeout = 10000; // 10 seconds
    }

    @Test
    public void test() {
        booksList = new BooksList();
        AmazonSearchPage searchPage = new AmazonSearchPage();
        searchPage.setPageUrl();
        searchPage.setPageTitle();
        searchPage.setFilter();
        AmazonResultPage resultsPage = searchPage.typeText();
        resultsPage.setPageTitle();
        resultsPage.setPageUrl();
        booksList = new BooksList();
        books = resultsPage.getBooks();
        booksList.saveBookInfo(books);

        AmazonBookInfoPage bookInfoPage = open(bookPageUrl, AmazonBookInfoPage.class);

        bookInfoPage.setPageTitle();
        bookInfoPage.setBookInfo();
        System.out.println(booksList.getBooksList());
        System.out.println(bookInfoPage.getBook());
        Assert.assertEquals(basePageUrl, searchPage.getPageUrl(), "wrong url");
        Assert.assertFalse(searchPage.getPageTitle().equals(resultsPage.getPageTitle()), "wrong title");
        Assert.assertFalse(resultsPage.getPageTitle().equals(bookInfoPage.getPageTitle()), "wrong title");
        Assert.assertTrue(booksList.getBooksList().contains(bookInfoPage.getBook()), "book not exist");
   }
}
