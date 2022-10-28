package util;

import dto.RegisterReqDto;

public class RegisterReqFactory {
    private RegisterReqFactory(){}

    public static RegisterReqDto getRegisterRequest(){
        RegisterReqDto registerReqDto = new RegisterReqDto();
        registerReqDto.setEmail("eve.holt@reqres.in");
        registerReqDto.setPassword("pistol");
        return registerReqDto;
    }
}
