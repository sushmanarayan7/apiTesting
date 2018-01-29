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

public class bankFiatWithdrawNewVerifyCode extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","withdrawID");
    }

    @Test(dataProvider="apiData")
    public void FiatWithdrawNewVerifyCode(String withdrawID, String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("withdrawID",withdrawID);

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                post("/user/exchange/bank/fiat/withdraw/newVerifycode");
        response.then().log().status();
        response.getBody().print();
    }
}
