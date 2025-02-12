package pages;

import com.codeborne.selenide.SelenideElement;
import config.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonSearchPage extends BasePage {
    private final SelenideElement searchField = $(By.id("searchDropdownBox"));

    public void setFilter() {
        $(byId("searchDropdownBox")).$(byText("Books")).click();
    }

    public AmazonResultPage typeText() {
        $(byId("twotabsearchtextbox")).setValue("Java").pressEnter();
        return new AmazonResultPage();
    }
}