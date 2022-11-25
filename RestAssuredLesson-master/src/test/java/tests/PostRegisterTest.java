package tests;

import dto.RegisterReqDto;
import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static io.qameta.allure.Allure.step;
import static methods.RegisterTestRestAssured.postRegister;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.RegisterReqFactory.getRegisterRequest;

//import void dto.RegisterResDto.setToken;
import static steps.Steps.assertStatusCode;
import static steps.Steps.checkFieldValue;

@Epic("QaRepka")
@Feature("Ivanov project")
@Story("Allure")
@Owner("Vlad Ivanov")
@ExtendWith(AllureJunit5.class)
@DisplayName("Suit 1")
public class PostRegisterTest {
    RegisterReqDto registerReqDto = getRegisterRequest();

    @BeforeAll
    public static void preCondition(){
        System.out.println("ОБЩИЕ ПРЕДУСЛОВИЯ");
    }

    @BeforeEach
    public void preConditions(){
        System.out.println("ПРЕДУСЛОВИЯ ПЕРЕД КАЖДЫМ ТЕСТОМ");
    }

    @AfterEach
    public void postConditions(){
        System.out.println("ПОСТУСЛОВИЯ ПОСЛЕ КАЖДОГО ТЕСТА");
    }

    @AfterAll
    public static void postCondition(){
        System.out.println("ОБЩИЕ ПОСТУСЛОВИЯ");
    }

    @Test
    @Disabled
    @DisplayName("Первый тест")
    void postRegisterTest(){
        Response postResponse = postRegister(registerReqDto);
        assert postResponse.path("id").toString().equals("4");
        assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        assertNotNull(postResponse.path("id").toString());
        assertNotNull(postResponse.path("token").toString());
    }

    @Test
    @Order(1)
    @DisplayName("Второй тест")
    void postRegisterTestTwo(){
        Response postResponse = postRegister(registerReqDto);
        // assert postResponse.path("id").toString().equals("4");
        // assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        // assertNotNull(postResponse.path("id").toString());
        // assertNotNull(postResponse.path("token").toString());

        step("Проверяем ответ на запрос", () -> {
            assertStatusCode(postResponse, 400);
            checkFieldValue(postResponse, "error", "user not found");
        });
    }

    @Test
    @Order(0)
    @DisplayName("Третий тест")
    void postRegisterTestThree(){
        Response postResponse = postRegister(registerReqDto);
        // assert postResponse.path("id").toString().equals("4");
        // assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        assertNotNull(postResponse.path("id").toString());
        assertNotNull(postResponse.path("token").toString());
    }
}
