package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class exchangeAskOrders extends DriverCreation
{
    @Test
    public void askorders()
    {
        int value=20;
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.queryParameter("max",value).get("/exchange/ask/orders");
        response.then().log().status();
        response.getBody().print();
//        response.then().assertThat().body("count",equalTo(value));
    }
}
