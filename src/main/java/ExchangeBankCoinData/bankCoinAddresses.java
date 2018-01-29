package ExchangeBankCoinData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankCoinAddresses extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void CoinAddresses(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/bank/coin/addresses");
        response.then().log().status();
        response.getBody().print();

//        String address1   =response.then().extract().path("message[0].address");
//        Assert.assertEquals(address1,"12DmVLt5T9a8dHFbtteensknb498a65HqD");
//        System.out.println("Address : "+address1);
//        String address2   =response.then().extract().path("message[1].address");
//        Assert.assertEquals(address2,"1VCF1BCVtA2iZo3z29LyLTwef1tGcU7hL");
//        System.out.println("Address : "+address2);
//        String address3   =response.then().extract().path("message[2].address");
//        Assert.assertEquals(address3,"19gZrU85BS8jiNpsKT7195ykht2aD4gsmS");
//        System.out.println("Address : "+address3);
    }
}
