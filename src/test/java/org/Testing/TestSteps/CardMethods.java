package org.Testing.TestSteps;

import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Testing.Payloads.CardDataJson;
import org.Testing.Utilities.ApiConfigSingleton;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class CardMethods {
    private static Response Res;
    private  static ApiConfigSingleton config=ApiConfigSingleton.getInstance();
    private static RequestSpecification requestSpec;
    public  CardMethods(){
        if(requestSpec==null){
           setupRequestSpec();
        }
    }
    @BeforeClass
    public void setupRequestSpec(){
         requestSpec = new RequestSpecBuilder()
                .addQueryParam("key", config.getApiKey())
                .addQueryParam("token", config.getApiToken())
                .addHeader("Content-Type", "application/json")
                .build();
    }

    public  Response CreateCard(){
        JSONObject requestBody= CardDataJson.getCardRequestBody();
        Res=given()
                .spec(requestSpec)
                .queryParam("idList",config.getListId())
                .body(requestBody.toJSONString())
                .when()
                .post(config.getBaseUrl()+"cards/")
                .then()
                .statusCode(200)
                .extract().response();
        return  Res;
    }

    public Response GetCard(String cardid){
    Res=given()
            .spec(requestSpec)
            .header("Content-Type","application/json")
            .when()
            .get(config.getBaseUrl()+"cards/"+cardid)
            .then()
            .statusCode(200)
            .extract().response();
    return Res;
    }
    public Response UpdateCard(String cardid){
        JSONObject updateBody=CardDataJson.updateCardBody();
        System.out.println(updateBody.toString());
        Res=given()
                .spec(requestSpec)
                .body(updateBody)
                .when()
                .put(config.getBaseUrl()+"cards/"+cardid)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;

    }
    public  Response DeleteCard(String cardid){
       Res=given()
               .spec(requestSpec)
               .when()
               .delete(config.getBaseUrl()+"cards/"+cardid)
               .then()
               .statusCode(200)
               .extract().response();
return  Res;
    }
}
