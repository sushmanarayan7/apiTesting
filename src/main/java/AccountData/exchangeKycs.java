package AccountData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

//gets the user kyc status
public class exchangeKycs extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void Kycs(String key)
    {

        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/kycs");
        response.then().log().status();
        response.getBody().print();
//        if(response.jsonPath().get("message.status").equals("verified"))
//        {
//            System.out.println("Kyc is verified");
//        }
//        else{
//            System.out.println("Kyc is unverified");
//        }
    }
}
