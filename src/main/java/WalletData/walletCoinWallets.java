package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

@Test
public class walletCoinWallets extends DriverCreation
{
    public void CoinWallets()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/wallet/coin/wallets");
        response.then().statusCode(200).log().status();
        response.getBody().print();
        Integer val=response.jsonPath().getInt("count");
        for(int i=0;i<val;i++)
        {
            String path= "message.walletID["+i+"]";
            String walletid=response.then().extract().path(path);
            System.out.println(walletid);
        }
    }
}
