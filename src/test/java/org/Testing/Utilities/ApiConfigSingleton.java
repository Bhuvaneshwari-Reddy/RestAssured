package org.Testing.Utilities;

import java.io.IOException;
import java.util.Properties;


public class ApiConfigSingleton {
    private static ApiConfigSingleton instance;
    private Properties properties;
    private String apiKey;
    private String apiToken;
    private String baseUrl;
    private String boardId;
    private  String listId;

    private ApiConfigSingleton() {
        try {
         properties=PropertiesFileLoad.PropFileLoad("Env.properties");
         this.apiKey=properties.getProperty("APIKey");
         this.apiToken=properties.getProperty("APIToken");
         this.baseUrl= properties.getProperty("Base_URL");
         this.boardId=properties.getProperty("BoardId");
         this.listId=properties.getProperty("ListId");

            if(apiKey==null||apiToken==null||boardId==null||baseUrl==null){
             throw  new IllegalStateException("Missing key,token,url and id in Env.properties");
            }
        } catch (IOException e){
            throw new RuntimeException("Failed to load API configuration", e);
        }
    }

    public static ApiConfigSingleton getInstance(){
        if(instance==null){
            synchronized (ApiConfigSingleton.class){
                if(instance==null){
                    instance=new ApiConfigSingleton();
                }
            }
        }
        return  instance;

    }

    public String getApiKey() {
        return apiKey;
    }

    public String getApiToken() {
        return apiToken;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getBoardId() {
        return boardId;
    }
    public  String getListId(){

        return  listId;
    }
}
