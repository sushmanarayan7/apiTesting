package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

//import static apiTestCases.apiTest.apikey;

public class referrals extends DriverCreation
{
    @Test
    public void referral()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/referrals");
        response.then().log().status();
        response.getBody().print();
        Integer percent=response.then().extract().path("message[0].refPercent");
//        String str=response.jsonPath().getString("message.refPercent");
        Assert.assertEquals("10",percent.toString());
        String str=response.then().extract().path("message[0].refID");
        System.out.println(str);
    }
}
