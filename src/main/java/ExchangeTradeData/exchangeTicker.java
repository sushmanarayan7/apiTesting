package ExchangeTradeData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class exchangeTicker extends DriverCreation
{
    @Test
    public void Ticker()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.get("/exchange/ticker");
        response.then().log().status();
        response.getBody().print();
        response.then().assertThat().body("count",equalTo(9));
    }
}
