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

        setupInsertFood("Null,'Bread, rye, slice','Sunn', '1 ','gram','2','1 Slice','83','3','15','1','83','3','15','1','1','2','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, rye, slice','Sunn', '1 ','gram','5','1 Slice','83','3','15','1','413','14','77','5','1','2','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, white, soft, slice','Sunn', '1 ','gram','1','1 Slice','66','2','12','1','66','2','12','1','1','2','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, white, soft, slice','Sunn', '1 ','gram','3','1 Slice','66','2','12','1','199','7','37','2','1','2','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, white, soft, slice','Sunn', '1 ','gram','10','1 Slice','66','2','12','1','663','23','123','8','1','2','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, egg, slice','Sunn', '1 ','gram','2','1 Slice','113','4','2','22','226','8','38','5','1','3','1','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, egg, slice','Sunn', '1 ','gram','10','1 Slice','113','4','2','22','1019','34','172','22','1','3','1','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Trix','Taylor', '1 ','gram','2','1 Cup','120','1','27','2','240','2','54','3','3','3','3','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Trix','Taylor', '1 ','gram','5','1 Cup','120','1','27','2','600','5','135','8','1','5','3','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Basic 4','Taylor', '1 ','gram','2','1 Cup','200','4','44','2','400','8','88','4','1','6','3','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Basic 4', 'Taylor','1 ','gram','5','1 Cup','200','4','44','2','1001','20','220','10','1','2','3','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, blueberry, mini loaf, frozen, Jenny Craig','Taylor', '1 ','gram','2',' 1 Each','160','7','32','2','320','14','64','4','1','3','4','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, blueberry, mini loaf, frozen, Jenny Craig','Taylor', '1 ','gram','5',' 1 Each','160','7','32','2','800','35','160','10','1','4','4','1','1','1','1','1'");
        setupInsertFood("Null,'Chicken, patty, breaded, fried, frozen, Ian's','Taylor', '1 ','gram','2',' 1 Each','220','18','16','9','440','36','32','18','1','4','4','1','1','1','1','1'");
        setupInsertFood("Null,'Chicken, patty, breaded, fried, frozen, Ian's','Taylor', '1 ','gram','2',' 1 Each','220','18','16','9','1100','90','80','45','5','2','4','1','1','1','1','1'");
        setupInsertFood("Null,'Crackers, rye, crispbread','Ann', '1 ','gram','2','2 Each','73','2','16','0','146','3','33','1','1','4','5','1','1','1','1','1'");
        setupInsertFood("Null,'Crackers, rye, crispbread', 'Ann','1 ','gram','5','2 Each','73','2','16','0','336','8','82','5','3','2','5','1','1','1','1','1'");
        setupInsertFood("Null,'Chips, potato, sour cream & onion flvr, 7oz bag','Ann', '1 ','gram','2','1 Ounce-weight','151','2','15','10','301','5','29','19','2','3','43','1','1','1','1','1'");
        setupInsertFood("Null,'Chips, potato, sour cream & onion flvr, 7oz bag','Ann', '1 ','gram','5','1 Ounce-weight','151','2','15','10','753','11','73','48','2','5','43','1','1','1','1','1'");
        setupInsertFood("Null,'Chips, potato, baked','Ann', '1 ','gram','2','10 Each','56','1','9','2','113','1','17','4','1','6','43','1','1','1','1','1'");
        setupInsertFood("Null,'Chips, potato, baked','Ann', '1 ','gram','5','10 Each','56','1','9','2','281','3','43','11','1','4','43','1','1','1','1','1'");
        setupInsertFood("Null,'Nuts, almonds, sliced','Sooyoung', '1','gram','2','0.25 Cup','132','5','5','11','265','10','10','23','1','4','42','1','1','1','1','1'");
        setupInsertFood("Null,'Nuts, almonds, sliced','Sooyoung', '1','gram','5','0.25 Cup','132','5','5','11','661','24','25','57','1','4','42','1','1','1','1','1'");
        setupInsertFood("Null,'Nuts, almonds, whole','Sooyoung', '1','gram','2','22 Each','153','6','6','13','304','11','11','26','1','4','42','1','1','1','1','1'");
        setupInsertFood("Null,'Nuts, almonds, whole','Sooyoung', '1','gram','5','22 Each','153','6','6','13','759','28','29','65','1','4','42','1','1','1','1','1'");
        setupInsertFood("Null,'Snack, crisps, soy, salted','Sooyoung', '1','gram','5','25 Each','108','7','15','2','216','15','30','4','1','4','41','1','1','1','1','1'");
        setupInsertFood("Null,'Snack, crisps, soy, salted','Sooyoung', '1','gram','5','25 Each','108','7','15','2','539','37','74','10','1','4','41','1','1','1','1','1'");
        setupInsertFood("Null,'Snack, mix, Chex','Sooyoung', '1','gram','2','1 Cup','199','4','35','5','399','8','70','9','3','4','41','1','1','1','1','1'");
        setupInsertFood("Null,'Snack, mix, Chex','Sooyoung', '1','gram','5','1 Cup','199','4','35','5','797','17','141','19','3','4','41','1','1','1','1','1'");
        setupInsertFood("Null,'Jambolan, fresh','Jack', '1','gram','2','0.5 Cup','41','0','11','0','81','1','21','0','3','4','40','1','1','1','1','1'");
        setupInsertFood("Null,'Jambolan, fresh','Jack', '1','gram','5','0.5 Cup','41','0','11','0','203','2','53','1','3','4','40','1','1','1','1','1'");
        setupInsertFood("Null,'Jam, grape, packet, Burger King','Jack', '1','gram','2','1 Individual Pa','30','0','7','0','60','0','14','0','3','4','40','1','1','1','1','1'");
        setupInsertFood("Null,'Jam, grape, packet, Burger King','Jack', '1','gram','5','1 Individual Pa','30','0','7','0','120','0','28','0','3','4','40','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese Spread, American','Yoo', '1','gram','2',' 2 Tablespoon','93','5','3','7','186','11','6','14','1','1','39','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese Spread, past, proc','Yoo', '1','gram','2','1 Serving','91','5','3','7','182','10','6','13','1','1','39','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetarian Meat, sandwich spread','Yoo', '1','gram','2',' 1 Tablespoon','22','5','3','1','45','2','3','3','1','1','39','1','1','1','1','1'");
        setupInsertFood("Null,'Spread, vegetable oi, fat free, tub','Yoo', '1','gram','2',' 1 Tablespoon','6','0','1','0','13','0','1','1','1','1','39','1','1','1','1','1'");
        setupInsertFood("Null,'Tea, cold brew, bags, Lipton','Harry', '1','gram','2','1 Each','0','0','0','0','0','0','0','0','1','1','38','1','1','1','1','1'");
        setupInsertFood("Null,'Smoothie, Coldbuster, lrg, Jamba Juice','Harry', '1','gram','2','1 Large','500','7','1','6','1000','14','234','4','1','1','38','1','1','1','1','1'");
        setupInsertFood("Null,'Ice Cream, mocha, like it, Cold Stone Creamery','Harry', '1','gram','2','1 Each','390','7','40','24','780','14','80','48','1','1','38','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, honey wheat berry, dry svg, Krusteaz','Adele', '1','gram','2','1/3 cup','150','4','28','2','300','8','56','4','1','1','37','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, honey wheatberry, Oroweat','Adele', '1','gram','2','1 slice','110','4','21','1','220','8','42','2','1','1','37','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, lemon poppyseed, Caribou Coffee','Adele', '1','gram','2','1 slice','470','6','56','26','940','12','112','52','1','1','37','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, brown, S&W','Adele', '1','gram','2','1/2 piece','90','3','21','1','180','6','42','2','1','1','37','1','1','1','1','1'");
        setupInsertFood("Null,'Sausage, liver, Koegel Meats','Bentley', '1','gram','2',' 1 serving','150','8','3','12','300','16','6','24','1','1','36','1','1','1','1','1'");
        setupInsertFood("Null,'Sandwich Topping, Italian BMT meats, Subway','Bentley', '1','gram','2',' 1 serving','180','11','2','14','360','22','4','28','1','1','36','1','1','1','1','1'");
        setupInsertFood("Null,'Lunchmeat, bologna, ring, Koegel Meats','Bentley', '1','gram','2',' 1 serving','180','7','2','17','360','14','4','34','1','1','36','1','1','1','1','1'");
        setupInsertFood("Null,'Buffalo, burger, extra lean, raw, Maverick Ranch','Bentley', '1','gram','2','4 ounce-weight','140','24','0','4','280','48','0','8','1','1','36','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese Spread, American','Gemma', '1','gram','2','2 Tablespoon','93','5','3','7','186','11','6','14','1','1','35','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese, blue, crumbled','Gemma', '1','gram','2','1/4 cup','119','7','1','10','238','14','2','19','1','1','35','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese, brie, sliced','Gemma', '1','gram','2','1/4 cup','120','7','0','10','240','15','0','20','1','1','35','1','1','1','1','1'");
        setupInsertFood("Null,'Cheese, fondue','Gemma', '1','gram','2','1/4 cup'," +
                "'124','8','2','7','247','15','4','15'," +
                "'1','1','35','1','1','1','1','1'");

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
        setupInsertCategory("NULL,'Cold meats','9','',NULL");

        setupInsertCategory("NULL,'On bread','0','',NULL");
        setupInsertCategory("NULL,'Cold meet','10','',NULL");
        setupInsertCategory("NULL,'Sweet spreads','10','',NULL");
        setupInsertCategory("NULL,'Jam','10','',NULL");

        setupInsertCategory("NULL,'Snack','0','',NULL");
        setupInsertCategory("NULL,'Nuts','11','',NULL");
        setupInsertCategory("NULL,'Potato chip','11','',NULL");

    }
}
