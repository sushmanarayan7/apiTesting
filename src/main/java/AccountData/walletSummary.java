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

public class walletSummary extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void WalletSummary(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/wallet/summary");
        response.then().log().status();
        response.getBody().print();

//        String str=response.jsonPath().get("method");
//        Assert.assertEquals("Exchange Bank Summary",str,"method is verified");
//        String str1=response.jsonPath().getString("message");
//        System.out.println(str1);
    }
}
