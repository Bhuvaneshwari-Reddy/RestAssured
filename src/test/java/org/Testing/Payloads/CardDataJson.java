package org.Testing.Payloads;

import org.json.simple.JSONObject;

public class CardDataJson {
    public static JSONObject getCardRequestBody(){

        JSONObject requestBody=new JSONObject();
        requestBody.put("name","item_1");
        return requestBody;

    }

    public static JSONObject updateCardBody(){

        JSONObject badgesRequest =new JSONObject();
        badgesRequest.put("description",true);
        badgesRequest.put("fogbugz","xyz");
        badgesRequest.put("checkItems",1);

        JSONObject updateBody=new JSONObject();
        updateBody.put("name","CardItem");
        updateBody.put("desc","Updated card ");
        updateBody.put("badges",badgesRequest);

        return updateBody;
    }


}
