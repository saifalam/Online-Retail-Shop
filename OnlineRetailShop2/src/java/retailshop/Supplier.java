/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package retailshop;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaiser
 */
public class Supplier {

    private List<String> supplierList;

    public Supplier() {
        supplierList = new ArrayList<String>();
    }

    /**
     * @return the supplierList
     */
    public List<String> getSupplierList() {
        return supplierList;
    }

    /**
     * @param supplierList the supplierList to set
     */
    public void setSupplierList(List<String> supplierList) {
        this.supplierList = supplierList;
    }
}
