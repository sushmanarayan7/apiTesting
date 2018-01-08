package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class exchangeBidPending extends DriverCreation
{
    @Test
    public void BidPending()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).queryParameter("from",1539146092).
                queryParameter("max",10).queryParameter("offset",3).
                get("/user/exchange/bid/pending");
        response.then().log().status();
        response.getBody().print();
    }
}