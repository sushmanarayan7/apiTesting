package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class exchangeKycs extends DriverCreation
{
    @Test
    public void Kycs()
    {

        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/kycs");
        response.then().log().status();
        response.getBody().print();
        if(response.jsonPath().get("message.status").equals("verified"))
        {
            System.out.println("Kyc is verified");
        }
        else{
            System.out.println("Kyc is unverified");
        }
    }
}
