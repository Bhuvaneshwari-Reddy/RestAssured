
package org.Testing.TestCases;
import org.Testing.ResponseValidation.ResponseValidations;
import io.restassured.response.Response;
import org.Testing.Payloads.BoardData;
import org.Testing.TestSteps.BoardMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class TC1_Board {
    public static String BoardId;
    private static BoardMethods http;
    private static BoardData board;

    @BeforeClass
    public void setup() throws IOException {
        http = new BoardMethods();
    }

    @Test(priority = 1)
    public void createBoard() {
        board = new BoardData();
        Response Res = http.PostRequest(board);
        ResponseValidations.validateBoardResponse(Res, 200);
        BoardId=Res.jsonPath().getString("id");
    }

    @Test(priority = 2)
    public void getBoard() {
        Response Res=http.GetRequest(BoardId);
        ResponseValidations.validateBoardResponse(Res, 200);
    }

    @Test(priority = 3)
    public void updateBoard() {
        Response Res = http.UpdateRequest(board,BoardId);
        ResponseValidations.validateBoardResponse(Res, 200);
        BoardId=Res.jsonPath().getString("id");
    }

    @Test(priority = 4)
    public void deleteBoard(){
        Response Res=http.DeleteRequest(BoardId);
        ResponseValidations.validateResponse(Res, 200);
}

////    @Test(priority = 4)
//    public void getList(){
//   Response Res=http.GetListBoard(BoardId);
//    ResponseValidations.validateResponse(Res, 200);
//    idList=Res.jsonPath().getString("id");
//}
//@Test(priority = 5)
//public void createCard(){
//    Response Res=http.CreateCard(listId);
//    ResponseValidations.validateResponse(Res, 200);
//}


//    public static  void main(String [] args){
//        TC1 tc=new TC1();
//        tc.createBoard();
//       tc. getBoard();
//      tc.  updateBoard();
//      tc.deleteBoard();
//    }

}


