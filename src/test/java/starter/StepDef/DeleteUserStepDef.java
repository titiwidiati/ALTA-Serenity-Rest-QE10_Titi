package starter.StepDef;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

public class DeleteUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Delete user with exceed id {int}")
    public void deleteUserWithInvalidId(int id) {
        reqresAPI.deleteUserWithInvalidId(id);
    }
}
