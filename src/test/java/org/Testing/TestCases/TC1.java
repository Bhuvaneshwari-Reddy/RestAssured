package org.Testing.TestCases;
import io.restassured.response.Response;
import org.Testing.Payloads.BoardData;
import org.Testing.TestSteps.HttpMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

public class TC1 {
        private static String BoardId;
        private static HttpMethods http;

    @BeforeClass
    public void setup() throws IOException {
        http = new HttpMethods();
    }
    @Test(priority = 1)
    public void createBoard() {
        BoardData board = new BoardData();
        Response Res = http.PostRequest(board);
        BoardId=Res.jsonPath().getString("id");
        System.out.println(Res.jsonPath().getString("name"));
        System.out.println(BoardId);

    }

    @Test(priority = 2)
    public void getBoard() {
        Response Res=http.GetRequest(BoardId);
        System.out.println(Res.jsonPath().getString("id"));
        System.out.println(Res.jsonPath().getString("name"));
    }


    @Test(priority = 3)
    public void updateBoard() {
        Response Res = http.UpdateRequest(BoardId);
        BoardId=Res.jsonPath().getString("id");
        System.out.println(Res.jsonPath().getString("id"));
        System.out.println(Res.jsonPath().getString("name"));
    }

    @Test(priority = 4)
    public void deleteBoard(){
        Response Res=http.DeleteRequest(BoardId);
        System.out.println(Res.jsonPath().getString("_value"));
    }

}

