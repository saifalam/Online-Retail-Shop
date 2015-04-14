/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rahat
 */
public class LoginInfo {

    private List<Login> loginList;

    public LoginInfo() {
        loginList = new ArrayList<Login>();
    }

    public List<Login> getLoginList() {
        return loginList;
    }

    public void setLoginList(List<Login> loginList) {
        this.loginList = loginList;
    }
}
