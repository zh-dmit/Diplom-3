package practicum.api;

public class UserActionPrepare {

    private final StellarburgersApi stellarburgersApi;

    public UserActionPrepare(StellarburgersApi stellarburgersApi) {
        this.stellarburgersApi = stellarburgersApi;
    }

    public void createUserIfNonExists() {
        if (!checkIfUserExists()) {
            stellarburgersApi.createUser().then().statusCode(200);
        }
    }

    private String getUserToken() {
        return stellarburgersApi.logInUser().jsonPath().getString("accessToken");
    }

    public void deleteUserIfExists() {
        if (checkIfUserExists()) {
            stellarburgersApi.deleteUser(getUserToken()).then().statusCode(202);
        }
    }

    private boolean checkIfUserExists() {
        return !(getUserToken() == null);
    }
}
