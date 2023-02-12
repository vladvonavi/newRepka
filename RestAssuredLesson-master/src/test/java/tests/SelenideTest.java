package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static formObjects.FormObjects.*;
import static io.qameta.allure.Allure.step;
import static steps.UiSteps.*;

@ExtendWith(AllureJunit5.class)
@DisplayName("Проверка страницы пользователя")
public class SelenideTest {

    String url = "https://demoqa.com/automation-practice-form";
    String firstName = "Vlad";
    String lastName = "Ivanov";
    String userEmail = "vlad@ivanov.com";
    String userNumber = "9999999999";
    String subject = "Arts";
    String currentAddress = "Pacific Ocean";
    String year = "1900";
    String month = "January";
    String picAddress = "src/test/resources/pic.jpg";

    @BeforeEach
    public void preConditions(){
        //Configuration.browserSize = "1920x1080";
        Configuration.browserSize = "695x1980";
        Configuration.headless = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void postConditions(){
        step("Закрываем браузер", Selenide::closeWebDriver);
    }

    @SneakyThrows
    @Test
    @DisplayName("Тест первый")
    void seleniumTest() {
        openPage(url);

        setValueInTextField(firstNameTextField, firstName);
        setValueInTextField(lastNameTextField, lastName);
        setValueInTextField(userEmailTextField, userEmail);
        setValueByClick(genderRadio);
        setValueInTextField(userNumberTextField, userNumber);

        clickElement(birthdateOpen);
        setValueInOption(yearCalendarOption, year);
        setValueInOption(monthCalendarOption, month);
        setValueByClick(dayCalendarOption);

        setValueInTextFieldAndEnter(subjectTextField, subject);

        setValueByClick(hobbyRadio);
        uploadPicture(pictureField, picAddress);

        currentAddressTextField.scrollTo();
        setValueInTextField(currentAddressTextField, currentAddress);

        clickElement(stateField);
        setValueByClick(stateName);
        clickElement(cityField);
        setValueByClick(cityName);

        submitButton.scrollTo();
        clickElement(submitButton);

        $(".table-responsive").shouldHave(
                text("Student name"), text(firstName + ' ' + lastName),
                text("Student Email"), text(userEmail),
                text("Gender"), text("Male"),
                text("Mobile"), text(userNumber),
                text("Date Of Birth"), text("01 January,1900"),
                text("Subject"), text(subject),
                text("Address"), text(currentAddress),
                text("Hobbies"), text("Reading"),
                text("Picture"), text("pic.jpg"),
                text("State and City"), text("NCR Delhi")
        );
    }
}
