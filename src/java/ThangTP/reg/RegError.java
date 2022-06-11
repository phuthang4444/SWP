/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThangTP.reg;

import java.io.Serializable;

/**
 *
 * @author phuth
 */
public class RegError implements Serializable {

    private String idErr;
    private String phoneNumberErr;
    private String passwordErr;
    private String confirmpasswordtErr;
    private String fullNameErr;
    private String emailErr;
    private String errorMess;

    public RegError() {
    }

    public RegError(String idErr, String phoneNumberErr, String passwordErr, String confirmpasswordtErr, String fullNameErr, String emailErr, String errorMess) {
        this.idErr = idErr;
        this.phoneNumberErr = phoneNumberErr;
        this.passwordErr = passwordErr;
        this.confirmpasswordtErr = confirmpasswordtErr;
        this.fullNameErr = fullNameErr;
        this.emailErr = emailErr;
        this.errorMess = errorMess;
    }

    public String getIdErr() {
        return idErr;
    }

    public void setIdErr(String idErr) {
        this.idErr = idErr;
    }

    public String getPhoneNumberErr() {
        return phoneNumberErr;
    }

    public void setPhoneNumberErr(String phoneNumberErr) {
        this.phoneNumberErr = phoneNumberErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getConfirmpasswordtErr() {
        return confirmpasswordtErr;
    }

    public void setConfirmpasswordtErr(String confirmpasswordtErr) {
        this.confirmpasswordtErr = confirmpasswordtErr;
    }

    public String getFullNameErr() {
        return fullNameErr;
    }

    public void setFullNameErr(String fullNameErr) {
        this.fullNameErr = fullNameErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    public String getErrorMess() {
        return errorMess;
    }

    public void setErrorMess(String errorMess) {
        this.errorMess = errorMess;
    }

    

}
