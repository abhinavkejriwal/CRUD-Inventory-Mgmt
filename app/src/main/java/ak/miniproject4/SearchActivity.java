package ak.miniproject4;

import android.app.ListActivity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SearchActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    public Purchase doMySearch(String myQuery) {
        Purchase p;
        for (int i = 0; i <= MainActivity.mDataList.size(); i += 1) {
            if ((MainActivity.mDataList.get(i).getCost().equals(myQuery)) ||
            (MainActivity.mDataList.get(i).getDate().equals(myQuery)) ||
                    (MainActivity.mDataList.get(i).getDesc().equals(myQuery)) ||
                    (MainActivity.mDataList.get(i).getStore().equals(myQuery))) {
                return MainActivity.mDataList.get(i);
            }
        }
        return null;
    }
}
