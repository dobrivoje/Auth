/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbapps.auth.roles;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author dobri
 */
public enum Roles {

    //<editor-fold defaultstate="collapsed" desc="MF">
    //
    // GENERAL MF
    //
    R_MF_ROOTPRIVILEGES("R_MF_ROOTPRIVILEGES"),
    R_MF_LOGIN("R_MF_LOGIN"),
    R_MF_RETAIL_BACKOFFICE_MANAGER("R_MF_RETAIL_BACKOFFICE_MANAGER"),
    R_MF_RETAIL_BACKOFFICE_USER("R_MF_RETAIL_BACKOFFICE_USER"),
    R_MF_FS_USER("R_MF_FS_USER"),
    R_MF_HSE_MANAGER("R_MF_HSE_MANAGER"),
    R_MF_HSE_USER("R_MF_HSE_USER"),
    //
    // COCA CALC APP
    //
    APP_COCACALC_MAINTENENCE("app:cocacalc:maintenence"),
    APP_COCACALC_OWNREPORT_READ("app:cocacalc:ownreport:read"),
    APP_COCACALC_FS_UGOVOR_MAINTENANCE("app:cocacalc:fs_ugovor:maintenance"),
    APP_COCACALC_FS_UGOVOR_READ("app:cocacalc:fs_ugovor:read"),
    //
    // PERMISSIONS MF
    //
    P_MF_LOGIN("p:mf:login"),
    //
    // PERMISSIONS RETAIL REPORTS
    //
    P_MF_REPORT_SPEC("p:mf:reports:specifikacija"),
    P_MF_REPORT_OBRACUN("p:mf:reports:obracun"),
    P_MF_RETAIL_REPORTS_GENERATE("p:mf:retail:reports:generate"),
    //
    // PERMISSIONS HSE
    //
    P_MF_HSE_FS_USER_OWNWP_EDIT("p:mf:hse:user:wp:own:edit"),
    P_MF_HSE_FS_USER_OWNWP_SEARCH("p:mf:hse:user:wp:own:search"),
    P_MF_HSE_FS_USER_ALLWP_SEARCH("p:mf:hse:fs:user:wp:all:search"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="WS">
    //
    // GENERAL WS
    //
    R_WS_ROOTPRIVILEGES("R_WS_ROOTPRIVILEGES"),
    R_WS_LOGIN("R_WS_LOGIN"),
    R_WS_CARDS_MANAGER("R_WS_CARDS_MANAGER"),
    R_WS_CARDS_USER("R_WS_CARDS_USER"),
    R_WS_FS_MANAGER("R_WS_FS_MANAGER"),
    R_WS_FS_USER("R_WS_FS_USER"),
    R_WS_CRM_READ("R_WS_CRM_READ"),
    R_WS_CRM_MAINTENANCE("R_WS_CRM_MAINTENANCE"),
    //
    // EXCEL ROLES
    //
    R_WS_EXCEL_ALL("R_WS_EXCEL_ALL"),
    //
    // PERMISSIONS CUSTOMERS
    //
    P_WS_CUSTOMERS_READ("p:ws:customers:read"),
    P_WS_CUSTOMERS_MAINTENANCE("p:ws:customers:maintenance"),
    //
    // PERMISSIONS CRM
    //
    P_WS_CRM_READ("p:ws:crm:read"),
    P_WS_CRM_MAINTENANCE("p:ws:crm:maintenance"),
    //
    // PERMISSIONS SELL EXCEL
    //
    P_WS_EXCEL_IMPORT("p:ws:excel:import"),
    P_WS_EXCEL_EXPORT("p:ws:excel:export"),
    //
    // PERMISSIONS WS CARDS
    //
    P_WS_CARDS_ALL("p:ws:cards:*"),
    P_WS_CARDS_READ("p:ws:cards:*:read"),
    //
    // PERMISSIONS FUELSTATIONS MANAGEMENT
    //
    P_WS_FS_READ("p:ws:fs:read"),
    P_WS_FS_MAINTENANCE("p:ws:fs:maintenance");
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Support..">
    //<editor-fold defaultstate="collapsed" desc="System Support">
    private final String value;

    private Roles(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static List<Roles> getApp_MF_Roles() {
        return filterByName("R_MF");
    }

    public static List<Roles> getApp_MF_Permissions() {
        return filterByName("P_MF");
    }

    public static List<Roles> getApp_WS_Roles() {
        return filterByName("R_WS");
    }

    public static List<Roles> getApp_WS_Permissions() {
        return filterByName("P_WS");
    }

    private static List<Roles> filterByName(String what) {
        return Arrays.asList(Roles.values())
                .stream()
                .filter((Roles r) -> r.name().startsWith(what))
                .collect(Collectors.toList());

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Test">
    public static void main(String[] args) {
        System.err.println("test 1");
        System.err.println(Roles.getApp_MF_Roles());

        System.err.println("test 2");
        System.err.println(Roles.getApp_MF_Permissions());

        System.err.println("test 3");
        System.err.println(Roles.getApp_WS_Roles());

        System.err.println("test 4");
        System.err.println(Roles.getApp_WS_Permissions());

    }
    //</editor-fold>
    //</editor-fold>

}
