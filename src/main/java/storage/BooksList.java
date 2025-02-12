package storage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BooksList {

    private List<Map<String, String>> booksInfoList;

    public BooksList() {
        this.booksInfoList = new ArrayList<>();
    }

    public void setBooksInfoList(Map<String, String> bookInfo ) {
        booksInfoList.add(bookInfo);
    }
    public List<Map<String, String>> getBooksList() {
        return booksInfoList;
    }

    public void saveBookInfo(ElementsCollection books) {
        String name = "";
        String author = "";
        String price = "";
        String bestSeller = "";
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
            price = book.$$(By.className("a-offscreen")).texts().get(0);

            if (book.$(By.className("a-badge-text")).exists()) {
                bestSeller = "yes";
            } else {
                bestSeller = "no";
            }

            setBooksInfoList(new Book(name, author, price, bestSeller).getBook());
        }


    }
    
}
