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
        setupInsertCategory("NULL,'Bread','0','','Null'");
        setupInsertCategory("NUll,'Bread','1','',NULl");
        setupInsertCategory("NUll,'Cereals','1','',NULl");
        setupInsertCategory("NUll,'Frozen bread and roll','1','',NULl");
        setupInsertCategory("NUll,'Crispbread','1','',NULl");

        setupInsertCategory("NUll,'Dessert and baking','0','',NULl");
        setupInsertCategory("NUll,'Baking','2','',NULl");
        setupInsertCategory("NULL,'Biscuit','2','',NULL");

        setupInsertCategory("NULL,'Drink','0','',NULL");
        setupInsertCategory("NULL,'Soda','3','',NULL");

        setupInsertCategory("NULL,'Fruit and vegetable','0','',NULL");
        setupInsertCategory("NULL,'Frozen fruit and vegetable','4','',NULL");
        setupInsertCategory("NULL,'fruit','4','',NULL");
        setupInsertCategory("NULL,'Vegetables','4','',NULL");
        setupInsertCategory("NULL,'Canned fruits and vegetables','2','',NULL");

        setupInsertCategory("NULL,'Health','0','',NULL");
        setupInsertCategory("NULL,'Meal substitutes','5','',NULL");
        setupInsertCategory("NULL,'Protein bars','5','',NULL");
        setupInsertCategory("NULL,'Protein powder','5','',NULL");

        setupInsertCategory("NULL,'Meet chicken and fish','0','',NULL");
        setupInsertCategory("NULL,'Meat','6','',NULL");
        setupInsertCategory("NULL,'Chicken','6','',NULL");
        setupInsertCategory("NULL,'Seafood','6','',NULL");

        setupInsertCategory("NULL,'Dairy and eggs','0','',NULL");
        setupInsertCategory("NULL,'Eggs','6','',NULL");
        setupInsertCategory("NULL,'Cream and sour cream','7','',NULL");
        setupInsertCategory("NULL,'Yogurt','7','',NULL");

        setupInsertCategory("NULL,'Dinner','0','',NULL");
        setupInsertCategory("NULL,'Ready dinner dishes','8','',NULL");
        setupInsertCategory("NULL,'Pizza','8','',NULL");
        setupInsertCategory("NULL,'Noodle','8','',NULL");
        setupInsertCategory("NULL,'pasta','8','',NULL");
        setupInsertCategory("NULL,'Rice','8','',NULL");
        setupInsertCategory("NULL,'Taco','8','',NULL");

        setupInsertCategory("NULL,'Cheese','0','',NULL");
        setupInsertCategory("NULL,'Cold meets','9','',NULL");

        setupInsertCategory("NULL,'On bread','0','',NULL");
        setupInsertCategory("NULL,'Cold meet','10','',NULL");
        setupInsertCategory("NULL,'Sweet spreads','10','',NULL");
        setupInsertCategory("NULL,'Jam','10','',NULL");

        setupInsertCategory("NULL,'Snack','0','',NULL");
        setupInsertCategory("NULL,'Nuts','11','',NULL");
        setupInsertCategory("NULL,'Potato chip','11','',NULL");

    }
}
