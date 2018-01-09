package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatDepositCancel extends DriverCreation
{
    @Test
    public void FiatDepositCancel()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("depositID","1234").
                delete("/user/exchange/bank/fiat/deposit/cancel/{depositID}");
        response.then().log().status();
        response.getBody().print();
    }
}
