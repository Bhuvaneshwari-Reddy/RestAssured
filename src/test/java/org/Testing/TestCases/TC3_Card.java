package org.Testing.TestCases;
import groovy.util.Eval;
import io.restassured.response.Response;
import org.Testing.ResponseValidation.ResponseValidations;
import org.Testing.TestSteps.CardMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC3_Card {
 private static CardMethods http;
 private  static  Response Res;
private static String cardid;
 @BeforeClass
 public  void beforeTest()throws IOException{
     http=new CardMethods();
 }
 @Test(priority = 1)
public  void createCard(){
    Res = http.CreateCard();
     cardid=Res.jsonPath().getString("id");
    String cardName= Res.jsonPath().getString("name");
     ResponseValidations.validateCardResponse(Res,200,cardid);
   }

   @Test(priority = 2)
   public  void  getCard(){
     Res=http.GetCard(cardid);
       ResponseValidations.validateCardResponse(Res,200,cardid);
   }


   @Test(priority = 3)
    public void updateCard(){
     Res=http.UpdateCard(cardid);
     ResponseValidations.validateCardResponse(Res,200,cardid);
   }


   @Test(priority = 4)
   public void deleteCard(){
     Res=http.DeleteCard(cardid);
//     ResponseValidations.validateCardResponse(Res,200);
   }

}


