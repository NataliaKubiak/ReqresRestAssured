package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserTest extends BaseTest {

    @Test
    public void testCreateUser() {
        Response response = createUser();
        response.print();

        Assert.assertEquals(response.getStatusCode(), 201,
                "Create User Response Status Code is not 201 but it should be");

        SoftAssert softAssert = new SoftAssert();

        String actualName = response.jsonPath().getString("name");
        softAssert.assertEquals(actualName, "Jim", "The name of created user is not as expected");

        String actualJob = response.jsonPath().getString("job");
        softAssert.assertEquals(actualJob, "teacher", "Job of created user is not as expected");

        softAssert.assertAll();
    }
}
