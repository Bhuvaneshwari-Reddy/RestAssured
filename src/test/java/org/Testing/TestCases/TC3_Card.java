package org.Testing.TestCases;
import io.restassured.response.Response;
import org.Testing.TestSteps.CardMethods;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC3_Card {
 private static CardMethods http;
 private  static  Response Res;

 @BeforeClass
public  void beforeTest()throws IOException{
     http=new CardMethods();
 }
 @Test
public  void createCard(){
    Res = http.CreateCard();
    String cardId=Res.jsonPath().getString("id");
    String cardName= Res.jsonPath().getString("name");
    System.out.println(cardId);
    System.out.println(cardName);
   }
}
