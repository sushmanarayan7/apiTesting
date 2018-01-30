package WalletData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class walletCoinAddress extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","withdrawID");
    }

    @Test(dataProvider="apiData")
    public void CoinAddress(String withdrawID, String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.pathParam("walletID",withdrawID).header("Authorization",apikey).
                get("/user/wallet/coin/address/{walletID}");
        response.then() .log().status();
        response.getBody().print();
    }
}
