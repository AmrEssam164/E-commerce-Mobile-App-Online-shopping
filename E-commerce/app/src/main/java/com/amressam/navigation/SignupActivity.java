package com.amressam.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SignupActivity extends AppCompatActivity {

    RelativeLayout rlayout;
    Animation animation;
    Toolbar toolbar;
    EditText email;
    EditText username2;
    EditText password2;
    EditText password3;
    EditText school;
    EditText color;
    EditText birthdate;
    Button signup;
    String reciver;
    String date;
    ShoppingDatabase mShoppingDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        toolbar = findViewById(R.id.bgHeader);
        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this, R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);
        email = (EditText) findViewById(R.id.email);
        username2 = (EditText) findViewById(R.id.username2);
        password2 = (EditText) findViewById(R.id.password2);
        password3 = (EditText) findViewById(R.id.password3);
        school = (EditText) findViewById(R.id.school4);
        color = (EditText) findViewById(R.id.color4);
        birthdate = (EditText) findViewById(R.id.date);
        signup = (Button) findViewById(R.id.signup);

        mShoppingDatabase = new ShoppingDatabase(getApplicationContext());

        setToolbar();

        signup.setOnClickListener(onClickListener);

        birthdate.setOnClickListener(onClickListener2);

        Intent intent = getIntent();
        date = intent.getStringExtra("DATE");

    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        reciver=Calendar.date;
        birthdate.setText(reciver);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean check = false;
            if (password2.getText().toString().equals(password3.getText().toString())) {
                if (email.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter your email", Toast.LENGTH_LONG).show();
                    check = false;
                } else {
                    if (username2.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Please enter your username", Toast.LENGTH_LONG).show();
                        check = false;
                    } else {
                        if (school.getText().toString().equals("")) {
                            Toast.makeText(getApplicationContext(), "Please enter your first school", Toast.LENGTH_LONG).show();
                        } else {
                            if (color.getText().toString().equals("")) {
                                Toast.makeText(getApplicationContext(), "Please enter your favourite color", Toast.LENGTH_LONG).show();
                            } else {
                                if(birthdate.getText().toString().equals(""))
                                {
                                    Toast.makeText(getApplicationContext(), "Please enter your birth date", Toast.LENGTH_LONG).show();
                                }
                                else {
                                    check = true;
                                }
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(getApplicationContext(), "Please retype the password correctly", Toast.LENGTH_LONG).show();
            }
            if (check == true) {
                mShoppingDatabase.createNewRow(email.getText().toString(), username2.getText().toString(), password2.getText().toString(), school.getText().toString(), color.getText().toString(),birthdate.getText().toString());
                Toast.makeText(getApplicationContext(), "you have signed up successfully", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(),Calendar.class);
            startActivity(intent);
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(item_id==android.R.id.home){
            onBackPressed();
        }
        return true;
    }
}
