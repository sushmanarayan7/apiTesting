package WalletActions;

import base.DriverCreation;
import base.ReadExcel;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class walletCoinWithdrawInitiate extends DriverCreation
{
    public ReadExcel excelreader;

    @DataProvider(name = "apiData")
    public Object[][] dataSource()
    {
        excelreader = new ReadExcel();
        return excelreader.readExcel("poi_test.xlsx","WalletCoinWithdrawinitiate");
    }

    @Test(dataProvider="apiData")
        public void CoinWithdrawInitiate(String walletID,String amt,String toAddr,String msg,String pin,String apikey)
    {
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestparms= new JSONObject();
        requestparms.put("walletID",walletID);
        requestparms.put("amt",amt);
        requestparms.put("toAddr",toAddr);
        requestparms.put("msg",msg);
        requestparms.put("pin",pin);

        Response response=httpRequest.body(requestparms).header("Authorization",apikey).
                when().
                contentType(ContentType.JSON).
                post("/user/wallet/coin/withdraw/initiate");
        response.then().log().status();
        response.getBody().print();
//        String resmsg=response.then().extract().path("message");
//        System.out.println("Response Message : "+resmsg);
    }
}
