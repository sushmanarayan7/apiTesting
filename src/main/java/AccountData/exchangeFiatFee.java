package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class exchangeFiatFee extends DriverCreation
{
    @Test
    public void FiatFee()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/fiat/fee");
        Float percentvalue=response.jsonPath().getFloat("message.percent");
        System.out.println("Fiat fee in percent : "+percentvalue);
        if(percentvalue.toString().equals("0.6"))
        {
            System.out.println("Kyc is incomplete and Fiat fee is 0.6 percent");
        }
        else {
            System.out.println("Fiat fee is "+percentvalue);
        }
    }
}
