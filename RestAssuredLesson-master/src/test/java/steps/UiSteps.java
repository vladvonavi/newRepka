package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UiSteps {

    @Step("Открываем страницу \"{addressUrl}\" ")
    public static void openPage(String addressUrl){
        open(addressUrl);
    }

    @Step("Вводим значение \"{textValue}\" в элемент {element}")
    public static void setValueInTextField(SelenideElement element, String textValue){
        element.setValue(textValue);
    }

    @Step("Вводим значение \"{textValue}\" в элемент \"{element}\" и нажимаем Enter")
    public static void setValueInTextFieldAndEnter(SelenideElement element, String textValue){
        element.setValue(textValue).pressEnter();
    }

    @Step("Выбираем значение \"{optionValue}\" в элементе {element}")
    public static void setValueInOption(SelenideElement element, String optionValue){
        element.selectOption(optionValue);
    }

    @Step("Выбираем значение \"{}\" в элементе \"{element}\"")
    public static void setValueByClick(SelenideElement element){
        element.click();
    }

    @Step("Клик на элемент \"{element}\"")
    public static void clickElement(SelenideElement element){
        element.click();
    }

    @Step("Загружаем картинку из \"{picAddress}\" в элемент {element}")
    public static void uploadPicture(SelenideElement element, String picAddress){
        element.uploadFile(new File(picAddress));
    }
}