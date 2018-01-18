package WalletActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletCoinWithdrawSendToExchange extends DriverCreation
{
    @Test
    public void CoinWithdrawSendToExchage()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("amt","1");
        requestparms.put("walletID", "ll1kvbH8C92dwdYlQURF");
        requestparms.put("msg","Testing");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/wallet/coin/withdraw/sendToExchange");
        response.then().log().status();
        response.getBody().print();
    }
}
