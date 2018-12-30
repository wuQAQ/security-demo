package com.wuqaq.security.core.properties;

public class BrowserProperties {

    private String loginPage = "/wuqaq-signIn.html";

    private LoginType loginType = LoginType.JSON;

    private int remenberMeSeconds = 3600;

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public int getRemenberMeSeconds() {
        return remenberMeSeconds;
    }

    public void setRemenberMeSeconds(int remenberMeSeconds) {
        this.remenberMeSeconds = remenberMeSeconds;
    }
}
