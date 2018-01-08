package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeMax24Hr extends DriverCreation
{
    @Test
    public void Max24Hr()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/max24Hr");
        response.then().log().status();
        response.getBody().print();
        String str=response.jsonPath().getString("message");
        System.out.println(str);
    }
}
