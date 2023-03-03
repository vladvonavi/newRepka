package ui.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static propLoader.PropLoader.getPropertyByName;
import static steps.UiSteps.setValueInTextField;

public class QaDemoPage {
    public static QaDemoPage demoPage(){
        return new QaDemoPage();
    }

    private final SelenideElement firstNameTextField = $("#firstName"); // текстовое поле с именем
    private final SelenideElement lastNameTextField = $("#lastName");
    private final SelenideElement emailTextField = $("#userEmail");
    private final SelenideElement phoneNumberTextField = $("#userNumber");
    private final SelenideElement subjectList = $("[id=subjectsInput]");


    @Step("Открываем главную страницу")
    public QaDemoPage openPage(){
        open(getPropertyByName("demoQaPageUrl"));
        return this;
    }

    @Step("Вводим имя {firstName}")
    public QaDemoPage setFirstName(String firstName){
        setValueInTextField(firstNameTextField, firstName);
        return this;
    }

    @Step("Вводим фамилию {lastName}")
    public QaDemoPage setLastName(String lastName){
        lastNameTextField.setValue(lastName);
        return this;
    }

    @Step("Ввводим email {email}")
    public QaDemoPage setEmail(String email){
        emailTextField.setValue(email);
        return this;
    }

    @Step("Ввводим телефон {phoneNumber}")
    public QaDemoPage setPhoneNumber(String phoneNumber){
        phoneNumberTextField.setValue(phoneNumber);
        return this;
    }

    @Step("Ввводим subject {subject}")
    public QaDemoPage setSubject(String subject){
        subjectList.setValue(subject).pressEnter();
        return this;
    }


//    public ModalWindowObjects openModalWindow(){
//        return new ModalWindowObjects();
//    }

    public QaDemoPage assertBasfa(){

        return this;
    }

}