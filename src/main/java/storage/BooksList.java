package storage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BooksList {
    private Map<String, String> bookInfo;
    private List<Map<String, String>> booksInfoList;

    public BooksList() {
        this.bookInfo = new HashMap<>();
        this.booksInfoList = new ArrayList<>();
    }

    public <T> void putBookInfo(String key, String value) {
        bookInfo.put(key, value);
    }

    public Map<String, String> getBookInfo() {
        return bookInfo;
    }

    public void setBooksInfoList(Map<String, String> bookInfo ) {
        booksInfoList.add(bookInfo);
    }
    public List<Map<String, String>> getBooksInfoList() {
        return booksInfoList;
    }

    public void saveBookInfo(ElementsCollection books) {
        for(SelenideElement book : books) {
            String authorBook = "";
            String priceBook = "";
            boolean isBestSeller = false;
            String nameBook = book.find(By.xpath(".//h2"))
                    .find(By.xpath(".//span"))
                    .text();
            putBookInfo("name", nameBook);
            ElementsCollection elements = book.$$(By.className("a-size-base"));
            for (int i = 0; i < elements.size(); i++) {
                if (elements.get(i).getText().equals("by")) {
                    authorBook = elements.get(i + 1).text();
                    break;
                }
            }
            putBookInfo("auther", authorBook);

            priceBook = book.$$(By.className("a-offscreen")).texts().get(0);
            putBookInfo("price", priceBook);

            isBestSeller = book.$(By.className("a-badge-text")).exists();
            if (isBestSeller) {
                putBookInfo("best seller", "yes");
            } else {
                putBookInfo("best seller", "no");
            }

            setBooksInfoList(getBookInfo());
        }


    }
    
}
