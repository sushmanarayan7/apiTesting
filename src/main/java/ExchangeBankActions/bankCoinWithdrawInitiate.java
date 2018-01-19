package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

public class bankCoinWithdrawInitiate extends DriverCreation
{
    @Test
    public void CoinWirhdrawInitiate()
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("satoshis","1000000");
        requestparms.put("toAddr","1CNugRENyVP6aCbUku6TnryNEs6a41eMKF");
        requestparms.put("msg","Testing");
        requestparms.put("pin","");

        Response response=httpRequest.body(requestparms).header("Authorization","h947NqE3snlyWjznSVFW2UaBLRHzIS62CcY1KhjA").
                when().
                contentType(ContentType.JSON).
                post("/user/exchange/bank/coin/withdraw/initiate");
        response.then().log().status();
        response.getBody().print();
    }
}
