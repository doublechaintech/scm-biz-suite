
package com.doublechaintech.retailscm;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
@JsonSerialize(using = LoginFormSerializer.class)
public class LoginForm extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public LoginForm() {
        // TODO Auto-generated constructor stub
    }
    private String internalToken;
    private String usernameParmeter;
    private String passwordParmeter;


    public String getUsernameParmeter() {
        return usernameParmeter;
    }

    public void setUsernameParmeter(String usernameParmeter) {
        this.usernameParmeter = usernameParmeter;
    }

    public String getPasswordParmeter() {
        return passwordParmeter;
    }

    public void setPasswordParmeter(String passwordParmeter) {
        this.passwordParmeter = passwordParmeter;
    }

    public String getInternalToken() {
        return internalToken;
    }

    public void setInternalToken(String internalToken) {
        this.internalToken = internalToken;
    }


}


