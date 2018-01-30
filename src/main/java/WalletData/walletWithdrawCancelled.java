package WalletData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletWithdrawCancelled extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","apiKey");
    }

    @Test(dataProvider="apiData")
    public void Withdrawancelled(String key)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.parameter("key", key).header("Authorization","{key}").get("/wallet/coin/withdraw/cancelled");
        response.then().statusCode(200).log().status();
        response.getBody().print();

//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String walletaddres=response.then().extract().path("message.address");
//        System.out.println(walletaddres);
//        String withdrawid=response.then().extract().path("message.withdrawID");
//        System.out.println(withdrawid);
//        String sentto=response.then().extract().path("message.sentTo");
//        System.out.println(sentto);
    }
}
