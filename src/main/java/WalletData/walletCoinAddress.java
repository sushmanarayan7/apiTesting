package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletCoinAddress extends DriverCreation
{
    @Test
    public void CoinAddress()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.pathParam("walletID","ll1kvbH8C92dwdYlQURF").header("Authorization",apikey).get("/user/wallet/coin/address/{walletID}");
        response.then() .log().status();
        response.getBody().print();
    }
}
