package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class referralCoinSuccess extends DriverCreation
{
    @Test
    public void CoinSuccess()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/referral/coin/successful");
        response.then().log().status();
        response.getBody().print();
//        response.jsonPath().getInt("message.refPercent");
    }
}
