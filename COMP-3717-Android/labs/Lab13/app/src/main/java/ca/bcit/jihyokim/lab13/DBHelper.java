package ca.bcit.jihyokim.lab13;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;



public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "lab13_db";
    private static final String TAG = "DBHelper";

    public DBHelper(Context ctx) {
        super(ctx, DB_NAME, null, 1);
        Log.d(TAG, "DBHelper: ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "getHolidays: YOYO");
        db.execSQL("CREATE TABLE IF NOT EXISTS Lab13(HolidayName TEXT, NextDate TEXT, IsFixedDate INTEGER);");

        db.execSQL("INSERT INTO Lab13 VALUES('Christmas', 'December 25, 2020', 1);");
        db.execSQL("INSERT INTO Lab13 VALUES('Easter', 'April 12, 2020', 0)");
        db.execSQL("INSERT INTO Lab13 VALUES('Canada Day', 'July 1, 2020', 1)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Lab13");
        onCreate(db);
    }

    public boolean insertHoliday (Holiday holiday) {
        Log.d(TAG, "insertHoliday: inserting holiday");
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("HolidayName", holiday.getHolidayName());
        contentValues.put("NextDate", holiday.getNextDate());
        contentValues.put("IsFixedDate", holiday.getIsFixedDate());
        db.insert("Lab13", null, contentValues);

        return true;
    }

    public ArrayList<Holiday> getHolidays() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM Lab13", null);
        ArrayList<Holiday> holidays = new ArrayList<>();
        res.moveToFirst();
        Log.d(TAG, "getHolidays: !!!");
        while (!res.isAfterLast()) {
            Log.d(TAG, "getHolidays: ???");
            holidays.add(new Holiday(res.getString(0), res.getString(1), res.getInt(2)));
            res.moveToNext();
        }

        res.close();

        return holidays;
    }
}
