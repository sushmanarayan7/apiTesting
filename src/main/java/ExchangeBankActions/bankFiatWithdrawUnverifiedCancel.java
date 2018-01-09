package ExchangeBankActions;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatWithdrawUnverifiedCancel
{
    @Test
    public void FiatWithdrawUnverifiedCancel()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("withdrawID","1234").
                delete("/user/exchange/bank/fiat/withdraw/unverified/cancel/{withdrawID}");
        response.then().log().status();
        response.getBody().print();
    }
}
