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
public class CategoryShow {

    private List<CategoryList> categoryShowList;

    public CategoryShow() {
        categoryShowList = new ArrayList<CategoryList>();
    }

    /**
     * @return the categoryShowList
     */
    public List<CategoryList> getCategoryShowList() {
        return categoryShowList;
    }

    /**
     * @param categoryShowList the categoryShowList to set
     */
    public void setCategoryShowList(List<CategoryList> categoryShowList) {
        this.categoryShowList = categoryShowList;
    }
}
