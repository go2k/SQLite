package com.sabel.sqlite.login;

import javax.security.auth.login.LoginContext;

public class Login {

    private String loginname;
    private String passwort;

    public Login(String loginname, String passwort) {
        setLoginname(loginname);
        setPasswort(passwort);
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }


}
