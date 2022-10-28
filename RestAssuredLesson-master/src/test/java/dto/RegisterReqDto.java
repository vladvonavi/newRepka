package dto;

/*
{
"email": "";
"password": ""
}
*/

import lombok.Data;

@Data
public class RegisterReqDto {
    String email;
    String password;
}