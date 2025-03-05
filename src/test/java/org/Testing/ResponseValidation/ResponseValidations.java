package org.Testing.ResponseValidation;

import io.restassured.response.Response;
import org.testng.Assert;

public class ResponseValidations {
//     Generic method to validate response
    public static void validateResponse(Response response, int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, "Status Code Mismatch");

        String responseBody = response.asString();
        Assert.assertNotNull(responseBody, " Response body is null");
        Assert.assertFalse(responseBody.isEmpty(), " Response body is empty");

        // Log response details
        System.out.println(" Valid Response Received: " + responseBody);
    }

    // Specific method for Board response validation
    public static void validateBoardResponse(Response response, int expectedStatusCode) {
        validateResponse(response, expectedStatusCode);

        // Validate Board ID and Name exist safely
        String boardId = response.jsonPath().getString("id");
        String boardName = response.jsonPath().getString("name");

        Assert.assertNotNull(boardId, "Wrong Board ID is missing or null");
        Assert.assertNotNull(boardName, "Wrong Board Name is missing or null");

        // Log success message
        System.out.println("Board Validated - ID: " + boardId + ", Name: " + boardName);
    }
    public static void validateListResponse(Response response, int expectedStatusCode) {
        validateResponse(response, expectedStatusCode);

        // Validate Board ID and Name exist safely
        String listId = response.jsonPath().getString("id");
        String listName = response.jsonPath().getString("name");

        Assert.assertNotNull(listId, " list ID is missing or null");
        Assert.assertNotNull(listName, " list Name is missing or null");

        // Log success message
        System.out.println(" List Validated - ID: " + listId + ", Name: " + listName);
    }

}
