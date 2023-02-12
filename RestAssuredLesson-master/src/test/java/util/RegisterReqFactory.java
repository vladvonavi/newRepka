package util;

import com.github.javafaker.Faker;
import dto.RegisterReqDto;

import java.util.Locale;

public class RegisterReqFactory {
    private RegisterReqFactory(){}

    public static RegisterReqDto getRegisterRequest(){
        //RegisterReqDto registerReqDto = new RegisterReqDto();
        //registerReqDto.setEmail("eve.holt@reqres.in");
        //registerReqDto.setPassword("pistol");
        //return registerReqDto;

        Faker faker = new Faker(new Locale("ru"));
        RegisterReqDto registerReqDto = new RegisterReqDto();
        registerReqDto.setEmail(faker.internet().emailAddress());
        registerReqDto.setPassword(faker.internet().password());
        return registerReqDto;
    }
}