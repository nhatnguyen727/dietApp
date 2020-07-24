package com.example.dailyapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    /* 01 Variable-------------------**/
    private static final String databaseName = "diet1";
    private  static final  int databaseVersion = 9;

    /* 02 Database Variable ---------**/
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    /* 03 Class DBAdapter -------------*/

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context){
            super(context, databaseName, null,databaseVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                //Create table
                db.execSQL("CREATE TABLE IF NOT EXISTS category (" +
                        " category_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        " category_name VARCHAR, "+
                        " category_parent_id INT, "+
                        " category_icon VARCHAR, "+
                        " category_notes VARCHAR);");

                db.execSQL("CREATE TABLE IF NOT EXISTS food (" +
                           " food_id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                           " food_name VARCHAR," +
                           " food_manufactor_name VARCHAR," +
                           " food_serving_size DOUBLE," +
                           " food_serving_measurement VARCHAR," +
                           " food_serving_name_number DOUBLE," +
                           " food_serving_name_word VARCHAR," +
                           " food_energy DOUBLE," +
                           " food_protein DOUBLE," +
                           " food_carbohydrates DOUBLE," +
                           " food_fat DOUBLE," +
                           " food_energy_calculated DOUBLE," +
                           " food_protein_calculated DOUBLE," +
                           " food_carbohydrates_calculated DOUBLE," +
                           " food_fat_calculated DOUBLE," +
                           " food_user_id INT," +
                           " food_barcode VARCHAR," +
                           " food_category_id INT," +
                           " food_thumb VARCHAR," +
                           " food_image_a VARCHAR," +
                           " food_image_b VARCHAR," +
                           " food_image_c VARCHAR," +
                           " food_notes VARCHAR);");
            }
            catch (SQLException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Drop older table if existed
            //db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);

            // Create tables again
            db.execSQL("DROP TABLE IF EXISTS food ");
            db.execSQL("DROP TABLE IF EXISTS category ");
            onCreate(db);

            String TAG= "Tag";
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
            + newVersion + ", which will destroy all old data");
        }
    }//DatabaseHelper

    /*05 Open Database-------------------*/
    public DBAdapter open() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return this;
    }

    /*06 Close Database------------------*/
    public void close(){
        DBHelper.close();
    }

    /* 07 insert data */
    public  void insert(String table, String field, String values){
        db.execSQL("INSERT INTO "+ table + "(" +field + ") VALUES (" + values + ")");
    }

    /* 09 Count ------------------------*/
    public int countRecord(String table){
        Cursor mCount = db.rawQuery("SELECT COUNT(*) FROM " +table + "",null);
        mCount.moveToFirst();
        int count=mCount.getInt(0);
        mCount.close();
        return count;
    }
}
