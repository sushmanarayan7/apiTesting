package WalletActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletCoinWithdrawNewVerifyCode extends DriverCreation
{
    @Test
    public void CoinWithdrawNewVerifyCode()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("withdrawID","ll1kvbH8C92dwdYlQURF");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                post("/wallet/coin/withdraw/newVerifycode");
        response.then().log().status();
        response.getBody().print();
    }
}
