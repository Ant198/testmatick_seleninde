package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class AmazonSearchPage {
    private final SelenideElement searchField = $(By.id("searchDropdownBox"));

    public void setFilter() {
        $(byId("searchDropdownBox")).$(byText("Books")).click();
    }

    public AmazonResultPage typeText() {
        $(byId("twotabsearchtextbox")).setValue("Java").pressEnter();
        return new AmazonResultPage();
    }
}