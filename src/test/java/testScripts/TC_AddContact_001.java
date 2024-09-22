package testScripts;


import API_Module.ContactClass;
import API_Module.UserClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseApi;

public class TC_AddContact_001
{


    @Test
    public void TC_AddContact_001(){

        BaseApi api = new BaseApi();
        ContactClass cc = new ContactClass();
        Response response = cc.addContact();
        response.prettyPrint();
        api.verifyStatusCode(response.getStatusCode(),201);

    }


}
