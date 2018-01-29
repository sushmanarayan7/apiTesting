package ExchangeBankActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankCoinWithdrawUnverifiedCancel extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","withdrawID");
    }

    @Test(dataProvider="apiData")
    public void CoinWithdrawUnverifiedCancel(String withdrawID, String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("withdrawID",withdrawID).
                delete("/user/exchange/bank/coin/withdraw/unverified/cancel/{withdrawID}");
        response.then().log().status();
        response.getBody().print();
    }
}
