package AccountActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class userLogout extends DriverCreation
{
    @Test
    public void UserLogout()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).delete("/user/logout");
        response.then().log().status();
        response.getBody().print();
    }
}
