package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class exchangeBankSummary extends DriverCreation
{
    @Test
    public void BankSummary()
    {
//        String str = given().when().header("Authorization", apikey).
//                then().get("/user/exchange/bank/summary").
//                jsonPath().get("message.bankLinkStatus");
////                getBody().print();
//        System.out.println("BankLinkStatus : " + str);

        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/bank/summary");
        String str=response.jsonPath().get("message.bankLinkStatus");
        System.out.println("BankLinkStatus : " +str);
        if(str.equals("Incomplete")) {
            Float coinfee = response.jsonPath().getFloat("message.coinFeePercentage");
            Float fiatfee = response.jsonPath().getFloat("message.fiatFeePercentage");
            Assert.assertEquals("0.6", coinfee.toString(), "Bank link is incomplete so 0.6 percent");
            Assert.assertEquals("0.6", fiatfee.toString());
            System.out.println("successful");
        }
        else{
            Float coinfee = response.jsonPath().getFloat("message.coinFeePercentage");
            Float fiatfee = response.jsonPath().getFloat("message.fiatFeePercentage");
            Assert.assertEquals("0.4", coinfee.toString(), "Bank link is complete so 0.4 percent");
            Assert.assertEquals("0.4", fiatfee.toString());
            System.out.println("successful");
        }
    }
}
