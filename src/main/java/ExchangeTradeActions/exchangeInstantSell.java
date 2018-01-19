package ExchangeTradeActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class exchangeInstantSell extends DriverCreation
{
    @Test
    public void InstabtSell()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("maxVol","1000011");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/instant/sell");
        response.then().log().status();
        response.getBody().print();
    }
}
