package API_Module;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.BaseApi;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class ContactClass extends BaseApi {

    public Response addContact(){
        body = getJsonStringFromYmal("add_contact_json");
        body = setBodyValue(body,"firstName",firstName());
        body = setBodyValue(body,"lastName",lastName());
        body = setBodyValue(body,"birthdate",birthday());
        body = setBodyValue(body,"email",emailId());
        body = setBodyValue(body,"phone",mobileNumber());
        body = setBodyValue(body,"street1",stateName());
        body = setBodyValue(body,"street2",stateName());
        body = setBodyValue(body,"city",cityName());
        body = setBodyValue(body,"stateProvince",stateName());
        body = setBodyValue(body,"postalCode",postalCode());
        body = setBodyValue(body,"country",country());

        response =  given()
                .baseUri(Endpoints.baseUrl)
                .contentType(ContentType.JSON).header("Authorization","Bearer "+token).log().all()
                .body(body).post(Endpoints.addContact);
        return response;
    }


}
