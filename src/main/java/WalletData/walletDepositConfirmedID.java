package WalletData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletDepositConfirmedID extends DriverCreation
{
    @Test
    public void DepositConfirmedID()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.pathParam("walletID","ll1kvbH8C92dwdYlQURF").header("Authorization",apikey).get("/user/wallet/coin/deposit/confirmed/{walletID}");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String walletaddres=response.then().extract().path("message.address");
//        System.out.println(walletaddres);
    }
}
