package pages;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;


public class AmazonBookInfoPage {
    private final Map<String, String> bookInfo;

    public AmazonBookInfoPage() {
        this.bookInfo = new HashMap<>();
    }

    public <T> void putBookInfo(String key, String value) {
        bookInfo.put(key, value);
    }

    public Map<String, String> getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo() {
        String name = $(By.id("productTitle")).text();
        putBookInfo("name", name);
        String author = $(By.id("bylineInfo")).$$("span").get(0).$("a").text();
        putBookInfo("author", author);
    }
    public boolean isEquals(List<Map<String, String>> bookFromList) {
        boolean isExist = false;
        for (int i = 0; i < bookFromList.size(); i++) {
            if (bookFromList.get(i).get("name").equals(getBookInfo().get("name"))
               && bookFromList.get(i).get("author").equals(getBookInfo().get("author"))) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }
}
