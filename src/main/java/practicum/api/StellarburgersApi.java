package practicum.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public abstract class StellarburgersApi {

    private String pathCreateUser = "/api/auth/register";
    private String pathLogInUser = "/api/auth/login";
    private String pathDeleteLogInUser = "/api/auth/user";
    private String standartUser = "{\n\"email\": \"testdmit@test.com\",\n\"password\": \"123456\",\n\"name\": \"testdmituser\"\n}";

    private final RequestSpecification baseRequestSpec = new RequestSpecBuilder()
            .setBaseUri("https://stellarburgers.nomoreparties.site")
            .addHeader("Content-type", "application/json")
            .setRelaxedHTTPSValidation()
            .addFilter(new RequestLoggingFilter())
            .addFilter(new ResponseLoggingFilter())
            .addFilter(new ErrorLoggingFilter())
            .build();

    protected Response createUser() {
        return given()
                .spec(baseRequestSpec)
                .body(standartUser)
                .post(pathCreateUser)
                .thenReturn();
    }

    protected Response logInUser() {
        return given()
                .spec(baseRequestSpec)
                .body(standartUser)
                .post(pathLogInUser)
                .thenReturn();
    }

    protected Response deleteUser(String token) {
        return given()
                .spec(baseRequestSpec)
                .header("Authorization", token)
                .delete(pathDeleteLogInUser)
                .thenReturn();
    }
}
