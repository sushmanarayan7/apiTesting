package BlockchainTools;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bitcoinSearchAny extends DriverCreation
{
    @Test
    public void SearchAny()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("any","1234").
                get("/bitcoin/search/{any}");
        response.then().log().status();
        response.getBody().print();
    }
}
