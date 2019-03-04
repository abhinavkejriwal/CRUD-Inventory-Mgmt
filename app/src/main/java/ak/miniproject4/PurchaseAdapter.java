package ak.miniproject4;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class PurchaseAdapter extends RecyclerView.Adapter {

    private ArrayList<Purchase> mArrayList;
    public PurchaseAdapter mPAdapter;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public RecyclerView mRecyclerView;
        public RecyclerView.LayoutManager mLayoutManager;
        public CardView mCardView;
        public TextView mTextView;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;


        public ViewHolder(View view) {
            super(view);

            this. mRecyclerView = view.findViewById(R.id.mRecyclerViewID);
            this.mLayoutManager = new LinearLayoutManager(view.getContext());
            this.mRecyclerView.setLayoutManager(mLayoutManager);

            this.mTextView = (TextView) view.findViewById(R.id.textViewID);
            this.mTextView2 = (TextView) view.findViewById(R.id.textViewID2);
            this.mTextView3 = (TextView) view.findViewById(R.id.textViewID3);
            this.mTextView4 = (TextView) view.findViewById(R.id.textViewID4);

            this.mCardView = view.findViewById(R.id.mCardViewID);

        }

        public TextView getmTextView() {
            return mTextView;
        }

        public TextView getmTextView2() {
            return mTextView2;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.each_purchase2, viewGroup, false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Purchase purchase1 = new Purchase(15, "Wendys", "John", 223);
        Purchase purchase2 = new Purchase(30, "McDonalds", "Larry", 223);
        Purchase purchase3 = new Purchase(45, "Dominoes", "Sergei", 223);
        Purchase purchase4 = new Purchase(60, "Abe's", "Mark", 223);
        Purchase purchase5 = new Purchase(75, "Sliver", "Steve", 223);

        mArrayList.add(purchase1);
        mArrayList.add(purchase2);
        mArrayList.add(purchase3);
        mArrayList.add(purchase4);
        mArrayList.add(purchase5);

        // How to add data to the text of one view?
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public PurchaseAdapter(ArrayList<Purchase> mArrayList) {
        this.mArrayList = mArrayList;
    }


}
