package com.ldt.models;

import java.io.Serializable;

public class RoleModel implements Serializable {
    private int roleid;

    public RoleModel() {
    }

    public RoleModel(int roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                '}';
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    private String rolename;

}
