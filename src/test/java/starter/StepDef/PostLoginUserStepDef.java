package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostLoginUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid json")
    public void postLoginUserWithValidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"LoginValidBody.json");
        reqresAPI.postLoginUserWithValidJson(json);
    }

    @When("Send post login user")
    public void sendPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.POST_LOGIN_USER);
    }

    @And("Response body token should be {string}")
    public void responseBodyTokenShouldBe(String token) {
        SerenityRest.and().body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate login user JSON Schema")
    public void validateLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ValidLoginUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post login user with invalid json")
    public void postLoginUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"LoginInvalidBody.json");
        reqresAPI.postLoginUserWithInvalidJson(json);
    }
    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(error));
    }
    @And("Validate invalid login user JSON Schema")
    public void validateInvalidLoginUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"InvalidLoginUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
