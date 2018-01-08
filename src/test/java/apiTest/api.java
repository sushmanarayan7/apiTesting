package apiTest;

import base.DriverCreation;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class api extends DriverCreation
{
    @Test
    public void apiRoute()
    {
        given().when().get("/home").then().statusCode(200).log().status();
    }
}
