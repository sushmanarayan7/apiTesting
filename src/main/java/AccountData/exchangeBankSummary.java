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


public class exchangeBankSummary extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void BankSummary(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/bank/summary");
        response.then().log().status();
        response.getBody().print();

//        String str=response.jsonPath().get("message.bankLinkStatus");
//        System.out.println("BankLinkStatus : " +str);
//        if(str.equals("Incomplete")) {
//            Float coinfee = response.jsonPath().getFloat("message.coinFeePercentage");
//            Float fiatfee = response.jsonPath().getFloat("message.fiatFeePercentage");
//            Assert.assertEquals("0.6", coinfee.toString(), "Bank link is incomplete so 0.6 percent");
//            Assert.assertEquals("0.6", fiatfee.toString());
//            System.out.println("successful");
//        }
//        else{
//            Float coinfee = response.jsonPath().getFloat("message.coinFeePercentage");
//            Float fiatfee = response.jsonPath().getFloat("message.fiatFeePercentage");
//            Assert.assertEquals("0.4", coinfee.toString(), "Bank link is complete so 0.4 percent");
//            Assert.assertEquals("0.4", fiatfee.toString());
//            System.out.println("successful");
//        }
    }
}
