package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeLastTrade extends DriverCreation
{
    @Test
    public void LastTrade()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/lastTrade");
        response.then().log().status();
        response.getBody().print();
        String str=response.jsonPath().getString("message");
        System.out.println(str);
    }
}
