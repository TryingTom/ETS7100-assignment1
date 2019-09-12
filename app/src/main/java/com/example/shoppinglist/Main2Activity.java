package com.example.shoppinglist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

import static com.example.shoppinglist.MainActivity.*;

public class Main2Activity extends AppCompatActivity {

    TextView itemView;

    Button BackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        itemView = (TextView) findViewById(R.id.listView);

        itemView.append("\n" + ShoppingList);


        BackBtn = (Button) findViewById(R.id.backbutton);

        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // let's give an alert
                showAlertDialog();
            }
        }); // BackBtn onClick end

    }

    public void openActivity1() {
        Intent nextScreen = new Intent (this, MainActivity.class);
        startActivity(nextScreen);
    } // end openActivity1

    public void showAlertDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Are you sure?");
            alert.setMessage("Do you want to go back? (This will clear your list)");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // go back to first screen
                    openActivity1();
                    // clear the list
                    ShoppingList.clear();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    // do nothing
                }
            });
            alert.create().show();
    } // end showAlert
}
