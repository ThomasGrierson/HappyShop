package ci553.happyshop.catalogue;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.IO.println;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class SortedTrolley extends Trolley{

    @Override
    public void addProduct(Product product) {
        println(products);
        if(products.isEmpty()) {
            //private product tempProduct = ;
            products.add(new Product(product));
            return;
        }

        // defines variables for binary sort
        int searchFloor = 0;
        int searchCeiling = products.size()-1;
        //calculates midpoint of unsearched list
        int searchTarget = (searchFloor+((searchCeiling-searchFloor)/2));
        int compareResult;
        while(true) {
            // compares result I think it just outputs a 0,1, or -1
            // output is as predicted but larger ID outputs -1 and smaller outputs 1
            compareResult = products.get(searchTarget).compareTo(product);
            //compareTo outputs numbers larger than 1 or -1 so this just makes sures the values are in limit
            compareResult = Math.max(-1,compareResult);
            compareResult = Math.min(1,compareResult);
            if((searchCeiling <= searchFloor) && (compareResult != 0)) {
                switch (compareResult) {
                    case -1:
                        products.add(searchTarget, new Product(product));
                        break;
                    case 1:
                        products.add(searchTarget+1, new Product(product));
                        break;
                }
                return;
            }
            switch (compareResult) {
                case -1:
                    //target is greater than so ceiling gets set to target
                    searchCeiling = searchTarget-1;
                    break;
                case 0:
                    //product is found so increments found product by 1
                    products.get(searchTarget).setOrderedQuantity(products.get(searchTarget).getOrderedQuantity()+1);
                    return;
                case 1:
                    //target is less than so floor gets set to target
                    searchFloor = searchTarget+1;
                    break;
            }
            // checks if all options have been exhausted. if so add a new product in index position

            //calculates midpoint of unsearched list
            searchTarget = (searchFloor+((searchCeiling-searchFloor)/2));
        }
    }

}
