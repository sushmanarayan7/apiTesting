package SecurityActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class mfaAuthySms extends DriverCreation
{
    @Test
    public void AuthySms()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/mfa/authy/sms");
        response.then().statusCode(200).log().status();
        response.getBody().print();
        String str=response.then().extract().path("message");
        Assert.assertEquals("true",str);
    }
}
