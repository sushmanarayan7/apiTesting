package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeTrades extends DriverCreation
{
    @Test
    public void Trades()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/trades");
        response.then().statusCode(200).log().status();
        response.getBody().print();
    }
}
