package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class referralFiatPaid extends DriverCreation
{
    @Test
    public void FiatPaid()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/referral/fiat/paid");
        response.then().log().status();
        response.getBody().print();
//        response.jsonPath().getInt("message.refPercent");
    }
}
