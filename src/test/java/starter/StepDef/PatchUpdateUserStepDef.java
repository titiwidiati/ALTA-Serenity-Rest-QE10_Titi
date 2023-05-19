package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

public class PatchUpdateUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch update user with valid json and id {int}")
    public void patchUpdateUserWithValidJsonAndId(int id) {
        File json = new File(Constants.REQ_BODY_DIR+"UpdateUserBody.json");
        reqresAPI.patchUpdateUser(id, json);
    }
}
