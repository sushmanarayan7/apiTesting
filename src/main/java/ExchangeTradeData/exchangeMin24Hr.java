package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class exchangeMin24Hr extends DriverCreation
{
    @Test
    public void Min24Hr()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/min24Hr");
        response.then().log().status();
        response.getBody().print();
//        String str=response.jsonPath().getString("message");
//        System.out.println(str);
    }
}
