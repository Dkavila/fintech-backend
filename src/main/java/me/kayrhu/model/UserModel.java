package me.kayrhu.model;

import java.util.Date;

public class UserModel {
    private int userCode;
    private String userName;
    private String nickName;
    private Date birthDate;
    private String gender;
    private String email;
    private String password;

    public UserModel(){}
    public UserModel(int userCode, String userName, String nickName, Date birthDate, String gender, String email, String password) {
        this.userCode = userCode;
        this.userName = userName;
        this.nickName = nickName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        return "UserModel{" +
                "userCode=" + userCode +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}