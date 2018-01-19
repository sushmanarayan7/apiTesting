package ExchangeBankActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import javafx.scene.input.Dragboard;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankCoinWithdrawNewVerifyCode extends DriverCreation
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
                post("/user/exchange/bank/coin/withdraw/newVerifycode");
        response.then().log().status();
        response.getBody().print();
    }
}
