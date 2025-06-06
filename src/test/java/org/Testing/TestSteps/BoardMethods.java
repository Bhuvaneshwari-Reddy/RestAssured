package org.Testing.TestSteps;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.Testing.Payloads.BoardDataJsonArray_pojo;
import org.Testing.Payloads.BoardDataSimpleJson_pojo;
import org.Testing.Payloads.BoardDataComplexJson_pojo;
import org.Testing.Utilities.ApiConfigSingleton;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


import static io.restassured.RestAssured.*;

public class BoardMethods
{
    private static Response Res;
    private static ApiConfigSingleton config=ApiConfigSingleton.getInstance();
    private static RequestSpecification requestSpec;

    public BoardMethods(){
        if(requestSpec==null){
            setupRequestSpec();
        }
    }
    @BeforeClass
    public  void setupRequestSpec(){
      requestSpec =new RequestSpecBuilder()
              .addQueryParam("key",config.getApiKey())
              .addQueryParam("token",config.getApiToken())
              .addHeader("Content-Type", "application/json")
              .build();

    }
    public  Response PostRequest(BoardDataSimpleJson_pojo board){
       board.defaultValues();
       Res= given()
               .spec(requestSpec)
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
                .spec(requestSpec)
                .when()
                .get("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
       return  Res;
    }

    public  Response UpdateRequest(BoardDataSimpleJson_pojo board, String BoardId) {
        RestAssured.baseURI = config.getBaseUrl();

        BoardDataJsonArray_pojo[] switcherViews=new BoardDataJsonArray_pojo[2];
        switcherViews[0]=new BoardDataJsonArray_pojo();
        switcherViews[1]=new BoardDataJsonArray_pojo();
        switcherViews[0].setViewType("Board");
        switcherViews[0].setEnabled(true);
        switcherViews[1].setViewType("Table");
        switcherViews[1].setEnabled(true);

        BoardDataComplexJson_pojo prefs=new BoardDataComplexJson_pojo();
        prefs.setComments("members");
        prefs.setBackground("blue");
        prefs.setInvitations("admins");
        board.setName("Bhuvana Reddy");
        board.setDesc("Updated Board");
        prefs.setSwitcherViews(switcherViews);
        board.setPrefs(prefs);

        Gson gson = new Gson();
        String requestBody = gson.toJson(board);
        System.out.println(requestBody.toString());


         Res=given()
                 .spec(requestSpec)
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
                 .spec(requestSpec)
                .when()
                .delete("boards/"+BoardId)
                .then()
                .statusCode(200)
                .extract().response();
        return Res;
    }
}


