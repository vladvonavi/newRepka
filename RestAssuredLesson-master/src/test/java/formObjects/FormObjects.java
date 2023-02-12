package formObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FormObjects {
    public static SelenideElement firstNameTextField = $("#firstName"); // текстовое поле с именем
    public static SelenideElement lastNameTextField = $("#lastName"); // текстовое поле с фамилией
    public static SelenideElement userEmailTextField = $("#userEmail"); // текстовое поле с фамилией
    public static SelenideElement userNumberTextField = $("#userNumber"); // текстовое поле с фамилией
    public static SelenideElement currentAddressTextField = $("[id=currentAddress]"); // текстовое поле с адресом
    public static SelenideElement subjectTextField = $("[id=subjectsInput]"); //текстовое поле с предметом

    public static SelenideElement genderRadio = $("[for=gender-radio-1]"); // выбор пола
    public static SelenideElement hobbyRadio = $("[for=hobbies-checkbox-2]");

    public static SelenideElement pictureField = $("#uploadPicture");
    public static SelenideElement birthdateOpen = $x("//input[@id=\"dateOfBirthInput\"]");
    public static SelenideElement yearCalendarOption = $(".react-datepicker__year-select");
    public static SelenideElement monthCalendarOption = $(".react-datepicker__month-select");
    public static SelenideElement dayCalendarOption = $(".react-datepicker__day--001");

    public static SelenideElement stateField = $("[id=state]");
    public static SelenideElement stateName = $(byText("NCR"));
    public static SelenideElement cityField = $("[id=city]");
    public static SelenideElement cityName = $(byText("Delhi"));


    public static SelenideElement submitButton = $("[id=submit]");
}