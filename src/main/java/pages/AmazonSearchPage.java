package pages;

import config.BasePage;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonSearchPage extends BasePage {

    public void setFilter(String text) {
        $(byId("searchDropdownBox")).shouldBe(enabled, Duration.ofSeconds(30));
        $(byId("searchDropdownBox")).$(byText(text)).click();
    }

    public AmazonResultPage typeText(String text) {
        $(byId("twotabsearchtextbox")).setValue(text).pressEnter();
        return new AmazonResultPage();
    }
}