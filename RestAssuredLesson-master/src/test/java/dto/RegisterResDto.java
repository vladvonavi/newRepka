package dto;

/*
{
"id": "";
"token": ""
}
*/
import lombok.Data;

@Data
public class RegisterResDto {
    String id;
    String token;

    public void setId(String id){
        this.id=id;
    }

    public void setToken(String token){
        this.token=token;
    }
}