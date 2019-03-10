package ak.miniproject4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity {
    // ArrayList<Purchase> mDataList = new ArrayList<Purchase>();
    EditText costEdit, aboutEdit, storeEdit, dateEdit, deleteEdit;
    String costEditString, aboutEditString, storeEditString, dateEditString;
    Button submit, delete;
    PurchaseAdapter mAdapter2;

    /*public void EditActivity(ArrayList<Purchase> aList) {
        mEditList = aList;
    } */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        costEdit = (EditText) findViewById(R.id.costEditID);
        aboutEdit = (EditText) findViewById(R.id.aboutEditID);
        storeEdit = (EditText) findViewById(R.id.storeEditID);
        dateEdit = (EditText) findViewById(R.id.dateEditID);
        deleteEdit = (EditText) findViewById(R.id.deleteEditID);

        submit = findViewById(R.id.submitID);
        delete = findViewById(R.id.deleteButton);

        final DataBaseCreator myDataBaseCreator = new DataBaseCreator(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutEditString = aboutEdit.getText().toString();
                costEditString = costEdit.getText().toString();
                storeEditString= storeEdit.getText().toString();
                dateEditString = dateEdit.getText().toString();
                // Purchase myNewPurchase = Purchase(costEditString, aboutEditString, storeEditString, dateEditString);
                if (costEditString.isEmpty() && aboutEditString.isEmpty()&& storeEditString.isEmpty()&& dateEditString.isEmpty()){
                    Toast.makeText(EditActivity.this, "Yo!? Fill 'em out, duh!", Toast.LENGTH_SHORT).show();
                } else {
                    myDataBaseCreator.insertData(costEditString, aboutEditString, storeEditString, dateEditString);
                    aboutEdit.setText("");
                    costEdit.setText("");
                    storeEdit.setText("");
                    dateEdit.setText("");
                    Purchase mPurchase = new Purchase(costEditString, aboutEditString, storeEditString, dateEditString);
                    ArrayList<Purchase> blah = MainActivity.mDataList;
                    blah.add(mPurchase);
                    mAdapter2 = new PurchaseAdapter(blah);
                    mAdapter2.notifyDataSetChanged();

                    //ArrayList<Purchase> myOwnArrayList = new ArrayList<>();
                    //Purchase myPurchase = new Purchase(costEditString, aboutEditString, storeEditString, dateEditString);
                    //myOwnArrayList.add(myPurchase);
                    //PurchaseAdapter myAdapter = new PurchaseAdapter(myOwnArrayList);
                    // Intent intent = new Intent(MainActivity.this, PurchaseAdapter.class);
                    // startActivity(intent);
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteEditString = deleteEdit.getText().toString();
                myDataBaseCreator.deleteTitle(deleteEditString);
            }
        });

    }
}
