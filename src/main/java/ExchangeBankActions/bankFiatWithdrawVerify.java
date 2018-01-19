package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatWithdrawVerify extends DriverCreation
{
    @Test
    public void FiatWithdrawVerify()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("code","1234");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/bank/fiat/withdraw/verify");
        response.then().log().status();
        response.getBody().print();
    }
}

