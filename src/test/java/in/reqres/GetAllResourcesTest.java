package in.reqres;

import in.reqres.utils.BaseTest;
import in.reqres.utils.POJOs.Resource;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllResourcesTest extends BaseTest {

    @Test
    public void getSingleResourceTest() {
        Response response = RestAssured
                .given(spec)
                .get("/api/unknown");

        response.print();

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Get All Resources is not 200");

        List<Resource> resourceList = response.jsonPath().getList("data.id");
        Assert.assertFalse(resourceList.isEmpty(), "List of Resources is empty but it shouldn't be");
    }
}
