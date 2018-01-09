package BlockchainTools;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bitcoinSearchConfirmationTxid extends DriverCreation
{
    @Test
    public void SearchConfirmationTxid()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("txid","1234").
                get("/bitcoin/search/confirmation/{txid}");
        response.then().log().status();
        response.getBody().print();
    }
}
