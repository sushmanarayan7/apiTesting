package ExchangeTradeActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class exchangeAskCancelOrderID extends DriverCreation
{

public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","OrderID");
    }

    @Test(dataProvider="apiData")
    public void AskCancelOrderID(String apikey,String orderID)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).pathParam("orderID",orderID).
                delete("/user/exchange/ask/cancel/{orderID}");
        response.then().log().status();
        response.getBody().print();
    }
}
