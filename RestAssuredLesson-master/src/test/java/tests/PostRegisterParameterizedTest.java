package tests;

import dto.RegisterReqDto;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.util.stream.Stream;

import static methods.RegisterTestRestAssured.postRegister;
import static steps.Steps.checkFieldNotNull;
import static steps.Steps.checkFieldValue;
import static util.RegisterReqFactory.getRegisterRequest;

public class PostRegisterParameterizedTest {
    RegisterReqDto registerReqDto = getRegisterRequest();

    @ParameterizedTest(name="Проверка токена для email \"{0}\"")
    @ValueSource(strings={"sobaka@ya.ru", "123456"})
    void postValueSourceTest(String email){
        registerReqDto.setEmail(email);
        Response postResponse = postRegister(registerReqDto);
        //checkFieldValue(postResponse,"email", registerReqDto.getEmail());
        checkFieldNotNull(postResponse, "error");
        checkFieldValue(postResponse,"error", "Note: Only defined users succeed registration");
    }

    @ParameterizedTest(name="Проверка токена для email \"{0}\" и паролем \"{1}\"")
    @CsvSource(value={"sobaka@ya.ru ; 123456", "kot@gmail.com ; 654321"}, delimiter = ';')
    void postCsvSourceTest(String email, String password){
        registerReqDto.setEmail(email);
        registerReqDto.setPassword(password);
        Response postResponse = postRegister(registerReqDto);
        //checkFieldValue(postResponse,"email", registerReqDto.getEmail());
        checkFieldNotNull(postResponse, "error");
        checkFieldValue(postResponse,"error", "Note: Only defined users succeed registration");
    }

    @ParameterizedTest(name="Проверка токена для email \"{0}\" и паролем \"{1}\"")
    @EnumSource(RegisterRequestParams.class)
    void postEnumTest(RegisterRequestParams registerRequestParams){
        registerReqDto.setEmail(String.valueOf(registerRequestParams.Email));
        registerReqDto.setPassword(String.valueOf(registerRequestParams.Password));
        Response postResponse = postRegister(registerReqDto);
        //checkFieldValue(postResponse,"email", registerReqDto.getEmail());
        checkFieldNotNull(postResponse, "error");
        checkFieldValue(postResponse,"error", "Note: Only defined users succeed registration");
    }

    //public static Stream<Arguments> requestsObjects(){
   //     return Stream.of(
   //             Arguments.of(registerDto, registerDto.getEmail())
   //     );
   // }

   // @ParameterizedTest(name="Провека токена для email {1}")
   // @MethodSource("requestsObjects")
   // void postMethodSourceTest(RegisterReqDto registerReqDto, String email){
   //     registerReqDto.setEmail(email);
   //     postRegister(registerReqDto);
   // }
}


