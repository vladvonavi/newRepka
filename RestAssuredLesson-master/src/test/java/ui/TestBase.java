package ui;

import helpers.Attach;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    public static void preConditions() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "109.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void postConditions() {
        Attach.screenshotAs("After test screen");
        Attach.attachVideo();
        step("Закрываем браузер", Selenide::closeWebDriver);
    }
}