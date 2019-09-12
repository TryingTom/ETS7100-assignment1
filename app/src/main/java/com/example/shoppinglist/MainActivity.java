package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    String listItem;

    EditText listText;

    Button SaveBtn;
    Button DoneBtn;

    public static final List ShoppingList = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listText = (EditText) findViewById(R.id.listText);

        SaveBtn = (Button) findViewById(R.id.bnt_save);
        DoneBtn = (Button) findViewById(R.id.btn_done);

        // let's get the button working
        // find button
        // let's make it do stuff
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listItem = listText.getText().toString();

                // if text length is more than 15 or less than 3
                if (listItem.length() < 3 || listItem.length() > 15){
                    // toast will be said to signal the error
                    Toast.makeText(getApplicationContext(), "Toast ;)", Toast.LENGTH_SHORT)
                            .show();
                }

                // if the text is the right length:
                else {
                    // add the item to the list
                    ShoppingList.add(listItem);
                    // confirm saved text to the user
                    Toast.makeText(getApplicationContext(), "Added!", Toast.LENGTH_SHORT)
                            .show();
                }
        }
        }); // SaveBtn onClick end

        DoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        }); // DoneBtn onClick end

    }
    public void openActivity2() {
        Intent nextScreen = new Intent (this, Main2Activity.class);
        startActivity(nextScreen);
    }
}
