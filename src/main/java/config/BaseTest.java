package config;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        open("https://www.amazon.com/");
    }
}
