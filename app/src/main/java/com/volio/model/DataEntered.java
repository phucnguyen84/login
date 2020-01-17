package com.volio.model;

public class DataEntered {
    private String username,password,tenantcode,language,member_token;

    public DataEntered(String username, String password, String tenantcode, String language, String member_token) {
        this.username = username;
        this.password = password;
        this.tenantcode = tenantcode;
        this.language = language;
        this.member_token = member_token;
    }
}
