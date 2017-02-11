package org.superbapps.auth.shiro;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;

public class ShiroAccessControl implements IAccessAuthControl {

    //<editor-fold defaultstate="collapsed" desc="Infrastructure">
    // atribut pod navodnicima je id sesije koja se odnosi na username ulogovanog korisnika
    private final Factory<SecurityManager> factory;
    private final SecurityManager securityManager;

    public ShiroAccessControl(String initFile) {
        factory = new IniSecurityManagerFactory(initFile);
        securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Logger.getLogger(ShiroAccessControl.class.getSimpleName()).log(Level.INFO, "******** ShiroAccessControl - Constructor");
    }
    //</editor-fold>

    @Override
    public synchronized Subject generateSubject() {
        Logger.getLogger(ShiroAccessControl.class.getSimpleName()).log(Level.INFO, "Auth module - Generate Subject");

        return SecurityUtils.getSecurityManager().createSubject(new DefaultSubjectContext());
    }

    @Override
    public synchronized boolean login(Subject subject, String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, true);

        try {
            ensureUserIsLoggedOut();

            subject.login(token);
            Logger.getLogger(ShiroAccessControl.class.getSimpleName())
                    .log(Level.INFO, "Auth module - Logging in user : {0} - SUCCESS", username);
            return true;
        } catch (AuthenticationException ae) {
            Logger.getLogger(ShiroAccessControl.class.getSimpleName())
                    .log(Level.SEVERE, "Auth module - Login error. Message : {0}", ae.getMessage());
            return false;
        }

    }

    @Override
    public synchronized void logout(Subject subject) {
        try {
            ensureUserIsLoggedOut();

            Object principal = subject.getPrincipal();
            String m = "No user ! (user haven't logged on.)";

            if (principal != null) {
                m = principal.toString();
            }

            Logger.getLogger(ShiroAccessControl.class.getSimpleName())
                    .log(Level.INFO, "Auth module - Logging out user : {0} - SUCCESS", m);
        } catch (Exception e) {
            Logger.getLogger(ShiroAccessControl.class.getSimpleName())
                    .log(Level.SEVERE, "Auth module - Logout - ERROR", e);
        }
    }

    private void ensureUserIsLoggedOut() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            if (currentUser == null) {
                return;
            }

            currentUser.logout();
            Session session = currentUser.getSession(false);
            if (session == null) {
                return;
            }

            session.stop();
        } catch (Exception e) {
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Permissions/Auths...">
    @Override
    public boolean authenticated(Subject subject) {
        try {
            return subject.isAuthenticated();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean hasRole(Subject subject, String role) {
        boolean o = false;
        try {
            o = subject.hasRole(role);
        } catch (Exception e) {
        }
        return o;
    }

    @Override
    public boolean hasRole(Subject subject, Enum role) {
        boolean o = false;
        try {
            o = subject.hasRole(role.toString());
        } catch (Exception e) {
        }
        return o;
    }

    @Override
    public boolean isPermitted(Subject subject, String permission) {
        boolean o = false;
        try {
            o = subject.isPermitted(permission);
        } catch (Exception e) {
        }
        return o;
    }

    @Override
    public boolean isPermitted(Subject subject, Enum permission) {
        boolean o = false;
        try {
            o = subject.isPermitted(permission.toString());
        } catch (Exception e) {
        }
        return o;
    }
    //</editor-fold>

}
