package ExchangeBankFiatData;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static locators.apiKey.apikey;

public class bankFiatWithdrawUnverified extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","Info");
    }

    @Test(dataProvider="apiData")
    public void FiatWithdrawUnverified(String apikey,String from,String max,String offset)
    {
        RequestSpecification httpRequest = RestAssured.given();
        Response response=httpRequest.header("Authorization",apikey).queryParameter("from",from).
                queryParameter("max",max).queryParameter("offset",offset).
                get("/user/exchange/bank/fiat/withdraw/unverified");
        response.then().log().status();
        response.getBody().print();
//        String withdrawID=response.then().extract().path("message.withdrawID");
//        System.out.println(withdrawID);
    }

}
