package in.reqres;

import in.reqres.utils.BaseTest;
import in.reqres.utils.POJOs.Resource;
import in.reqres.utils.POJOs.Data;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleResourceTest extends BaseTest {

    @Test
    public void getSingleResourceTest() {
        int resourseId = 2;
        Data data = new Data(resourseId, "fuchsia rose", 2001,
                "#C74375", "17-2031");

        Response response = RestAssured
                .given(spec)
                .get("/api/unknown/" + resourseId);

        response.print();

        Resource resource = response.as(Resource.class);
        System.out.println("Response: " + resource.getData().toString());

        Assert.assertEquals(response.getStatusCode(), 200,
                "Response Status Code for Get Single Resource is not 200");

        Assert.assertEquals(resource.getData().toString(), data.toString());
    }
}
