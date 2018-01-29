package AccountActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
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

    }

//api testing for getting the bank otp
    @Test(dataProvider = "apiData")
    public void apigetBankotp(String key, String phonenumber) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.
                pathParam("number", phonenumber).
                parameter("key", key).
                header("Authorization", "{key}").
                when().
                get("/user/bank/otp/{number}");
        response.then().log().status();
        response.getBody().print();
    }
}
