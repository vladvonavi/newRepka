package tests;

import dto.RegisterReqDto;
import dto.RegisterResDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;


import static methods.RegisterTestRestAssured.postRegister;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.RegisterReqFactory.getRegisterRequest;

//import void dto.RegisterResDto.setToken;

public class PostRegisterTest {
    RegisterReqDto registerReqDto = getRegisterRequest();
//  RegisterResDto registerResDto = getRegisterRequest();

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
    @Order(2)
    @DisplayName("Второй тест")
    void postRegisterTest(){
        Response postResponse = postRegister(registerReqDto);
        assert postResponse.path("id").toString().equals("4");
        assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        assertNotNull(postResponse.path("id").toString());
        assertNotNull(postResponse.path("token").toString());
    }

    @Test
    @Order(1)
    @DisplayName("Третий тест")
    void postRegisterTest(){
        Response postResponse = postRegister(registerReqDto);
        assert postResponse.path("id").toString().equals("4");
        assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        assertNotNull(postResponse.path("id").toString());
        assertNotNull(postResponse.path("token").toString());
    }
}
