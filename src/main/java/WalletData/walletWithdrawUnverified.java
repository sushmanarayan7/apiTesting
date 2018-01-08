package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletWithdrawUnverified extends DriverCreation
{
    @Test
    public void WithdrawUnverified()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/wallet/coin/withdraw/unverified");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String withdrawid=response.then().extract().path("message.withdrawID");
//        System.out.println(withdrawid);
//        String sentto=response.then().extract().path("message.sentTo");
//        System.out.println(sentto);
    }
}
