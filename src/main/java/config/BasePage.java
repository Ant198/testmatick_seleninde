package config;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.title;

public abstract class BasePage {
    private String pageTitle;
    private String pageUrl;

    public String getPageTitle() {
        return pageTitle;
    }
    public void setPageTitle() {
        pageTitle = title();
    }
    public String getPageUrl() {
        return pageUrl;
    }
    public void setPageUrl() {
        pageUrl = WebDriverRunner.url();
    }
}
