package in.reqres;

import in.reqres.utils.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllUsersTest extends BaseTest {

    @Test
    public void getAllUsersTest() {
        int pageNumber = 2;
        spec.queryParam("page", pageNumber);

        Response response = RestAssured
                .given(spec)
                .get("/api/users");

        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Get All Users is not 200");

        List<Integer> usersIDs = response.jsonPath().getList("data.id");
        Assert.assertFalse(usersIDs.isEmpty(), "List of Users is empty but it shouldn't be");
    }
}
