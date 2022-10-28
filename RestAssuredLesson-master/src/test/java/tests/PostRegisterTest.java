package tests;

import dto.RegisterReqDto;
import dto.RegisterResDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static methods.RegisterTestRestAssured.postRegister;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static util.RegisterReqFactory.getRegisterRequest;

//import void dto.RegisterResDto.setToken;

public class PostRegisterTest {
    RegisterReqDto registerReqDto = getRegisterRequest();
//  RegisterResDto registerResDto = getRegisterRequest();

    @Test
    void postRegisterTest(){
        Response postResponse = postRegister(registerReqDto);
        assert postResponse.path("id").toString().equals("4");
        assert postResponse.path("token").toString().equals("QpwL5tke4Pnpja7X4");

        assertNotNull(postResponse.path("id").toString());
        assertNotNull(postResponse.path("token").toString());
    }
}
