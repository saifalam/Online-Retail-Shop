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
public class CustomerDetailsList {

    private List<AdminTransaction> customerDetailsList;

    public CustomerDetailsList() {
        customerDetailsList = new ArrayList<AdminTransaction>();
    }

    public List<AdminTransaction> getCustomerDetailsList() {
        return customerDetailsList;
    }

    public void setCustomerDetailsList(List<AdminTransaction> customerDetailsList) {
        this.customerDetailsList = customerDetailsList;
    }
}
