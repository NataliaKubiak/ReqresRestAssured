package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleUserTest extends BaseTest {

    @Test
    public void getSingleUserTest() {
        int userId = 4;

        Response response = RestAssured
                .given(spec)
                .get("/api/users/" + userId);

        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Get Single User is not 200");

        int actualId = response.jsonPath().getInt("data.id");
        Assert.assertEquals(actualId, userId, "Actual User ID is not as expected");
    }

    @Test
    public void getSingleUserNotFoundTest() {
        int userId = 44;

        Response response = RestAssured
                .given(spec)
                .get("/api/users/" + userId);

        response.print();

        Assert.assertEquals(response.getStatusCode(), 404,
                "Response Status Code for Get Not Found User is not 404");
    }
}
