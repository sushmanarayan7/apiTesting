package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class userKycOtp extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","api");
    }


    //api testing for getting the KYC otp
@Test(dataProvider="apiData")
    public void apigetKYCotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/kyc/otp/{number}").
                then().log().status().log().body();
    }
}
