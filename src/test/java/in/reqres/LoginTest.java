package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginPOSTTest() {
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");
        body.put("password", "cityslicka");

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/api/login");
        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response status code for login user is not 200");
    }

    @Test
    public void unsuccessfulLoginNoEmailPOSTTest() {
        JSONObject body = new JSONObject();
        body.put("password", "cityslicka");

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/api/login");
        response.print();

        Assert.assertEquals(response.getStatusCode(), 400,
                "Response status code for unsuccessful login is not 400");

        String actualErrorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(actualErrorMessage, "Missing email or username");
    }

    @Test
    public void unsuccessfulLoginNoPasswordPOSTTes() {
        JSONObject body = new JSONObject();
        body.put("email", "eve.holt@reqres.in");

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/api/login");
        response.print();

        Assert.assertEquals(response.getStatusCode(), 400,
                "Response status code for unsuccessful login is not 400");

        String actualErrorMessage = response.jsonPath().getString("error");
        Assert.assertEquals(actualErrorMessage, "Missing password");
    }
}
