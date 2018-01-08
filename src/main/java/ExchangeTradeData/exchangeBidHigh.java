package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeBidHigh extends DriverCreation
{
    @Test
    public void BidHigh()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/bid/high");
        response.then().log().status();
        response.getBody().print();
        long val=(int)response.then().extract().path("message.rate");
        System.out.println(val);
    }
}
