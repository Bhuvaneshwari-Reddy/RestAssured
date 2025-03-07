
package org.Testing.TestCases;
import org.Testing.ResponseValidation.ResponseValidations;
import io.restassured.response.Response;
import org.Testing.Payloads.BoardDataSimpleJson_pojo;
import org.Testing.TestSteps.BoardMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC1_Board {
    public static String BoardId;
    private static BoardMethods http;
    private static BoardDataSimpleJson_pojo board;

    @BeforeClass
    public void setup() throws IOException {
        http = new BoardMethods();
    }

    @Test(priority = 1)
    public void createBoard() {
        board = new BoardDataSimpleJson_pojo();
        Response Res = http.PostRequest(board);
        BoardId=Res.jsonPath().getString("id");
        ResponseValidations.validateBoardResponse(Res, 200,BoardId);

    }

    @Test(priority = 2)
    public void getBoard() {
        Response Res=http.GetRequest(BoardId);
        ResponseValidations.validateBoardResponse(Res, 200,BoardId);
    }

    @Test(priority = 3)
    public void updateBoard() {
        Response Res = http.UpdateRequest(board,BoardId);
        BoardId=Res.jsonPath().getString("id");
        ResponseValidations.validateBoardResponse(Res, 200,BoardId);
    }

    @Test(priority = 4)
    public void deleteBoard(){
        Response Res=http.DeleteRequest(BoardId);
        ResponseValidations.validateResponse(Res, 200,BoardId);
}
}


