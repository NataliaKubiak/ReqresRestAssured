package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUserTest() {
        int userId = 3;

        Response response = RestAssured
                .given(spec)
                .delete("/api/users/" + userId);

        Assert.assertEquals(response.getStatusCode(), 204,
                "Response Status Code for Delete User is not 204");
    }
}
