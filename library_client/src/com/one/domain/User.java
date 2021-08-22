package com.one.domain;

public class User {

    private Integer id       ;// int(11)      (NULL)           NO      PRI     (NULL)   auto_increment  select,insert,update,references
    private String username ;// varchar(32)  utf8_general_ci  YES     UNI     (NULL)                   select,insert,update,references
    private String password ;// varchar(32)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
    private String phone    ;// varchar(16)  utf8_general_ci  YES             (NULL)                   select,insert,update,references
    private String gender   ;// char(1)      utf8_general_ci  YES             (NULL)                   select,insert,update,references


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
