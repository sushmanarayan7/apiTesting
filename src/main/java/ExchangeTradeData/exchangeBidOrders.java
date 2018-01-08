package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class    exchangeBidOrders extends DriverCreation
{
    @Test
    public void BidOrders()
    {
        int value=1;
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.queryParameter("max",value).get("/exchange/bid/orders");
        response.then().log().status();
        response.getBody().print();
        response.then().assertThat().body("count",equalTo(value));
    }
}
