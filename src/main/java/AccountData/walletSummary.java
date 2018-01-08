package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletSummary extends DriverCreation
{
    @Test
    public void WalletSummary()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/wallet/summary");
        response.then().log().status();
//        response.getBody().print();
        String str=response.jsonPath().get("method");
        Assert.assertEquals("Exchange Bank Summary",str,"method is verified");
        String str1=response.jsonPath().getString("message");
        System.out.println(str1);
    }
}
