package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeLegacyTicker extends DriverCreation
{
    @Test
    public void LegacyTicker()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/legacyTicker");
        response.then().log().status();
        response.getBody().print();
        String str=response.jsonPath().getString("message");
        System.out.println(str);
    }
}
