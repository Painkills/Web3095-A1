package com.a1.cookbook.service;

public class ChefList {
    private long chefId;
    private String chefName;
    private String chefLastname;
    private String email;
    private String password;

    public long getChefId() {
        return chefId;
    }

    public void setChefId(long chefId) {
        this.chefId = chefId;
    }

    public String getChefName() {
        return chefName;
    }

    public void setChefName(String chefName) {
        this.chefName = chefName;
    }

    public String getChefLastname() {
        return chefLastname;
    }

    public void setChefLastname(String chefLastname) {
        this.chefLastname = chefLastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ChefList{" +
                "chefId=" + chefId +
                ", chefName='" + chefName + '\'' +
                ", chefLastname='" + chefLastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
