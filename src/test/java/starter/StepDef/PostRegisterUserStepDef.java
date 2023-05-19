package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class PostRegisterUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with valid json")
    public void postRegisterUserWithValidJson(){
        File json = new File(Constants.REQ_BODY_DIR+"RegisterValidBody.json");
        reqresAPI.postRegisterUserWithValidJson(json);
    }

    @When("Send post register user")
    public void sendPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.POST_REGISTER_USER);
    }

    @And("Response body id should be {int} and token should be {string}")
    public void responseBodyIdShouldBeAndTokenShouldBe(int id, String token) {
        SerenityRest.and().body(ReqresResponses.ID, equalTo(id)).body(ReqresResponses.TOKEN, equalTo(token));
    }

    @And("Validate register user JSON Schema")
    public void validateRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"ValidRegisterUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post register user with invalid json")
    public void postRegisterUserWithInvalidJson() {
        File json = new File(Constants.REQ_BODY_DIR+"RegisterInvalidBody.json");
        reqresAPI.postRegisterUserWithInvalidJson(json);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int badRequest) {
        SerenityRest.then().statusCode(badRequest);
    }

    @And("Validate invalid register user JSON Schema")
    public void validateInvalidRegisterUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"InvalidRegisterUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
