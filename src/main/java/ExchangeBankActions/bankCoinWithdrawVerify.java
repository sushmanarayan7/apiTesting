package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankCoinWithdrawVerify extends DriverCreation
{
    @Test
    public void CoinWithdrawVerify()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("code","1234");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/bank/coin/withdraw/verify");
        response.then().log().status();
        response.getBody().print();
    }
}
