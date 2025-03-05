package org.Testing.ResponseValidation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidations {

    public static void validateResponse(Response response, int expectedStatusCode){
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
        String responseBody=response.asString();
        Assert.assertNotNull(responseBody,"Response body is null");
        Assert.assertFalse(responseBody.isEmpty(),"Response body is empty");
        System.out.println("Valid Response Recieved:" +responseBody);
        };
    public static  void validateBoardResponse(Response response, int expectedStatusCode){
        validateListResponse(response,expectedStatusCode);

        String boardId=response.jsonPath().getString("id");
        String boardName=response.jsonPath().getString("name");
        Assert.assertNotNull(boardId,"Board ID is missing or null");
        Assert.assertNotNull(boardName,"Board Name is missing or null");
        System.out.println("Board Validated- ID:" +boardId +", Name: "+ boardName);
    }
    public  static  void validateListResponse(Response response, int expectedStatusCode){
        validateResponse(response,expectedStatusCode);
        String listId=response.jsonPath().getString("id");
        String listName=response.jsonPath().getString("name");
        Assert.assertNotNull(listId,"list Id is missing or null");
        Assert.assertNotNull(listName,"list Name is missing or null");
        System.out.println("List Validated -ID:"+listId +", Name:" +listName);
    }

}
