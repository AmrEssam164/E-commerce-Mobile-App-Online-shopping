package com.amressam.navigation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    ImageButton imageButton;
    Button button;
    EditText email;
    EditText password;
    TextView forget;
    TextView login;
    CheckBox checkBox;
    ShoppingDatabase mShoppingDatabase;
    public static final String EMAIL_INTENT = "email";
    public static final String REMEMBER_ME = "remember";
    public static final String EMAIL_PREFERENCE = "email";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = (Button) findViewById(R.id.new_act);
        imageButton = (ImageButton) findViewById(R.id.btRegister);
        email = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        forget = (TextView) findViewById(R.id.tvForgot);
        login = (TextView) findViewById(R.id.tvLogin);
        checkBox = (CheckBox) findViewById(R.id.checkBox);

        mShoppingDatabase = new com.amressam.navigation.ShoppingDatabase(getApplicationContext());

        imageButton.setOnClickListener(onClickListener1);

        button.setOnClickListener(onClickListener2);

        forget.setOnClickListener(onClickListener3);

        checkBox.setOnClickListener(onClickListener5);
    }

    View.OnClickListener onClickListener1 = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View v) {
            Intent intent   = new Intent(getApplicationContext(),SignupActivity.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(login,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(intent,activityOptions.toBundle());

        }
    };

    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean check = false;
            Cursor cursor = mShoppingDatabase.log_in();
            while (!cursor.isAfterLast()) {
                if (email.getText().toString().equals(cursor.getString(0)) &&
                        password.getText().toString().equals(cursor.getString(1))) {
                    check = true;
                    break;
                } else {
                    check = false;
                }
                cursor.moveToNext();
            }
            if (check == true) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra(EMAIL_INTENT,email.getText().toString());
                email.setText("");
                password.setText("");
                checkBox.setChecked(false);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Invalid email or password", Toast.LENGTH_LONG).show();
            }

        }
    };

    View.OnClickListener onClickListener3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(getApplicationContext(), com.amressam.navigation.Forget_password.class);
            startActivity(intent2);
        }
    };

    View.OnClickListener onClickListener5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            if(checkBox.isChecked())
            {
                String result = sharedPreferences.getString(REMEMBER_ME, "no");
                if (result.equals("no")) {
                    sharedPreferences.edit().putString(REMEMBER_ME, "yes").apply();
                    sharedPreferences.edit().putString(EMAIL_PREFERENCE,email.getText().toString()).apply();
                }
            } else {
                String result = sharedPreferences.getString(REMEMBER_ME, "");
                if (result.equals("yes")) {
                    sharedPreferences.edit().putString(REMEMBER_ME, "no").apply();
                    sharedPreferences.edit().putString(EMAIL_PREFERENCE,"").apply();
                }
            }
        }
    };


}
