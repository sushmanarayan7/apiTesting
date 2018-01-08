package AccountActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class userProfilePhoneDelete extends DriverCreation
{
    @Test
    public void ProfilePhoneDelete()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/wallet/coin/withdraw/unverified");
    }
}
