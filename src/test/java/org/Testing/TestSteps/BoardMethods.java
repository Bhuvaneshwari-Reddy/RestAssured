package org.Testing.TestSteps;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.Testing.Payloads.BoardData;
import org.Testing.Utilities.ApiConfigSingleton;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class BoardMethods
{
    private static Response Res;
    private static ApiConfigSingleton config=ApiConfigSingleton.getInstance();

    public  Response PostRequest(BoardData board){
       board.setName("Bhuvana");
       Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-Type", "application/json")
                .body(board)
                .when()
                .post(config.getBaseUrl()+"boards/")
               .then()
                .statusCode(200)
                .extract().response();
       return Res;
    }

    public Response GetRequest(String BoardId){
    if (BoardId == null || BoardId.isEmpty()) {
        throw new IllegalStateException("BoardId is null or empty. Ensure createBoard() runs first.");
    }
        RestAssured.baseURI = config.getBaseUrl();
        Res= given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-type","application/json")
                .when()
                .get("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
       return  Res;
    }

    public  Response UpdateRequest(BoardData board,String BoardId ) {
        RestAssured.baseURI = config.getBaseUrl();
        board.defaultValues();
        Gson gson = new Gson();
        String requestBody = gson.toJson(board);

         Res=given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-type","application/json")
                .body(requestBody)
                .when()
                .put("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }

   public Response DeleteRequest(String BoardId){

       RestAssured.baseURI = config.getBaseUrl();
         Res=given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .header("Content-type","application/json")
                .when()
                .delete("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }
}


