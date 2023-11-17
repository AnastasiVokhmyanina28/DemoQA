package TrainingTests;

import ChromeDriver.CustomChromeDriver;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class BaseFormSteps {
    private static String baseUrl;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = BaseFormSteps.class.getClassLoader().getResourceAsStream("test.properties");
            properties.load(inputStream);
            baseUrl = properties.getProperty("baseUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp() {
        Configuration.browser = CustomChromeDriver.class.getCanonicalName();
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.pageLoadTimeout = 70_000L;
        open(baseUrl);

    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }
}
