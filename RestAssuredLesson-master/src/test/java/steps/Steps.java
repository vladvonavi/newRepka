package steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


public class Steps {
    @Step("Проверка, что в ответе поле \"{fieldPath}\" содержит значение \"{expectedValue}\"")
    public static void checkFieldValue(Response response, String fieldPath, Object expectedValue){
        response.then().extract().path(fieldPath).equals(expectedValue);
    }

    @Step("Проверка значения \"{fieldPath}\" в ответе")
    public static void checkFieldNotExpected(Response response, String fieldPath){
        assertThat(response.then().extract().path(fieldPath).toString()).isNotEqualTo("");
    }

    @Step("Проверка, что в ответе \"{fieldPath}\" не пустой")
    public static void checkFieldNotNull(Response response, String fieldPath){
        assertThat(response.then().extract().path(fieldPath).toString()).isNotNull();
    }

    @Step("Проверка, что в ответе \"{fieldPath}\" пустой")
    public static void checkFiledIsNull(Response response, String fieldPath){
        assertNull(response.then().extract().path(fieldPath));
    }

    @Step("Проверка, что статус код == {code}")
    public static void assertStatusCode(Response response, int code){
        response.then().assertThat()
                .statusCode(code);
    }
}
