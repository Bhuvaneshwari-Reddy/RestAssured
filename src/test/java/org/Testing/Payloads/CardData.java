package org.Testing.Payloads;

import org.json.simple.JSONObject;

public class CardData {
    public static JSONObject getCardRequestBody(){

        JSONObject requestBody=new JSONObject();
        requestBody.put("name","item_1");
        return  requestBody;
    }


}
