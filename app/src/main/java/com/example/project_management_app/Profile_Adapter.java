package com.example.project_management_app;

import com.google.gson.Gson;

public class Profile_Adapter {

    private String userName;
    private String userId;
    private String json;

    public Profile_Adapter(String userName, String userId, Profile profile) {
        this.userName = userName;
        this.userId = userId;

        Gson gson = new Gson();
        this.json = gson.toJson(profile);
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
