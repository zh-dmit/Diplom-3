package practicum.api;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StellarburgersApi {

    Faker faker = new Faker();

    private String pathCreateUser = "/api/auth/register";
    private String pathLogInUser = "/api/auth/login";
    private String pathDeleteLogInUser = "/api/auth/user";
    private String userEmail;
    private String userPassword;
    private String userWrongPassword;
    private String userName;

    public void generateUserData() {
        this.userEmail = faker.internet().emailAddress();
        this.userPassword = faker.internet().password(6, 7, true, true, true);
        this.userWrongPassword = faker.internet().password(4, 5, true, true, true);
        this.userName = faker.name().firstName();
    }

    public String getStandartUserJson() {
        return String.format(
                "{\"email\": \"%s\", \"password\": \"%s\", \"name\": \"%s\"}",
                userEmail, userPassword, userName
        );
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserWrongPassword() {
        return userWrongPassword;
    }

    public String getUserName() {
        return userName;
    }

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
                .body(getStandartUserJson())
                .post(pathCreateUser)
                .thenReturn();
    }

    protected Response logInUser() {
        return given()
                .spec(baseRequestSpec)
                .body(getStandartUserJson())
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
