package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatDepositNew extends DriverCreation
{
    @Test
    public void FiatDepositNew()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("amount","10000");
        requestparms.put("message","Testing");
        requestparms.put("bank","Dena Bank");
        requestparms.put("depType","Savings Account");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/bank/fiat/deposit/new");
        response.then().log().status();
        response.getBody().print();
    }
}
