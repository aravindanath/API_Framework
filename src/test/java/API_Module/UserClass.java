package API_Module;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseApi;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class UserClass extends BaseApi {




   
    public Response userLogin(String email, String password){
        body = getJsonStringFromYmal("user_login_json");
        body = setBodyValue(body,"email",email);
        body = setBodyValue(body,"password",password);
        response =  given()
                .baseUri(Endpoints.baseUrl)
                .contentType(ContentType.JSON).log().all()
                .body(body).post(Endpoints.login);
        return response;
    }


}
