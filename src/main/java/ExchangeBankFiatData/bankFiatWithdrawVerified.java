package ExchangeBankFiatData;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatWithdrawVerified extends DriverCreation
{
    @Test
    public void FiatWithdrawVerified()
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).queryParameter("from",1539146092).
                queryParameter("max",10).queryParameter("offset",3).
                get("/user/exchange/bank/fiat/withdraw/verified");
        response.then().log().status();
        response.getBody().print();
//        String withdrawID=response.then().extract().path("message.withdrawID");
//        System.out.println(withdrawID);
    }
}
