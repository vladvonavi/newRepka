package methods;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RegisterTestRestAssured {
    @Test
    public static Response postRegister(Object body){
        RestAssured.baseURI = "https://reqres.in/api";
        ObjectMapper objectMapper = new ObjectMapper();
        return given()
                .log()
                .all()
                .when()
                .header("Content-type", "application/json")
                .and()
                .body(objectMapper.valueToTree(body))
                .post("/register")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}