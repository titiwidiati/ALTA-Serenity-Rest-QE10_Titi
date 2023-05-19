package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class PutUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Put update user with invalid id {string} and invalid json")
    public void putUpdateUserWithInvalidIdAndJson(String id) {
        File json = new File(Constants.REQ_BODY_DIR+"UpdateUserInvalidBody.json");
        reqresAPI.putUpdateUserWithInvalidIdAndJson(id, json);
    }
}
