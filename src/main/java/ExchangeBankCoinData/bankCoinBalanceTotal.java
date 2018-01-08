package ExchangeBankCoinData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankCoinBalanceTotal extends DriverCreation
{
    @Test
    public  void CoinBalanceTotal()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/bank/coin/balance/total");
        response.then().log().status();
        response.getBody().print();
        long val=(int)response.then().extract().path("message.vol");
        System.out.println(val);
    }
}
