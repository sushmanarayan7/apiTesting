package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import static locators.apiKey.apikey;

public class walletDepositeUnconfirmedAll extends DriverCreation
{
    public void DepositeUnconfirmedAll()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/wallet/coin/deposit/unconfirmed/all");
        response.then().statusCode(200).log().status();
        response.getBody().print();
    }
}
