package AccountData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;
import static locators.apiKey.apikey;

public class exchangeCoinFee extends DriverCreation
{
    @Test
    public void CoinFee()
    {
//        Float feepercent=given().when().header("Authorization",apikey).then().get("/user/exchange/coin/fee").
//                jsonPath().getFloat("message.percent");
////                getBody().print();
//        System.out.println(feepercent);

        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).get("/user/exchange/coin/fee");
        Float percentvalue=response.jsonPath().getFloat("message.percent");
        System.out.println("Coin fee in percent : "+percentvalue);
        if(percentvalue.toString().equals("0.6"))
        {
            System.out.println("Kyc is incomplete and Coin fee is 0.6 percent");
        }
        else {
            System.out.println("Coin fee is "+percentvalue);
        }
    }
}
