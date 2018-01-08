package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class userBankotp extends DriverCreation
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

//api testing for getting the bank otp
    @Test(dataProvider = "apiData")
    public void apigetBankotp(String key, String phonenumber) {
        given().
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/bank/otp/{number}").
                then().
                statusCode(200).log().body();


    }
}
