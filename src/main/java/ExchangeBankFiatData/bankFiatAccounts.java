package ExchangeBankFiatData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatAccounts extends DriverCreation
{
    @Test
    public void FiatAccounts()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/bank/fiat/accounts");
        response.then().log().status();
        response.getBody().print();
    }
}
