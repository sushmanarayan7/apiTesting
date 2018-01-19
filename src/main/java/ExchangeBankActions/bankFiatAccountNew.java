package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatAccountNew extends DriverCreation
{
    @Test
    public void FiatAccountNew()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("acct_nick","Test");
        requestparms.put("name","Testing");
        requestparms.put("ban","Dena Bank");
        requestparms.put("ifsc","BKDN201632");
        requestparms.put("message","Testing");
        requestparms.put("banType","Savings Account");
        requestparms.put("phone","8792090543");
        requestparms.put("otp","123456");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/bank/fiat/account/new");
        response.then().log().status();
        response.getBody().print();
    }
}
