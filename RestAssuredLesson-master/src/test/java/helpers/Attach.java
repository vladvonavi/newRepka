package helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;


import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {
    @Attachment(value = "{attachName}", type="image/png")
    public static byte[] screenshotAs(String attachName){
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static String getSessionId(){
        return ((RemoteWebDriver)getWebDriver()).getSessionId().toString();
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public static String attachVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + "http://localhost:4444/video/" + getSessionId() + ".mp4"
                + "' type='video/mp4'></video></body></html>";
    }
}