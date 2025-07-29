package org.Testing.TestSteps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Testing.Payloads.ListData;
import org.Testing.Utilities.ApiConfigSingleton;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class ListMethods {

    private static  Response Res;
    private static ApiConfigSingleton config=ApiConfigSingleton.getInstance();
    private static RequestSpecification requestSpec;
    public ListMethods() {
        if (requestSpec == null) {
            setupRequestSpec();
        }
    }
    @BeforeClass
    public void setupRequestSpec(){
        requestSpec =new RequestSpecBuilder()
                .addQueryParam("key",config.getApiKey())
                .addQueryParam("token",config.getApiToken())
                .addHeader("Content-Type", "application/json")
                .build();
    }
    public Response CreateListonBoard(){
        JSONObject requestBody = ListData.getListRequestBody();
        Res= given()
                .queryParam("idBoard",config.getBoardId())
                .spec(requestSpec)
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
                .spec(requestSpec)
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
                .spec(requestSpec)
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
            .spec(requestSpec)
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
                .spec(requestSpec)
                .when()
                .post(config.getBaseUrl()+"lists/"+listId+"/archiveAllCards/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }
    public Response MoveAllCardsInList(String  listId){
        System.out.println(listId);
        Res= given()
                .queryParam("idBoard",config.getBoardId())
                .queryParam("idList",listId)
                .spec(requestSpec)
                .when()
                .post(config.getBaseUrl()+"lists/"+listId+"/moveAllCards/")
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

    public Response ArchiveList(String  listId){
        Res= given()
                .spec(requestSpec)
                .queryParam("value",true)
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
                .spec(requestSpec)
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
                .spec(requestSpec)
                .when()
                .put(config.getBaseUrl()+"lists/"+listId+"/name/")
                .then()
                .statusCode(200)
                .extract().response();

return  Res;
    }

    public  Response GetActionList(String listId){

        Res=given()
                .spec(requestSpec)
                .when()
                .get(config.getBaseUrl()+"lists/"+listId+"/actions/")
                .then()
                .statusCode(200)
                .extract().response();

        return  Res;
    }

}

