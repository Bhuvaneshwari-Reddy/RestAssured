package org.Testing.Payloads;
import org.json.simple.JSONObject;

public class ListData {
    public static JSONObject getListRequestBody(){
        JSONObject requestBody=new JSONObject();
        requestBody.put("name","Ready for Review");
        return  requestBody;
    }

}
