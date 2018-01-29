package ExchangeBankActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatDepositNew extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","depositNew");
    }

    @Test(dataProvider="apiData")
    public void FiatDepositNew(String amount,String msg,String bank,String deptype,String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("amount",amount);
        requestparms.put("message",msg);
        requestparms.put("bank",bank);
        requestparms.put("depType",deptype);

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                put("/user/exchange/bank/fiat/deposit/new");
        response.then().log().status();
        response.getBody().print();
    }
}
