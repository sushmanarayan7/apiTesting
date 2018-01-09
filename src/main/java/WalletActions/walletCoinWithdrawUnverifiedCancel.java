package WalletActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletCoinWithdrawUnverifiedCancel extends DriverCreation
{
    @Test
    public void CoinWithdrawunverifiedCancel()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("withdrawID","1234").
                delete("/user/wallet/coin/withdraw/unverified/cancel/{withdrawID}");
        response.then().log().status();
        response.getBody().print();
    }
}
