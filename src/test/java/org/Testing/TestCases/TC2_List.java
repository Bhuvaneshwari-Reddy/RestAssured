package org.Testing.TestCases;

import io.restassured.response.Response;
import org.Testing.Payloads.ListData;
import org.Testing.ResponseValidation.ResponseValidations;
import org.Testing.TestSteps.ListMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

 public class TC2_List {
    private static ListMethods http;
    private static String listId;
     private static String cardId;
    private static ListData list;
    private  static Response Res;
    @BeforeClass
    public void beforeClass() throws IOException {
        http = new ListMethods();
    }
@Test(priority =1)
    public void createList(){
         Res =http.CreateListonBoard();
         listId = Res.jsonPath().getString("id");
        System.out.println(listId);
    ResponseValidations.validateListResponse(Res, 200,listId);
    }
     @Test(priority =2)
     public void getList(){
         Res=http.GetList(listId);
        ResponseValidations.validateListResponse(Res, 200,listId);
    }
     @Test(priority =3)
    public void updateList() {
     Res=http.UpdateList(listId);
        ResponseValidations.validateListResponse(Res, 200,listId);
    }
     @Test(priority =4)
    public void createCardInList(){
         Res=http.CreateCardInList(listId);
        ResponseValidations.validateListResponse(Res,200,listId);
         cardId = Res.jsonPath().getString("id");
    }
     @Test(priority =5)
    public void archiveCardInList(){
         Res=http.ArchieveCardInlist(listId);
    }
     @Test(priority =6)
    public void moveAllCardsInList(){
        Res=http.MoveAllCardsInList(listId);
    }

     @Test(priority =7)
     public void archiveList() {
        Res=http.ArchiveList(listId);
        ResponseValidations.validateListResponse(Res,200,listId);
     }

     @Test(priority = 8)
     public void moveList() {
        Res=http.MoveList(listId);
        ResponseValidations.validateListResponse(Res,200,listId);
     }

     @Test(priority = 9)
     public void updateListField(){
        Res=http.UpdateListField(listId);
         ResponseValidations.validateListResponse(Res,200,listId);
     }

     @Test(priority = 10)
     public void getActions(){
        Res=http.GetActionList(listId);
        ResponseValidations.validateListResponse(Res,200,listId);
     }

 }

