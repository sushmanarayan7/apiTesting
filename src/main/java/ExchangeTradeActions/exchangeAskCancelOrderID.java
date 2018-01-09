package ExchangeTradeActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class exchangeAskCancelOrderID extends DriverCreation
{
    @Test
    public void AskCancelOrderID()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("orderID","1234").
                delete("/user/exchange/ask/cancel/{orderID}");
        response.then().log().status();
        response.getBody().print();
    }
}
