package practicum.api;

public class UserActionPrepare extends StellarburgersApi {

    public void createUserIfNonExists() {
        if (!checkIfUserExists()) {
            createUser().then().statusCode(200);
        }
    }

    private String getUserToken() {
        return logInUser().jsonPath().getString("accessToken");
    }

    public void deleteUserIfExists() {
        if (checkIfUserExists()) {
            deleteUser(getUserToken()).then().statusCode(202);
        }
    }

    private boolean checkIfUserExists() {
        return !(getUserToken() == null);
    }
}
