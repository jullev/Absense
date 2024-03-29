package id.flwi.util;

/**
 * @author Arief Bayu Purwanto
 */
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBUtil {
	public static void createTable(SQLiteDatabase database, String tableName1,
			String sqlCreate) {
		try {
			// begin the transaction
			database.beginTransaction();

			database.execSQL(sqlCreate);
			Log.d(tableName1, sqlCreate);
			// this makes sure transaction is committed
			database.setTransactionSuccessful();
		} finally {
			database.endTransaction();
		}
	}

	public static boolean isTableEmpty(SQLiteDatabase db, String table) {
		Cursor cursor = null;
		try {
			cursor = db.rawQuery("SELECT count(*) AS cnt FROM " + table, null);

			int countIndex = cursor.getColumnIndex("cnt");
			cursor.moveToFirst();
			int rowCount = cursor.getInt(countIndex);
			if (rowCount > 0) {
				return false;
			}

			return true;
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
	}
}
