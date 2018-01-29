package ExchangeTradeActions;

import base.DriverCreation;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Driver;
import java.util.Scanner;

import static locators.apiKey.apikey;

public class exchangeInstantBuy extends DriverCreation
{
    @Test
    public void InstantBuy() throws IOException {

        RequestSpecification httpRequest = RestAssured.given();
        JSONObject requestparms= new JSONObject();
        requestparms.put("maxFiat","1000000");

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/instant/buy");
        response.then().log().status();
        response.getBody().print();
    }
}
