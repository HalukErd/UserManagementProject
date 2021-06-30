package com.avansas.UserManagementProject.model.enums;

public enum UserPermission {
    USER_DELETE("user:delete"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}