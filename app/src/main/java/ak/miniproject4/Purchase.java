package ak.miniproject4;

import java.util.Date;

//Purchase Class that describes how each purchase will be entered
public class Purchase {

    private String mPurchaseCost;
    private String mDescription;
    private String mStore;
    // private String mVendor;
    private String mPurchaseDate;

    public Purchase(String cost, String desc, String store, String date) {
        mPurchaseCost = cost;
        mDescription = desc;
        mStore = store;
        mPurchaseDate = date;

    }

    public String getCost() {
        return mPurchaseCost;
    }

    public String getDesc() {
        return mDescription;
    }

    public String getStore() {
        return mStore;
    }

    public String getDate() {
        return mPurchaseDate;
    }

}
