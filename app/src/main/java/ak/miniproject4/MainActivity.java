package ak.miniproject4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button inventoryButton;
    PurchaseAdapter mAdapter;
    ArrayList<Purchase> mDataList = new ArrayList<Purchase>();
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText costEdit, aboutEdit, storeEdit, dateEdit, deleteEdit;
    String costEditString, aboutEditString, storeEditString, dateEditString;
    Button submit, delete;
    //SQLiteDatabase mine = this.;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        putData();

        mAdapter = new PurchaseAdapter(mDataList);
        recyclerView.setAdapter(mAdapter);

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

                    Toast.makeText(MainActivity.this, "Yo!? Fill 'em out, duh!", Toast.LENGTH_SHORT).show();
                }else {

                    myDataBaseCreator.insertData(costEditString, aboutEditString, storeEditString, dateEditString);
                    aboutEdit.setText("");
                    costEdit.setText("");
                    storeEdit.setText("");
                    dateEdit.setText("");
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

        // inventoryButton = findViewById(R.id.inventButton);
/*         inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PurchaseAdapter.class);
                startActivity(i);
            }
        });*/


    }

    public void putData() {
        Purchase purchase1 = new Purchase("15", "Wendys", "John", "5 March 2019");
        Purchase purchase2 = new Purchase("30", "McDonalds", "Larry", "5 March 2019");
        Purchase purchase3 = new Purchase("124", "Dominoes", "Sergei", "5 March 2019");
        Purchase purchase4 = new Purchase("56", "Abe's", "Mark", "5 March 2019");
        Purchase purchase5 = new Purchase("75", "Sliver", "Steve", "5 March 2019");
        mDataList.add(purchase1);
        mDataList.add(purchase2);
        mDataList.add(purchase3);
        mDataList.add(purchase4);
        mDataList.add(purchase5);
    }
}

/*
package com.mytrendin.databasecheck;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Button submit,show;
        DatabaseHelper databaseHelper;

         EditText etname,etemail,etcompany,etnumber;
         String name,city,company,country ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = (EditText) findViewById(R.id.etname);
        etemail = (EditText) findViewById(R.id.etemail);
        etcompany = (EditText) findViewById(R.id.etcompany);
        etnumber = (EditText) findViewById(R.id.etphone);
        submit = (Button) findViewById(R.id.submit);


        submit = (Button) findViewById(R.id.submit);
        show= (Button) findViewById(R.id.show);

        databaseHelper = new DatabaseHelper(this);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etname.getText().toString();
                city = etemail.getText().toString();
                company=etcompany.getText().toString();
                country = etnumber.getText().toString();
                //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
                if (name.isEmpty() && city.isEmpty()&& company.isEmpty()&& country.isEmpty()){

                    Toast.makeText(MainActivity.this, "please fill details", Toast.LENGTH_SHORT).show();
                }else {

                    databaseHelper.insertdata(name,company,city,country);
                    etname.setText("");
                    etemail.setText("");
                    etcompany.setText("");
                    etnumber.setText("");
                    Intent intent = new Intent(MainActivity.this,Viewall.class);
                    startActivity(intent);

                }
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Viewall.class);
                startActivity(intent);
            }
        });
    }
}
*
* */