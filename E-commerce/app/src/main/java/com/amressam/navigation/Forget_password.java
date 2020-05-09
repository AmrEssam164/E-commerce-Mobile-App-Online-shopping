package com.amressam.navigation;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Forget_password extends AppCompatActivity {

    EditText school;
    EditText color;
    Button ret_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        school = (EditText) findViewById(R.id.school2);
        color = (EditText) findViewById(R.id.color2);
        ret_pass = (Button) findViewById(R.id.ret_pass);

        final ShoppingDatabase shoppingDatabase = new ShoppingDatabase(getApplicationContext());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password="";
                Cursor cursor = shoppingDatabase.forget(school.getText().toString(),color.getText().toString());
                if(cursor.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"Invalid data",Toast.LENGTH_LONG).show();
                }else{
                    while (!cursor.isAfterLast()) {
                        password=cursor.getString(0);
                        cursor.moveToNext();
                    }
                    Toast.makeText(getApplicationContext(),"Your password is "+password,Toast.LENGTH_LONG).show();
                }

            }
        };

        ret_pass.setOnClickListener(onClickListener);

    }
}
