package com.example.dailyapp;

import android.content.Context;

public class DBSetupInsert {

    //variable
     private final Context context;

    //public class -------------------------*/
    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }

    /* Setup in to food ---------------------*/
    //insert in to food table
    public void setupInsertFood(String values){
        DBAdapter db = new DBAdapter(context);
        db.open();
        db.insert("food",
                "food_id,food_name,food_manufactor_name,food_serving_size,food_serving_measurement,food_serving_name_number,food_serving_name_word,food_energy,food_protein,food_carbohydrates,food_fat,food_energy_calculated,food_protein_calculated,food_carbohydrates_calculated,food_fat_calculated,food_user_id,food_barcode,food_category_id,food_thumb,food_image_a,food_image_b,food_image_c,food_notes",
                values);
        db.close();
    }
    //insert food into database---------------*/
    public void insertAllFood(){
        setupInsertFood("Null,'Egg, whole, cooked, hard-boiled', 'Prior', '13','gram','2','wtf','232','23','23','23','232','23','23','23','1','1','1','1','1','1','1','1'");
    }

    //insert in to category table
    public void setupInsertCategory(String values){
        DBAdapter db =new DBAdapter((context));
        db.open();
        db.insert("category",
                "category_id,category_name,category_parent_id,category_icon,category_notes",
                values);
        db.close();
    }

    public void insertAllCategory(){
        setupInsertCategory("NULL,'Dairy and egg','1','','Null'");
    }
}
