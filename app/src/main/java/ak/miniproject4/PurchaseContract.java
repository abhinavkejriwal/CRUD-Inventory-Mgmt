package ak.miniproject4;

import android.provider.BaseColumns;

public final class PurchaseContract {

    public static final class SchemaDef implements BaseColumns {
        public static final String TABLE_NAME = "purchaseData";
        public static final String COST = "cost";
        public static final String DESCRIPTION = "description";
        public static final String STORE = "store";
        public static final String DATE = "date";
    }
}
