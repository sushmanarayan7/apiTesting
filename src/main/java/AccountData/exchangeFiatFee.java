package AccountData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class exchangeFiatFee extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void FiatFee(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/fiat/fee");
        response.then().log().status();
        response.getBody().print();

//        Float percentvalue=response.jsonPath().getFloat("message.percent");
//        System.out.println("Fiat fee in percent : "+percentvalue);
//        if(percentvalue.toString().equals("0.6"))
//        {
//            System.out.println("Kyc is incomplete and Fiat fee is 0.6 percent");
//        }
//        else {
//            System.out.println("Fiat fee is "+percentvalue);
//        }
    }
}
