package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class    exchangeAskLow extends DriverCreation
{
    @Test
    public void AskLow()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/ask/low");
        response.then().log().status();
        response.getBody().print();
        long val=(int)response.then().extract().path("message.rate");
        System.out.println(val);

    }
}
