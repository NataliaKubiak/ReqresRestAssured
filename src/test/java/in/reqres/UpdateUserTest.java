package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUserPUTTest() {
        JSONObject body = new JSONObject();
        body.put("name", "Tom");
        body.put("job", "engineer");

        int userId = 2;

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .put("/api/users/" + userId);

        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Update User is not 200");

        SoftAssert softAssert = new SoftAssert();

        String actualName = response.jsonPath().getString("name");
        softAssert.assertEquals(actualName, "Tom");

        String actualJob = response.jsonPath().getString("job");
        softAssert.assertEquals(actualJob, "engineer");
    }

    @Test
    public void updateUserPATCHTest() {
        JSONObject body = new JSONObject();
        body.put("name", "Tom");
        body.put("job", "engineer");

        int userId = 5;

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .patch("/api/users/" + userId);

        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Update User is not 200");

        SoftAssert softAssert = new SoftAssert();

        String actualName = response.jsonPath().getString("name");
        softAssert.assertEquals(actualName, "Tom");

        String actualJob = response.jsonPath().getString("job");
        softAssert.assertEquals(actualJob, "engineer");
    }
}
