/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import org.superbapps.auth.IAccessAuthControl;
import org.superbapps.auth.IntermolADAccessControl;
import org.superbapps.auth.roles.Roles;

/**
 *
 * @author Dobri
 */
public class testPrava2 {

    public static void main(String[] args) {
        IAccessAuthControl IAC = new IntermolADAccessControl();

        try {
            // IAC.login("ws", "");
            IAC.login("fs", "");
            System.err.println(IAC.getPrincipal() + " isAuthenticated ? " + IAC.authenticated());

            System.err.println("Test 1: ROLES MF :");
            System.err.println(Roles.getApp_MF_Roles());
            System.err.println(Roles.getApp_MF_Permissions());

            System.err.println("Test 2: ROLES WS :");
            System.err.println(Roles.getApp_WS_Roles());

            System.err.println("Test 2: PERMISSIONS WS :");
            System.err.println(Roles.getApp_WS_Permissions());

            System.err.println("Test 3: Roles1.values() :");
            System.err.println(Arrays.toString(Roles.values()));

            System.err.println("-----------------Roles--------------------------");

            for (Roles r : Roles.values()) {
                if (IAC.hasRole(r)) {
                    System.err.println(IAC.getPrincipal() + " HAS ROLE : " + r);
                }
            }

            System.err.println("--------------Permissions------------------------");
            System.err.println("P: " + Roles.getApp_WS_Permissions());

            if (IAC.isPermitted(Roles.P_CRM_READ)) {
                System.err.println(IAC.getPrincipal() + " IS PERMITTED : " + Roles.P_CRM_READ);
            }

            if (IAC.isPermitted("p:crm:write")) {
                System.err.println(IAC.getPrincipal() + " IS PERMITTED : " + "p:crm:write");
            }

            if (IAC.isPermitted("p:crm:*")) {
                System.err.println(IAC.getPrincipal() + " IS PERMITTED : " + "p:crm:*");
            }

            System.err.println("--------------Test All Permissions------------------------");

            for (Roles p : Roles.values()) {
                if (IAC.isPermitted(p)) {
                    System.err.println(IAC.getPrincipal() + " IS PERMITTED : " + p.name());
                }
            }

            System.err.println("--------------Roles 2------------------------");
            if (IAC.hasRole(Roles.R_FS_MAINTENANCE)) {
                System.err.println(IAC.getPrincipal() + " HAS ROLE : " + Roles.R_FS_MAINTENANCE);
            }
            if (IAC.hasRole(Roles.R_CRM_MAINTENANCE)) {
                System.err.println(IAC.getPrincipal() + " HAS ROLE : " + Roles.R_CRM_MAINTENANCE);
            }
            if (IAC.hasRole(Roles.P_FS_READ)) {
                System.err.println(IAC.getPrincipal() + " HAS PERMISSION : " + Roles.P_FS_READ);
            }

        } catch (Exception e) {
            System.err.println("greška!");
            System.err.println(e.toString());
        }
    }

}
