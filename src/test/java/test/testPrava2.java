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
            IAC.login("ws", "");
            System.err.println(IAC.getPrincipal() + " isAuthenticated ? " + IAC.authenticated());

            System.err.println("Test 1: ROLES MF :");
            System.err.println(Roles.getApp_MF_Roles());
            System.err.println(Roles.getApp_MF_Permissions());

            System.err.println("Test 2: ROLES WS :");
            System.err.println(Roles.getApp_WS_Roles());
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

            if (IAC.isPermitted(Roles.P_WS_CARDS_READ)) {
                System.err.println("HAS permission : " + Roles.P_WS_CARDS_READ);
            }
            if (IAC.isPermitted(Roles.P_MF_HSE_FS_USER_ALLWP_SEARCH)) {
                System.err.println("HAS permission : " + Roles.P_MF_HSE_FS_USER_ALLWP_SEARCH);
            }
            if (IAC.isPermitted(Roles.P_MF_RETAIL_REPORTS_GENERATE)) {
                System.err.println("HAS permission : " + Roles.P_MF_RETAIL_REPORTS_GENERATE);
            }
            if (IAC.isPermitted(Roles.P_MF_REPORT_OBRACUN)) {
                System.err.println("HAS permission : " + Roles.P_MF_REPORT_OBRACUN);
            }
            if (IAC.isPermitted(Roles.P_MF_REPORT_SPEC)) {
                System.err.println("HAS permission : " + Roles.P_MF_REPORT_SPEC);
            }

            if (IAC.isPermitted(Roles.P_MF_LOGIN)) {
                System.err.println("HAS permission : " + Roles.P_MF_LOGIN);
            }

            if (IAC.isPermitted(Roles.P_MF_RETAIL_REPORTS_GENERATE)) {
                System.err.println("HAS permission : " + Roles.P_MF_RETAIL_REPORTS_GENERATE);
            }

        } catch (Exception e) {
        }
    }

}
