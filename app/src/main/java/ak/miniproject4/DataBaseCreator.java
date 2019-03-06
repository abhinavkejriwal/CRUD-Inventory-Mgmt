package ak.miniproject4;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static ak.miniproject4.PurchaseContract.SchemaDef.COST;
import static ak.miniproject4.PurchaseContract.SchemaDef.DATE;
import static ak.miniproject4.PurchaseContract.SchemaDef.DESCRIPTION;
import static ak.miniproject4.PurchaseContract.SchemaDef.STORE;
import static ak.miniproject4.PurchaseContract.SchemaDef.TABLE_NAME;

public class DataBaseCreator extends SQLiteOpenHelper {

    //stored local variable for the database that OpenHelper opens
    //public SQLiteDatabase database;
    // public DataBaseCreator dataBaseCreator;

    public static final int DATABASE_VERSION = 1; //WHY
    public static final String DATABASE_NAME = "DataBaseCreator.db";

    public DataBaseCreator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //dataBaseCreator = new DataBaseCreator(context); // Logic from Github: https://gist.github.com/JamesHovious/7231185
        // database = dataBaseCreator.getWritableDatabase(); // Logic from Github: https://gist.github.com/JamesHovious/7231185

    }

    public boolean deleteTitle(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return
                db.delete(TABLE_NAME, COST + "=" + name, null) ||
                        db.delete(TABLE_NAME, DESCRIPTION + "=" + name, null) ||
                        db.delete(TABLE_NAME, STORE + "=" + name, null) ||
                        db.delete(TABLE_NAME, DATE + "=" + name, null);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + "( " +
                COST + " Cost, " +
                DESCRIPTION + " Description, " +
                STORE + " Store, " +
                DATE + " Date )";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String cost, String description, String store, String date) { //had Purchase p, but was not using it anywhere. but at the same time, isn't it breaking absraction barrier?
        SQLiteDatabase db = this.getWritableDatabase(); //what is 'this' here?
        ContentValues contentValues = new ContentValues();
        contentValues.put(COST, cost);
        contentValues.put(DESCRIPTION, description);
        contentValues.put(STORE, store);
        contentValues.put(DATE, date);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    //What is the purpose of this?
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    //What does it mean for a databse version to be upgraded or downgraded?


}
