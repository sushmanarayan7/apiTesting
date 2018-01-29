package AccountData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;


public class referralCoinPaid extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void CoinPaid(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/user/exchange/referral/coin/paid");
        response.then().log().status();
        response.getBody().print();
//        response.jsonPath().getDouble("message.refPercent");
    }
}
