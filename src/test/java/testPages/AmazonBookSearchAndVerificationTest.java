package testPages;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Selenide;
import config.BaseTest;
import Models.Book;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonBookInfoPage;
import pages.AmazonResultPage;
import pages.AmazonSearchPage;
import java.util.List;

public class AmazonBookSearchAndVerificationTest extends BaseTest {
    String filterName = "Books";
    String searchWord = "Java";
    String basePageUrl = "https://www.amazon.com/";
    String bookPageUrl = "https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_3?dib=eyJ2IjoiMSJ9.VhdqJr59jl-7CJ3ERsIzDhwY0Yqmtq6zSQ3g-YBLqcuH4jbxNxHxI_oaEJ34po07SuLg5VeaNDQSHs0b7IdSteKVObRDXSpWsnrJnaOk_jnbqJ6cG5Iov4rmDUctlouQ6jc8Nlgu0fjfRedgr6fThsNLGcBZaVUtUtoxqTCXdprGIIOGGOEKqJ7Ftvu7ZR3qsZ-dObChiFblwTaFQh9hG65ByHgb-OnPk_hWafBE25E.u6ZcV2uYDzTAJIF7BT6z4WyyCgQjC4m8qR-hYxBO7jg&dib_tag=se&keywords=Java&qid=1728470947&s=books&sr=1-3";

    List<Book> listOfBooks;
    Book expectedBook;

    @Test
    public void test() {
        Selenide.screenshot("before_searchDropdownBox");
        AmazonSearchPage searchPage = new AmazonSearchPage();
        searchPage.setPageUrl();
        searchPage.setPageTitle();
        searchPage.setFilter(filterName);
        AmazonResultPage resultsPage = searchPage.typeText(searchWord);
        resultsPage.setPageTitle();
        resultsPage.setPageUrl();
        resultsPage.setBooksList();

        AmazonBookInfoPage bookInfoPage = open(bookPageUrl, AmazonBookInfoPage.class);
        bookInfoPage.setPageTitle();
        bookInfoPage.setBookInfo();
        listOfBooks = resultsPage.getBooksList();
        expectedBook = new Book(bookInfoPage.getName(),
                                    bookInfoPage.getAuthor(),
                                    bookInfoPage.getPrice(),
                                    bookInfoPage.getBestSeller());

        Assert.assertEquals(basePageUrl, searchPage.getPageUrl(), "wrong url");
        Assert.assertTrue($(byId("searchDropdownBox")).exists());
        Assert.assertFalse(searchPage.getPageTitle().equals(resultsPage.getPageTitle()), "wrong title");
        Assert.assertFalse(resultsPage.getPageTitle().equals(bookInfoPage.getPageTitle()), "wrong title");
        Assert.assertTrue(listOfBooks.contains(expectedBook), "book not exist");
   }

}
