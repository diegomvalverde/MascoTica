package com.reque.mascotica;

public class User {
    private String email;
    private String name;
    private String lastname;
    private String password;
    private String phone;
    private String profiledesc;
    private int id;
    private boolean organization;

    public User(String email, String name, String lastname, String password, String phone, String profiledesc, int id, boolean organization) {
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.phone = phone;
        this.profiledesc = profiledesc;
        this.id = id;
        this.organization = organization;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfiledesc() {
        return profiledesc;
    }

    public void setProfiledesc(String profiledesc) {
        this.profiledesc = profiledesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOrganization() {
        return organization;
    }

    public void setOrganization(boolean organization) {
        this.organization = organization;
    }

}
