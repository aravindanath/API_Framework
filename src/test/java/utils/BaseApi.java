package utils;

import com.github.javafaker.Faker;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import io.restassured.response.Response;
import org.testng.Assert;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Locale;
import java.util.Map;

public class BaseApi {

    public static Response response;
    public static String body, resource;
    public static Configuration configuration;
    public static String token ;


    public BaseApi() {
        configuration = Configuration.builder()
                .jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider())
                .build();
    }

    public static String getJsonStringFromYmal(String key){

        String path = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+ File.separator+"Data.yaml";
        Map<String,Object> jsonMap = null;
        try {
            Yaml yaml = new Yaml();
            Reader reader = new FileReader(path);
            jsonMap = yaml.load(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
        return jsonMap.get(key).toString();
    }


    public static String setBodyValue(String body, String key, String value){
        DocumentContext docContext = com.jayway.jsonpath.JsonPath.using(Configuration.builder().build()).parse(body);
        body = docContext.set(key, value).jsonString();
        return body;
    }


    public static void verifyStatusCode(int actualstatusCode,int expectedstatusCode){
        Assert.assertEquals(actualstatusCode,expectedstatusCode,"Invalid status code");
        System.out.println("Status code: " + actualstatusCode);
    }

    //Generate data using faker class
    public static String firstName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName();
    }

    public static String lastName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().lastName();
    }

    public static String birthday(){
        return "1990-10-10";
    }
    public static String emailId(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.name().firstName()+"@fake.com";
    }

    public static String mobileNumber(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.number().digits(10);
    }
    public static String StreetName1(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.address().streetName();
    }
    public static String StreetName2(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.address().streetName();
    }
    public static String cityName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.address().cityName();
    }
    public static String stateName(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.address().state();
    }
    public static String postalCode(){
        Faker faker = new Faker();
        return faker.address().zipCode();
    }
    public static String country(){
        Faker faker = new Faker(new Locale("en-IND"));
        return faker.address().country();
    }
}
