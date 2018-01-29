package ExchangeBankActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatDepositCancel extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","depositID");
    }

    @Test(dataProvider="apiData")
    public void FiatDepositCancel(String depositID, String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("depositID",depositID).
                delete("/user/exchange/bank/fiat/deposit/cancel/{depositID}");
        response.then().log().status();
        response.getBody().print();
    }
}
