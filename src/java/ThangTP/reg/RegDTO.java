/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThangTP.reg;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 *
 * @author Admin
 */
public class RegDTO implements Serializable {

    private String username;
    private String password;
    private String fullname;
    private String image;
    private String email;
    private String phoneNumber;
    private int role;
    private boolean delFlag;

    public RegDTO() {
    }

    public RegDTO(String username, String password, String fullname, String image, String email, String phoneNumber, int role, boolean delFlag) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.image = image;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.delFlag = delFlag;
    }

    public boolean isDelFlag() {
        return delFlag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDelFlag(boolean delFlag) {
        this.delFlag = delFlag;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the role
     */
    public int isRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(int role) {
        this.role = role;
    }
}
