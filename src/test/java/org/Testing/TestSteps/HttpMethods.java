package org.Testing.TestSteps;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.Testing.Payloads.BoardData;
import org.Testing.Utilities.PropertiesFileLoad;
import java.io.IOException;
import java.util.Properties;
import io.restassured.RestAssured;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class HttpMethods
{
    private Properties Pr;
    private String apiKey;
    private String apiToken;
    private String baseUrl;
    public HttpMethods()throws IOException{

        this.Pr = PropertiesFileLoad.PropFileLoad("Env.properties");
        this.apiKey = Pr.getProperty("APIKey");
        this.apiToken = Pr.getProperty("APIToken");
        this.baseUrl = Pr.getProperty("Base_URL");
        if (apiKey == null || apiToken == null || baseUrl == null) {
            throw new IllegalStateException("❌ API Key, Token, or Base URL is missing in Env.properties!");
        }
    }

public  Response PostRequest(BoardData board){
       board.setName("Bhuvana");   
return given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-Type", "application/json")
                .body(board)
                .when()
                .post(baseUrl+"boards/")
               .then()
                .statusCode(200)
                .extract().response();
    }

public Response GetRequest(String BoardId){
    if (BoardId == null || BoardId.isEmpty()) {
        throw new IllegalStateException("BoardId is null or empty. Ensure createBoard() runs first.");
    }
    RestAssured.baseURI=baseUrl;
       Response Res= given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type","application/json")
                .when()
                .get("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
       return  Res;
    }

public  Response UpdateRequest(String BoardId){
        RestAssured.baseURI=baseUrl;
        JSONObject request= new JSONObject();
        request.put("name","Bhuvaneshwari");
        Response Res=given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type","application/json")
                .body(request.toJSONString())
                .when()
                .put("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

public Response DeleteRequest(String BoardId){

        RestAssured.baseURI=baseUrl;
        Response Res=given()
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .header("Content-type","application/json")
                .when()
                .delete("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;

    }


}


