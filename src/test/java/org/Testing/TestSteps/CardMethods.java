package org.Testing.TestSteps;

import io.restassured.response.Response;
import org.Testing.Payloads.CardData;
import org.Testing.Utilities.ApiConfigSingleton;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class CardMethods {
    private static Response Res;
    private  static ApiConfigSingleton config=ApiConfigSingleton.getInstance();

    public  Response CreateCard(){
        JSONObject requestBody= CardData.getCardRequestBody();
        Res=given()
                .queryParam("key",config.getApiKey())
                .queryParam("token",config.getApiToken())
                .queryParam("idList",config.getListId())
                .header("Content-Type","application/json")
                .body(requestBody.toJSONString())
                .when()
                .post(config.getBaseUrl()+"cards/")
                .then()
                .statusCode(200)
                .extract().response();
        return  Res;
    }

}
