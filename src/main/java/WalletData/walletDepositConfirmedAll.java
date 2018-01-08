package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletDepositConfirmedAll extends DriverCreation
{
    @Test
    public void DepositConfirmedAll()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/wallet/coin/deposit/confirmed/all");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String walletaddres=response.then().extract().path("message.address");
//        System.out.println(walletaddres);
    }
}
