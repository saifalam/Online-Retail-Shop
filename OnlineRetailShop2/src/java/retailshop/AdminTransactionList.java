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
public class AdminTransactionList {

    private List<AdminTransaction> adminTransactionList;

    public AdminTransactionList() {
        adminTransactionList = new ArrayList<AdminTransaction>();
    }

    public List<AdminTransaction> getAdminTransactionList() {
        return adminTransactionList;
    }

    public void setAdminTransactionList(List<AdminTransaction> adminTransactionList) {
        this.adminTransactionList = adminTransactionList;
    }
}
