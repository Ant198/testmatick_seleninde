package pages;

import config.BasePage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class AmazonSearchPage extends BasePage {

    public void setFilter() {
        $(byId("searchDropdownBox")).shouldBe(enabled);
        $(byId("searchDropdownBox")).$(byText("Books")).click();
    }

    public AmazonResultPage typeText() {
        $(byId("twotabsearchtextbox")).setValue("Java").pressEnter();
        return new AmazonResultPage();
    }
}