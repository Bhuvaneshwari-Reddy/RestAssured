package org.Testing.TestSteps;

import io.restassured.response.Response;
import org.Testing.Payloads.ListData;
import org.Testing.Utilities.ApiConfigSingleton;
import org.Testing.Utilities.PropertiesFileLoad;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class ListMethods {
    private static  Response Res;
    private static ApiConfigSingleton config=ApiConfigSingleton.getInstance();
//
//    private Properties Pr;
//    private String apiKey;
//    private String apiToken;
//    private String baseUrl;
//    private  String BoardId;
//
//    public ListMethods() throws IOException {
//        this.Pr = PropertiesFileLoad.PropFileLoad("Env.properties");
//        this.apiKey = Pr.getProperty("APIKey");
//        this.apiToken = Pr.getProperty("APIToken");
//        this.baseUrl = Pr.getProperty("Base_URL");
//        this.BoardId=Pr.getProperty("BoardId");
//        if (apiKey == null || apiToken == null || baseUrl == null) {
//            throw new IllegalStateException("Wrong API Key, Token, or Base URL is missing in Env.properties!");
//        }
//    }
    public Response CreateListonBoard(){
        JSONObject requestBody = ListData.getListRequestBody();
        Res= given()
                .queryParam("idBoard",config.getBoardId())
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .when()
                .post(config.getBaseUrl()+"lists/")
                .then()
                .statusCode(200)
                .extract().response();
return Res;
    }
    public Response GetList(String  listId){
         Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .when()
                .get(config.getBaseUrl()+"lists/"+listId)
                .then()
                .statusCode(200)
                .extract().response();
return Res;
    }

    public Response UpdateList(String  listId){
        JSONObject requestBody = ListData.getListRequestBody();
        requestBody.put("name","InReview");
         Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .body(requestBody.toJSONString())
                .when()
                .put(config.getBaseUrl()+"lists/"+listId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

    public Response CreateCardInList(String listId){
        JSONObject requestBody = ListData.getListRequestBody();
        requestBody.put("name","Identity");
          Res= given()
            .queryParam("idList",listId)
            .queryParam("key",config.getApiKey())
            .queryParam("token",config.getApiToken())
            .header("Content-Type", "application/json")
            .body(requestBody.toJSONString())
            .when()
            .post(config.getBaseUrl()+"cards/")
            .then()
            .statusCode(200)
            .extract().response();
        return Res;
}

    public Response ArchieveCardInlist(String  listId){
         Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .when()
                .post(config.getBaseUrl()+"lists/"+listId+"/archiveAllCards/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }
    public Response MoveAllCardsInList(String  listId){
        Res= given()
                .queryParam("idBoard",config.getBoardId())
                  .queryParam("idList",listId)
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .when()
                .post(config.getBaseUrl()+"lists/"+listId+"/moveAllCards/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

    public Response ArchiveList(String  listId){
        Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .queryParam("value",true)
                .header("Content-Type", "application/json")
                .when()
                .put(config.getBaseUrl()+"lists/"+listId+"/closed/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

    public Response MoveList(String  listId){
        Res= given()
                .queryParam("value","67c1e9c8aba3f803d19f6cb9")
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .when()
                .put(config.getBaseUrl()+"lists/"+listId+"/idBoard/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

    public  Response UpdateListField(String listId){

        Res=given()
                .queryParam("value","In QA")
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type","application/json")
                .when()
                .put(config.getBaseUrl()+"lists/"+listId+"/name/")
                .then()
                .statusCode(200)
                .extract().response();

return  Res;
    }

    public  Response GetActionList(String listId){

        Res=given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type","application/json")
                .when()
                .get(config.getBaseUrl()+"lists/"+listId+"/actions/")
                .then()
                .statusCode(200)
                .extract().response();

        return  Res;
    }




}
