package com.aryan.stumps11.ApiModel.profile.createTeam;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Struct;

public class CreateReqData {

    @SerializedName("pid")
    @Expose
    private String pid;
    @SerializedName("credit")
    @Expose
    private String credit;
    @SerializedName("captain")
    @Expose
    private String captain;
    @SerializedName("vcaptain")
    @Expose
    private String vcaptain;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("role")
    @Expose
    private String role;



    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getVcaptain() {
        return vcaptain;
    }

    public void setVcaptain(String vcaptain) {
        this.vcaptain = vcaptain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
