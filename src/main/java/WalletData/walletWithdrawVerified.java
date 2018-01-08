package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

@Test
public class walletWithdrawVerified extends DriverCreation
{
    public void WithdrawVerified()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/wallet/coin/withdraw/verified");
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
