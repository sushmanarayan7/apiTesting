package AccountActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class userGcmCode extends DriverCreation
{
    @Test
    public void GcmCode()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("code","1234").delete("/user/gcm/{code}");
        response.then().log().status();
        response.getBody().print();

    }
}
