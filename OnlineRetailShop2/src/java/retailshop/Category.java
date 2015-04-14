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
public class Category {

    private List<String> categoryList;

    public Category() {
        categoryList = new ArrayList<String>();
    }

    /**
     * @return the categoryList
     */
    public List<String> getCategoryList() {
        return categoryList;
    }

    /**
     * @param categoryList the categoryList to set
     */
    public void setCategoryList(List<String> categoryList) {
        this.categoryList = categoryList;
    }
    /**
     * @return the categoryShowList
     */
}
