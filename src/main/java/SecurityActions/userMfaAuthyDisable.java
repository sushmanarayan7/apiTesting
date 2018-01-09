package SecurityActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class userMfaAuthyDisable extends DriverCreation
{
    @Test
    public void MfaAuthyDisable()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("code","1234").
                delete("/user/mfa/authy/disable/{code}");
        response.then().log().status();
        response.getBody().print();
    }
}
