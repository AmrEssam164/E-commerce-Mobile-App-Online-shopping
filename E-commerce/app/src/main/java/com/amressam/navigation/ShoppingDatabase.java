package com.amressam.navigation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ShoppingDatabase extends SQLiteOpenHelper {
    private static final String TAG = "ShoppingDatabase";
    SQLiteDatabase sqLiteDatabase;
    private static String databaseName = "Database";

    public ShoppingDatabase(Context context) {
        super(context, databaseName, null, 5);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: starts");
        db.execSQL("create table Registration (customer_id integer primary key autoincrement,email text not null" +
                ",name text not null,password text not null,first_school text not null,favourite_color text not null,birthdate text not null)");
        db.execSQL("create table product (product_id integer primary key autoincrement" +
                ",name text not null,quantity integer , price integer not null , photo integer not null,category text not null)");
        db.execSQL("create table cart (photo integer not null" +
                ",name text not null,price String not null,quantity integer not null,purchased text not null,username text not null)");

        ContentValues row1 = new ContentValues();
        row1.put("email", "user1@yahoo.com");
        row1.put("name", "Nadeen Adel");
        row1.put("password", "8121998");
        row1.put("first_school", "ibn_khaldon");
        row1.put("favourite_color", "black");
        row1.put("birthdate","12/8/1998");
        db.insert("Registration", null, row1);
        row1.put("email", "user2@yahoo.com");
        row1.put("name", "Amr Essam");
        row1.put("password", "2621999");
        row1.put("first_school", "khateb");
        row1.put("favourite_color", "blue");
        row1.put("birthdate","2/26/1999");
        db.insert("Registration", null, row1);

        ContentValues row2 = new ContentValues();
        row2.put("name", "Adidas shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165338);
        db.insert("product ", null, row2);

        row2.put("name", "Black shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165339);
        db.insert("product ", null, row2);

        row2.put("name", "Gap shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165340);
        db.insert("product ", null, row2);

        row2.put("name", "Green shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165341);
        db.insert("product ", null, row2);

        row2.put("name", "Nike shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165342);
        db.insert("product ", null, row2);

        row2.put("name", "Polo shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165343);
        db.insert("product ", null, row2);

        row2.put("name", "Sport shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165344);
        db.insert("product ", null, row2);

        row2.put("name", "White shirt");
        row2.put("quantity", 10);
        row2.put("category","men_t-shirts");
        row2.put("price", 500);
        row2.put("photo",2131165345);
        db.insert("product ", null, row2);


        row2.put("name", "Black pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165322);
        db.insert("product ", null, row2);

        row2.put("name", "Black jacket");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165323);
        db.insert("product ", null, row2);

        row2.put("name", "Blue jacket");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165324);
        db.insert("product ", null, row2);

        row2.put("name", "Gap pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165325);
        db.insert("product ", null, row2);

        row2.put("name", "Gray pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165326);
        db.insert("product ", null, row2);

        row2.put("name", "Guess pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165327);
        db.insert("product ", null, row2);

        row2.put("name", "Magazine pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165328);
        db.insert("product ", null, row2);

        row2.put("name", "Red pullover");
        row2.put("quantity", 10);
        row2.put("category","men_outer_wears");
        row2.put("price", 500);
        row2.put("photo",2131165329);
        db.insert("product ", null, row2);

        row2.put("name", "Black jeans");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165330);
        db.insert("product ", null, row2);

        row2.put("name", "White jabrden");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165331);
        db.insert("product ", null, row2);

        row2.put("name", "Blue jeans");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165332);
        db.insert("product ", null, row2);

        row2.put("name", "Black jabrden");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165333);
        db.insert("product ", null, row2);

        row2.put("name", "Legen jeans");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165334);
        db.insert("product ", null, row2);

        row2.put("name", "Dark blue jeans");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165335);
        db.insert("product ", null, row2);

        row2.put("name", "Polo kens");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165336);
        db.insert("product ", null, row2);

        row2.put("name", "Slim fit black blue");
        row2.put("quantity", 10);
        row2.put("category","men_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165337);
        db.insert("product ", null, row2);

        row2.put("name", "Baby blue blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165308);
        db.insert("product ", null, row2);

        row2.put("name", "Bej blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165309);
        db.insert("product ", null, row2);

        row2.put("name", "Black blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165310);
        db.insert("product ", null, row2);

        row2.put("name", "Karoh blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165311);
        db.insert("product ", null, row2);

        row2.put("name", "Pink blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165312);
        db.insert("product ", null, row2);

        row2.put("name", "Red blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165313);
        db.insert("product ", null, row2);

        row2.put("name", "Tiger blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165314);
        db.insert("product ", null, row2);

        row2.put("name", "White blouse");
        row2.put("quantity", 10);
        row2.put("category","women_blouse");
        row2.put("price", 500);
        row2.put("photo",2131165315);
        db.insert("product ", null, row2);

        row2.put("name", "Baby blue dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165191);
        db.insert("product ", null, row2);

        row2.put("name", "Black dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165192);
        db.insert("product ", null, row2);

        row2.put("name", "Jeans dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165193);
        db.insert("product ", null, row2);

        row2.put("name", "Pink dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165194);
        db.insert("product ", null, row2);

        row2.put("name", "Red dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165195);
        db.insert("product ", null, row2);

        row2.put("name", "Silver dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165196);
        db.insert("product ", null, row2);

        row2.put("name", "White dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165197);
        db.insert("product ", null, row2);

        row2.put("name", "Yellow dress");
        row2.put("quantity", 10);
        row2.put("category","women_dresses");
        row2.put("price", 500);
        row2.put("photo",2131165198);
        db.insert("product ", null, row2);

        row2.put("name", "Black jeanss");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165297);
        db.insert("product ", null, row2);

        row2.put("name", "Black legan");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165298);
        db.insert("product ", null, row2);

        row2.put("name", "Blue skiny");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165299);
        db.insert("product ", null, row2);

        row2.put("name", "High waust jeans");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165300);
        db.insert("product ", null, row2);

        row2.put("name", "Mom fit jeans");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165301);
        db.insert("product ", null, row2);

        row2.put("name", "Skiny");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165302);
        db.insert("product ", null, row2);

        row2.put("name", "Snow skiny");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165303);
        db.insert("product ", null, row2);

        row2.put("name", "White pants");
        row2.put("quantity", 10);
        row2.put("category","women_jeans");
        row2.put("price", 500);
        row2.put("photo",2131165304);
        db.insert("product ", null, row2);


        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Registration");
        db.execSQL("drop table if exists product");
        db.execSQL("drop table if exists cart");
        onCreate(db);
    }


    public Cursor log_in() {
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select email ,password from Registration",null);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }

    public Cursor Retrive_username(String email) {
        sqLiteDatabase = getReadableDatabase();
        String[] arr={email};
        Cursor cursor = sqLiteDatabase.rawQuery("select name from Registration where email like ?",arr);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }


    public Cursor Retrive_products(String cat) {
        sqLiteDatabase = getReadableDatabase();
        String[] arr={cat};
        Cursor cursor = sqLiteDatabase.rawQuery("select photo,name ,price from product where category like ?",arr);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }

    public Cursor Retrive_all() {
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select photo,name ,price from product",null);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }


    public void createNewRow(String email,String username,String password,String school,String color,String date)
    {
        ContentValues row = new ContentValues();
        row.put("email",email);
        row.put("name",username);
        row.put("password",password);
        row.put("first_school",school);
        row.put("favourite_color",color);
        row.put("birthdate",date);
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("Registration",null,row);
        sqLiteDatabase.close();
    }


    public void add_to_cart(String name,String price,Integer quantity,Integer photo,String username)
    {
        ContentValues row = new ContentValues();
        row.put("name",name);
        row.put("price",price);
        row.put("quantity",quantity);
        row.put("photo",photo);
        row.put("purchased","no");
        row.put("username",username);
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("cart",null,row);
        sqLiteDatabase.close();
    }

    public void delete_from_cart(String name)
    {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("cart","name='"+name+"'",null);
        sqLiteDatabase.close();
    }

    public void delete_all_cart(String username)
    {
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("cart","username='"+username+"'",null);
        sqLiteDatabase.close();
    }

    public void update_cart(String name,int new_quantity)
    {
        sqLiteDatabase = getWritableDatabase();
        String [] arr = {String.valueOf(name)};
        ContentValues row = new ContentValues();
        row.put("quantity",new_quantity);
        sqLiteDatabase.update("cart",row,"name like ?",arr);
        sqLiteDatabase.close();
    }

    public void update_photo(String name,int photo)
    {
        sqLiteDatabase = getWritableDatabase();
        String [] arr = {name};
        ContentValues row = new ContentValues();
        row.put("photo",photo);
        sqLiteDatabase.update("product",row,"name like ?",arr);
        sqLiteDatabase.close();
    }

    public Cursor Retrive_card(String username) {
        String[] arr = {username};
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from cart where username like ?",arr);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }

    public Cursor buy(){
        sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select price,quantity from cart",null);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }


   public Cursor Search(String name){
        String [] arr = {name};
       sqLiteDatabase = getReadableDatabase();
       Cursor cursor = sqLiteDatabase.rawQuery("select photo,name,price from product where name like ?",arr);
       cursor.moveToFirst();
       sqLiteDatabase.close();
       return cursor;
   }

    public Cursor forget(String school, String color) {
        String[] arr = {school,color};
        sqLiteDatabase = getReadableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery("select password from Registration where first_school like ?",arr);
        Cursor cursor = sqLiteDatabase.rawQuery("select password from  Registration where first_school = ? and favourite_color  = ?", arr);
        cursor.moveToFirst();
        sqLiteDatabase.close();
        return cursor;
    }

}
