package com.binarybuilders.bynb_user_service.persistence;



import java.util.Arrays;
import java.util.List;

public enum Role {

    USER(Arrays.asList(Permission.READ_ALL_DANGERS, Permission.SAVE_DANGER)),
    ADMIN(Arrays.asList(Permission.READ_ALL_DANGERS, Permission.SAVE_DANGER, Permission.DELETE_DANGER));

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}