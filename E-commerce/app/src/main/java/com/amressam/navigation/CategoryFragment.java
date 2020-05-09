package com.amressam.navigation;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryFragment extends Fragment implements CategoryRecyclerViewAdapter.AdapterOnClickHandler{

    public static String cat1;
    public static String cat2;
    public static String cat3;
    public static String cat4;
    RecyclerView category_recycler_view;
    public static CategoryRecyclerViewAdapter mCategoryRecyclerViewAdapter;
    ShoppingDatabase shoppingDatabase;
    ArrayList<CategoryImages> menProducts;
    public ArrayList<CategoryImages> womenProducts;
    public ArrayList<Product> selectedCategoryProducts;
    Cursor cursor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.category_fragment, container, false);
        category_recycler_view = (RecyclerView) root.findViewById(R.id.category_recycler_view);
        mCategoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(new ArrayList<CategoryImages>(),getContext(),this);
        category_recycler_view.setAdapter(mCategoryRecyclerViewAdapter);
        cat1="men_t-shirts";
        cat2="men_outer_wears";
        cat3="men_jeans";
        cat4="men_shoes";
        shoppingDatabase = new ShoppingDatabase(getContext());
        menProducts = new ArrayList<CategoryImages>();
        menProducts.add(new CategoryImages(R.drawable.screen1));
        menProducts.add(new CategoryImages(R.drawable.screen2));
        menProducts.add(new CategoryImages(R.drawable.screen3));
        menProducts.add(new CategoryImages(R.drawable.screen4));

        womenProducts = new ArrayList<CategoryImages>();
        womenProducts.add(new CategoryImages(R.drawable.screen5));
        womenProducts.add(new CategoryImages(R.drawable.screen6));
        womenProducts.add(new CategoryImages(R.drawable.screen7));
        womenProducts.add(new CategoryImages(R.drawable.screen8));

        mCategoryRecyclerViewAdapter.loadNewData(menProducts);

        selectedCategoryProducts = new ArrayList<Product>();
        return root;
    }


    @Override
    public void onCategoryClicked(int position) {
        selectedCategoryProducts.clear();
        if (position == 0) {
            if(cat1.equals("men_t-shirts")) {
                cursor = shoppingDatabase.Retrive_products(cat1);
                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }
            } else if (cat1.equals("women_blouse")){
                cursor = shoppingDatabase.Retrive_products(cat1);
                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }
            }

        }
        if (position == 1) {
            if(cat2.equals("men_outer_wears")) {
                cursor = shoppingDatabase.Retrive_products(cat2);
                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }

            } else if (cat2.equals("women_dresses")){
                cursor = shoppingDatabase.Retrive_products(cat2);

                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }
            }


        }
        if (position == 2) {
            if(cat3.equals("men_jeans")) {
                cursor = shoppingDatabase.Retrive_products(cat3);
                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }

            } else if (cat3.equals("women_jeans")){
                cursor = shoppingDatabase.Retrive_products(cat3);

                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }
            }

        }
        if (position == 3) {
            if(cat4.equals("men_shoes")) {
                cursor = shoppingDatabase.Retrive_products(cat4);
                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }

            } else if (cat4.equals("women_shoes")){
                cursor = shoppingDatabase.Retrive_products(cat4);

                while (!cursor.isAfterLast()) {
                    selectedCategoryProducts.add(new Product(cursor.getInt(0),cursor.getString(1),cursor.getString(2)));
                    cursor.moveToNext();
                }
            }

        }
        ProductFragment productFragment = new ProductFragment();
        productFragment.setSelectedGategoryProducts(selectedCategoryProducts);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,productFragment).commit();
        MainActivity.navigationView.setCheckedItem(R.id.nav_products);
        MainActivity.my_menu.clear();
        getActivity().getMenuInflater().inflate(R.menu.show_product,MainActivity.my_menu);
    }
}
