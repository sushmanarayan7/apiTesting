package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class referralCoinPaid extends DriverCreation
{
    @Test
    public void CoinPaid()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/referral/coin/paid");
        response.then().log().status();
        response.getBody().print();
//        response.jsonPath().getDouble("message.refPercent");
    }
}
