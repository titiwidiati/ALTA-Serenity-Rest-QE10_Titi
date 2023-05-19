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

public class GetSingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get single user with valid parameter ID {int}")
    public void getSingleUserWithValidParameterID(int id) {
        reqresAPI.getSingleUserValidId(id);
    }

    @When("Send get single user")
    public void sendGetSingleUser(){
        SerenityRest.when().get(ReqresAPI.GET_SINGLE_USER);
    }

    @Given("Get single user with invalid parameter ID {int}")
    public void getSingleUserWithInvalidParameterID(int id) {
        reqresAPI.getSingleUserInvalidId(id);
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int notFound) {
        SerenityRest.then().statusCode(notFound);
    }

    @And("Response body id should be {int}")
    public void responseBodyIdShouldBe(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }

    @And("Validate get single user JSON Schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR+"SingleUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
