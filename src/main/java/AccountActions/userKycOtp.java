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
//        return new String[][]{
//                {"LaGTXdtMACLYviUe5Is6AB661Lslnded6BmX7eZD", "8792090543"}};
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
                then().
                statusCode(200).log().body();
        System.out.println("Successful Response");
    }
}
