package ci553.happyshop.catalogue;

import java.util.ArrayList;
import java.util.Objects;

public class SortedTrolley {

    private ArrayList<Product> arrayTrolley = new ArrayList<>();

    /**
     * Adds a product to the trolley.
     * Currently the product is simply appended to the end of the list.
     *
     * TODO — Improve trolley organisation:
     * 1. Merge products with the same product ID (combine quantities).
     * 2. Sorts the products in the trolley by product ID.
     *
     * Possible approaches:
     *
     * Approach 1 (simplest):
     * Modify addProduct() to handle merging and sorting directly.
     *
     * Approach 2:
     * Create a new method (e.g. addProductOrganised()) that performs the
     * merging and sorting logic.
     * Then call this method instead of addProduct() from addToTrolley() in CustomerModel.
     *
     * Approach 3 (more advanced):
     * Create a subclass such as OrganizedTrolley that overrides addProduct().
     * Then in CustomerModel:
     *     private Trolley trolley = new OrganizedTrolley();
     * This allows the trolley behaviour to be changed without modifying
     * the existing Trolley class.
     *
     * Approach 4 (advanced design using a design pattern – Factory Pattern)
     * (covered later in the "Design Patterns" topic).
     *
     * Instead of directly creating the trolley in CustomerModel:
     *   private Trolley trolley = new Trolley();
     * create a method such as:
     *   Trolley createTrolley(), which returns a Trolley.
     * Then create a subclass such as OrganizedCustomerModel that overrides
     * createTrolley() to return an OrganizedTrolley.
     *
     * The system can decide which model to use (CustomerModel or OrganizedCustomerModel)
     * in CustomerClient, Main, or other appropriate places in the application.
     * Either model can be used independently, or both can coexist,
     * allowing different trolley behaviours at the same time.
     *
     * code examples:
     * public CustomerModel(...) { trolley = createTrolley(); ...}
     *
     * protected Trolley createTrolley() { return new Trolley(); }
     *
     * class OrganizedCustomerModel extends CustomerModel {
     *     @Override
     *     protected Trolley createTrolley() {
     *         return new OrganizedTrolley();
     *     }
     * }
     */
    public void addProduct(Product product) {
        if(arrayTrolley.isEmpty()) {
            //private product tempProduct = ;
            arrayTrolley.add(new Product(product));
        }

        // defines variables for binary sort
        int searchFloor = 0;
        int searchCeiling = arrayTrolley.size();
        //calculates midpoint of unsearched list
        int searchTarget = Math.round(searchFloor+((float)(searchCeiling-searchFloor)/2));
        int compareResult;
        boolean isSearchComplete = false;
        while(!isSearchComplete) {
            // checks if all options have been exhausted. if so add a new product in index position
            if(searchCeiling == searchFloor) {
                arrayTrolley.add(searchTarget, new Product(product));
                isSearchComplete = true;
            }
            // compares result I think it just outputs a 0,1, or -1
            compareResult = arrayTrolley.get(searchTarget).compareTo(product);
            switch (compareResult) {
                case -1:
                    //target is less than so ceiling gets set to target
                    searchCeiling = searchTarget;
                    break;
                case 0:
                    //product is found so increments found product by 1
                    arrayTrolley.get(searchTarget).setOrderedQuantity(arrayTrolley.get(searchTarget).getOrderedQuantity()+1);
                    isSearchComplete = true;
                    break;
                case 1:
                    //target is greater than so floor gets set to target
                    searchFloor = searchTarget;
                    break;
            }
            //calculates midpoint of unsearched list
            searchTarget = Math.round(searchFloor+((float)(searchCeiling-searchFloor)/2));
        }
    }

        // product is appended to the end of the trolley
        // search list for product ID (use Binary Sort).
        // if a matching product ID is found increment ordered quantity by 1.
        // else deep copy product and insert it into list.

    public ArrayList<Product> getProducts() {
        return arrayTrolley;
    }

    public void clear() {
        arrayTrolley.clear();
    }
}
