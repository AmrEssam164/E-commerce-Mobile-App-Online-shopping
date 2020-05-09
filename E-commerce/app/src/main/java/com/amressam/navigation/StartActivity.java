package com.amressam.navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Button button;
    ShoppingDatabase mShoppingDatabase;
    public static final String REMEMBER_ME = "remember";
    public static final String EMAIL_PREFERENCE = "email";
    public static final String EMAIL_INTENT = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        button = (Button) findViewById(R.id.button);
        mShoppingDatabase=new ShoppingDatabase(getApplicationContext());

        mShoppingDatabase.update_photo("Adidas shirt",R.drawable.g1);
        mShoppingDatabase.update_photo("Black shirt",R.drawable.g2);
        mShoppingDatabase.update_photo("Gap shirt",R.drawable.g3);
        mShoppingDatabase.update_photo("Green shirt",R.drawable.g4);
        mShoppingDatabase.update_photo("Nike shirt",R.drawable.g5);
        mShoppingDatabase.update_photo("Polo shirt",R.drawable.g6);
        mShoppingDatabase.update_photo("Sport shirt",R.drawable.g7);
        mShoppingDatabase.update_photo("White shirt",R.drawable.g8);
        mShoppingDatabase.update_photo("Black pullover",R.drawable.e1);
        mShoppingDatabase.update_photo("Black jacket",R.drawable.e2);
        mShoppingDatabase.update_photo("Blue jacket",R.drawable.e3);
        mShoppingDatabase.update_photo("Gap pullover",R.drawable.e4);
        mShoppingDatabase.update_photo("Gray pullover",R.drawable.e5);
        mShoppingDatabase.update_photo("Guess pullover",R.drawable.e6);
        mShoppingDatabase.update_photo("Magazine pullover",R.drawable.e7);
        mShoppingDatabase.update_photo("Red pullover",R.drawable.e8);
        mShoppingDatabase.update_photo("Black jeans",R.drawable.f1);
        mShoppingDatabase.update_photo("White jabrden",R.drawable.f2);
        mShoppingDatabase.update_photo("Blue jeans",R.drawable.f3);
        mShoppingDatabase.update_photo("Black jabrden",R.drawable.f4);
        mShoppingDatabase.update_photo("Legen jeans",R.drawable.f5);
        mShoppingDatabase.update_photo("Dark blue jeans",R.drawable.f6);
        mShoppingDatabase.update_photo("Polo kens",R.drawable.f7);
        mShoppingDatabase.update_photo("Slim fit black blue",R.drawable.f8);
        mShoppingDatabase.update_photo("Baby blue blouse",R.drawable.d1);
        mShoppingDatabase.update_photo("Bej blouse",R.drawable.d2);
        mShoppingDatabase.update_photo("Black blouse",R.drawable.d3);
        mShoppingDatabase.update_photo("Karoh blouse",R.drawable.d4);
        mShoppingDatabase.update_photo("Pink blouse",R.drawable.d5);
        mShoppingDatabase.update_photo("Red blouse",R.drawable.d6);
        mShoppingDatabase.update_photo("Tiger blouse",R.drawable.d7);
        mShoppingDatabase.update_photo("White blouse",R.drawable.d8);
        mShoppingDatabase.update_photo("Baby blue dress",R.drawable.a1);
        mShoppingDatabase.update_photo("Black dress",R.drawable.a2);
        mShoppingDatabase.update_photo("Jeans dress",R.drawable.a3);
        mShoppingDatabase.update_photo("Pink dress",R.drawable.a4);
        mShoppingDatabase.update_photo("Red dress",R.drawable.a5);
        mShoppingDatabase.update_photo("Silver dress",R.drawable.a6);
        mShoppingDatabase.update_photo("White dress",R.drawable.a7);
        mShoppingDatabase.update_photo("Yellow dress",R.drawable.a8);
        mShoppingDatabase.update_photo("Black jeanss",R.drawable.c1);
        mShoppingDatabase.update_photo("Black legan",R.drawable.c2);
        mShoppingDatabase.update_photo("Blue skiny",R.drawable.c3);
        mShoppingDatabase.update_photo("High waust jeans",R.drawable.c4);
        mShoppingDatabase.update_photo("Mom fit jeans",R.drawable.c5);
        mShoppingDatabase.update_photo("Skiny",R.drawable.c6);
        mShoppingDatabase.update_photo("Snow skiny",R.drawable.c7);
        mShoppingDatabase.update_photo("White pants",R.drawable.c8);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String result = sharedPreferences.getString(REMEMBER_ME, "no");
                String email = sharedPreferences.getString(EMAIL_PREFERENCE, "");
                if (result.equals("no")) {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra(EMAIL_INTENT,email);
                    startActivity(intent);
                }

            }
        };
        button.setOnClickListener(onClickListener);
    }
}
