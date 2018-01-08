package ExchangeBankFiatData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatBalancePending extends DriverCreation
{
    @Test
    public void FiatBalancePending()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/bank/fiat/balance/pending");
        response.then().log().status();
        response.getBody().print();
        long val=(int)response.then().extract().path("message.rate");
        System.out.println(val);
    }
}