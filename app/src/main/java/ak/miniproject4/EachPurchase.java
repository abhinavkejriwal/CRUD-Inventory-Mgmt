package ak.miniproject4;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class EachPurchase extends AppCompatActivity  {

    private PurchaseAdapter mAdapter;
    public RecyclerView mRecyclerView;

    public ArrayList<Purchase> mDataList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.each_purchase);

        mAdapter = new PurchaseAdapter(mDataList);
        mRecyclerView.setAdapter(mAdapter);

    }

    public EachPurchase() {
        //do nothing.
    }

    /*1. A custom class to handle each individual purchase
            The class you creates should contain the following attributes:
            1. The cost of each purchase
         2. A short description of what was purchased
         3. Name of the supplying merchants (store name/vendor name)
         4. The date of when the purchase was made*/
}
