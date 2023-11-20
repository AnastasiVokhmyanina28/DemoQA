package ChromeDriver;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class BaseForm {
    private static String baseUrl;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = BaseForm.class.getClassLoader().getResourceAsStream("test.properties");
            properties.load(inputStream);
            baseUrl = properties.getProperty("baseUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUp() {
        Configuration.browser = CustomChromeDriver.class.getCanonicalName();
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.pageLoadTimeout = 70_000L;
        Configuration.startMaximized= true;
        open(baseUrl);
    }

    @AfterAll
    public static void close() {
        closeWebDriver();
    }
}
