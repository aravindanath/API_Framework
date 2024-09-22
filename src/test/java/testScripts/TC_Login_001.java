package testScripts;


import API_Module.UserClass;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.BaseApi;

public class TC_Login_001
{


    @Test(priority = 1,invocationCount=10)
    public void TC_Login_001(){
        String email = "tom@testmail.com",password = "Password@123";
        UserClass uc = new UserClass();
        BaseApi api = new BaseApi();
        Response response =  uc.userLogin(email,password);
        api.verifyStatusCode(response.getStatusCode(),200);
        response.prettyPrint();
        api.token =  response.then().extract().path("token");

    }

    @Test(priority = 2)
    public void TC_Login_002(){
        String email = "tom@testmail.com",password = "Password@1234";
        UserClass uc = new UserClass();
        BaseApi api = new BaseApi();
        Response response =  uc.userLogin(email,password);
        api.verifyStatusCode(response.getStatusCode(),401);
        response.prettyPrint();
    }
}
