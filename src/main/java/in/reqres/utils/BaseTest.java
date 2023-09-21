package in.reqres.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected RequestSpecification spec;

    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in")
                .build();
    }

    protected Response createUser() {
        JSONObject body = new JSONObject();
        body.put("name", "Jim");
        body.put("job", "teacher");

        Response response = RestAssured
                .given(spec)
                .contentType(ContentType.JSON)
                .body(body.toString())
                .post("/api/users");
        return response;
    }
}
