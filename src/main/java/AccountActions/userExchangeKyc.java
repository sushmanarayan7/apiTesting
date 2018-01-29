package AccountActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

public class userExchangeKyc extends DriverCreation
{
    @Test
    public void ExchangeKyc()
    {
        RequestSpecification httpRequest = RestAssured.given();
//        Map<String,String> requestparms = new HashMap<>();
        JSONObject requestparms= new JSONObject();
        requestparms.put("panNumber","AJPPL2357R");
        requestparms.put("acctNick","Test");
        requestparms.put("name","Test");
        requestparms.put("ban","209198765432176");
        requestparms.put("ifsc","SBIN0003301");
        requestparms.put("acctType","Personal");
        requestparms.put("message","Testing");
        requestparms.put("banType","Savings");
        requestparms.put("phone","8792090543");
        requestparms.put("otp","2061521");
        requestparms.put("address1","Banaswadi");
        requestparms.put("address2","Bangalore");
        requestparms.put("city","Bangalore");
        requestparms.put("state","Karnataka");
        requestparms.put("pincode","560043");

        Response response=httpRequest.header("Authorization","kpi76QrUqQzwV1nAbCJ0Rkdk9SaSXsoKPTp8Se2R").
                formParameters(requestparms).
                multiPart("file", new File("/home/coinsecure-36/Downloads/penguin.jpeg")).
//                formParam("file", "/home/coinsecure-36/Downloads/penguin.jpeg").
                contentType("multipart/form-data").
        when().
        put("/user/exchange/kyc");
        response.then().log().status();
        response.getBody().print();
    }
}
