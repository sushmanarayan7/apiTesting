package AccountData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

//import static apiTestCases.apiTest.apikey;

public class referrals extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void referral(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/referrals");
        response.then().log().status();
        response.getBody().print();

//        Integer percent=response.then().extract().path("message[0].refPercent");
////        String str=response.jsonPath().getString("message.refPercent");
//        Assert.assertEquals("10",percent.toString());
//        String str=response.then().extract().path("message[0].refID");
//        System.out.println(str);
    }
}
