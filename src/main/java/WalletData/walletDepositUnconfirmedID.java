package WalletData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletDepositUnconfirmedID extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","withdrawID");
    }

    @Test(dataProvider="apiData")
    public void DepositUnconfirmedID(String withdrawID, String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.pathParam("walletID",withdrawID).header("Authorization",apikey).
                get("/user/wallet/coin/deposit/unconfirmed/{walletID}");
        response.then().statusCode(200).log().status();
        response.getBody().print();
//        String walletid=response.then().extract().path("message.walletID");
//        System.out.println(walletid);
//        String walletaddres=response.then().extract().path("message.address");
//        System.out.println(walletaddres);
    }
}
