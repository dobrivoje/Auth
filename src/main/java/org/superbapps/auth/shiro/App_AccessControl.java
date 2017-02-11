package org.superbapps.auth.shiro;

public class App_AccessControl extends ShiroAccessControl {

    public App_AccessControl() {
        super("classpath:config.ini");
    }
}
