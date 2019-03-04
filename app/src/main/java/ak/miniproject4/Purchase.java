package ak.miniproject4;

import java.util.Date;

//Purchase Class that describes how each purchase will be entered
public class Purchase {

    private int mPurchaseCost;
    private String mDescription;
    private String mStore;
    private String mVendor;
    private int mPurchaseDate;

    public Purchase(int cost, String desc, String store, int date) {
        mPurchaseCost = cost;
        mDescription = desc;
        mStore = store;
        mPurchaseDate = date;

    }

}
