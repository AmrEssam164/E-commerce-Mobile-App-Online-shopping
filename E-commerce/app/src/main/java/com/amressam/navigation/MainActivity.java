package com.amressam.navigation;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.speech.RecognizerIntent;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CategoryRecyclerViewAdapter.AdapterOnClickHandler {

    DrawerLayout drawer;
    public static NavigationView navigationView;
    public static Menu my_menu;
    Toolbar toolbar;
    ShoppingDatabase mShoppingDatabase;
    Cursor mCursor;
    TextView email;
    public static TextView username;
    ArrayList<Product> allProducts;
    ArrayList<CartProducts> cartProducts;
    ArrayList<Product> searchedProducts;
    int voiceCode = 1;
    public static String cam_result = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        email = (TextView) headerView.findViewById(R.id.profile_email);
        username = (TextView) headerView.findViewById(R.id.profile_username);
        mShoppingDatabase = new ShoppingDatabase(this);

        setToolbar();
        setUserInformation();

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new com.amressam.navigation.CategoryFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_categories);
        }
    }

    private void setToolbar(){

        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.mynewgradient));
        getSupportActionBar().setTitle("Categories");
    }

    private void setUserInformation(){
        Intent intent = getIntent();
        String user_email = intent.getStringExtra(LoginActivity.EMAIL_INTENT);
        String user_username="";
        Cursor cursor = mShoppingDatabase.Retrive_username(user_email);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            user_username = cursor.getString(0);
        }
        email.setText(user_email);
        username.setText(user_username);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        my_menu = menu;
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings1:
                Toast.makeText(this, "Settings 1", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_settings2:
                Toast.makeText(this, "Settings 2", Toast.LENGTH_LONG).show();
                break;
            case R.id.men:
                com.amressam.navigation.CategoryFragment.cat1 = "men_t-shirts";
                com.amressam.navigation.CategoryFragment.cat2 = "men_outer_wears";
                com.amressam.navigation.CategoryFragment.cat3 = "men_jeans";
                com.amressam.navigation.CategoryFragment.cat4 = "men_shoes";
                ArrayList<CategoryImages> menProducts;
                menProducts = new ArrayList<CategoryImages>();
                menProducts.add(new CategoryImages(R.drawable.screen1));
                menProducts.add(new CategoryImages(R.drawable.screen2));
                menProducts.add(new CategoryImages(R.drawable.screen3));
                menProducts.add(new CategoryImages(R.drawable.screen4));
                com.amressam.navigation.CategoryFragment.mCategoryRecyclerViewAdapter.loadNewData(menProducts);
                break;
            case R.id.women:
                com.amressam.navigation.CategoryFragment.cat1 = "women_blouse";
                com.amressam.navigation.CategoryFragment.cat2 = "women_dresses";
                com.amressam.navigation.CategoryFragment.cat3 = "women_jeans";
                com.amressam.navigation.CategoryFragment.cat4 = "women_shoes";
                ArrayList<CategoryImages> womenProducts;
                womenProducts = new ArrayList<CategoryImages>();
                womenProducts.add(new CategoryImages(R.drawable.screen5));
                womenProducts.add(new CategoryImages(R.drawable.screen6));
                womenProducts.add(new CategoryImages(R.drawable.screen7));
                womenProducts.add(new CategoryImages(R.drawable.screen8));
                com.amressam.navigation.CategoryFragment.mCategoryRecyclerViewAdapter.loadNewData(womenProducts);
                break;
            case R.id.voice:
                Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                startActivityForResult(i, voiceCode);
                break;
            case R.id.action_search:
                Intent scan_intent = new Intent(getApplicationContext(), ScanCodeActivity.class);
                startActivity(scan_intent);
            case R.id.loc:
                Intent map_intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(map_intent);
                break;
            case R.id.buy:
                if(CartFragment.reciver == null)
                {
                    Toast.makeText(this,"Please enter your location first.",Toast.LENGTH_LONG).show();
                }
                else {
                    int total = 0;
                    Cursor cursor = mShoppingDatabase.Retrive_card(username.getText().toString());
                    while (!cursor.isAfterLast()) {
                        total += Integer.valueOf(cursor.getString(2)) * cursor.getInt(3);
                        cursor.moveToNext();
                    }
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("Your total amount of price is " + String.valueOf(total) + " and your location is " + CartFragment.reciver + ", Confirm the purchase?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mShoppingDatabase.delete_all_cart(username.getText().toString());
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.container, new com.amressam.navigation.CategoryFragment()).commit();
                            my_menu.clear();
                            getMenuInflater().inflate(R.menu.menu_items, my_menu);
                        }
                    }).setNegativeButton("No", null);
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_categories:
                getSupportActionBar().setTitle("Categories");
                my_menu.clear();
                getMenuInflater().inflate(R.menu.menu_items, my_menu);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new com.amressam.navigation.CategoryFragment()).commit();
                break;
            case R.id.nav_products:
                getSupportActionBar().setTitle("Products");
                my_menu.clear();
                getMenuInflater().inflate(R.menu.show_product, my_menu);
                allProducts = new ArrayList<Product>();
                mCursor = mShoppingDatabase.Retrive_all();
                while (!mCursor.isAfterLast()) {
                    allProducts.add(new Product(mCursor.getInt(0), mCursor.getString(1), mCursor.getString(2)));
                    mCursor.moveToNext();
                }
                ProductFragment productFragment = new ProductFragment();
                productFragment.setSelectedGategoryProducts(allProducts);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, productFragment).commit();
                break;
            case R.id.nav_cart:
                getSupportActionBar().setTitle("Cart");
                my_menu.clear();
                getMenuInflater().inflate(R.menu.menu_submisson, my_menu);
                cartProducts = new ArrayList<CartProducts>();
                mCursor = mShoppingDatabase.Retrive_card(username.getText().toString());
                while (!mCursor.isAfterLast()) {
                    cartProducts.add(new CartProducts(mCursor.getInt(0), mCursor.getString(1), mCursor.getString(2), mCursor.getInt(3),mCursor.getString(4),mCursor.getString(5)));
                    mCursor.moveToNext();
                }
                CartFragment cartFragment = new CartFragment();
                cartFragment.setCartProducts(cartProducts);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, cartFragment).commit();
                break;
            case R.id.nav_logout:
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String result = sharedPreferences.getString(LoginActivity.REMEMBER_ME, "no");
                if(result.equals("yes")){
                    sharedPreferences.edit().putString(LoginActivity.REMEMBER_ME,"no").apply();
                    sharedPreferences.edit().putString(LoginActivity.EMAIL_PREFERENCE,"").apply();
                    onBackPressed();
                }else {
                    onBackPressed();
                }
                break;
        }
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == voiceCode && resultCode == RESULT_OK) {
            ArrayList<String> text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            searchResult(text.get(0));

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        boolean check = true;
        if (cam_result == null) {
            check = false;
        }
        if (check) {
            searchResult(cam_result);
            cam_result = "";
        }
    }


    private void searchResult(String text) {
        searchedProducts = new ArrayList<Product>();
        Cursor cursor = mShoppingDatabase.Search(text);
        if (cursor.getCount() == 0) {
            CategoryRecyclerViewAdapter categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(new ArrayList<CategoryImages>(), this, this);
            CategoryImages categoryImages = new CategoryImages(R.drawable.img_not_found3);
            ArrayList<CategoryImages> not_found = new ArrayList<CategoryImages>();
            not_found.add(categoryImages);
            ProductFragment.mProducts_recyclerview.setAdapter(categoryRecyclerViewAdapter);
            categoryRecyclerViewAdapter.loadNewData(not_found);
        } else {
            while (!cursor.isAfterLast()) {
                searchedProducts.add(new Product(cursor.getInt(0), cursor.getString(1), cursor.getString(2)));
                cursor.moveToNext();
            }
            ProductFragment.mProducts_recyclerview.setAdapter(ProductFragment.mProductsRecyclerViewAdapter);
            ProductFragment.mProductsRecyclerViewAdapter.loadNewData(searchedProducts);
        }
    }

    @Override
    public void onCategoryClicked(int position) {

    }
}
