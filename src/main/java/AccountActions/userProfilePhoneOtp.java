package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class userProfilePhoneOtp extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","api");
        }

    //api testing for getting the profile phone number otp
@Test(dataProvider="apiData")
    public void apigetProfilephnotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/profile/phone/otp/{number}").
                then().log().status().log().body();
    }
}
