package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;


public class ReqresAPI {
    public static String GET_LIST_USERS = Constants.BASE_URL+"/api/users?page={page}";

    public static String POST_CREATE_USER = Constants.BASE_URL+"/api/users";

    public static String PUT_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String DELETE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String GET_SINGLE_USER = Constants.BASE_URL+"/api/users/{id}";

    public static String POST_REGISTER_USER = Constants.BASE_URL+"/api/register";

    public static String POST_LOGIN_USER = Constants.BASE_URL+"/api/login";

    public static String PATCH_UPDATE_USER = Constants.BASE_URL+"/api/users/{id}";

    @Step("Get lists user with valid parameter page")
    public void getListUsersValidParamPage(int page){
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user with valid parameter ID")
    public void getSingleUserValidId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Get single user with invalid parameter ID")
    public void getSingleUserInvalidId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post register user with valid json")
    public void postRegisterUserWithValidJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post login user with valid json")
    public void postLoginUserWithValidJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post login user with invalid json")
    public void postLoginUserWithInvalidJson(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Put update user with invalid id and invalid json")
    public void putUpdateUserWithInvalidIdAndJson(String id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }

    @Step("Delete user with invalid id")
    public void deleteUserWithInvalidId(int id){
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Patch update user with valid id")
    public void patchUpdateUser(int id, File json){
        SerenityRest.given().pathParam("id", id).contentType(ContentType.JSON).body(json);
    }
}
