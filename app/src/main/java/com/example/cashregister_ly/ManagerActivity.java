package com.example.cashregister_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.LauncherActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ManagerActivity extends AppCompatActivity {
    Button history_btn;
    Button restock_btn;
    Button new_btn;
    ArrayList<History> purchaseHistory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        history_btn = findViewById(R.id.to_history);
        restock_btn = findViewById(R.id.to_restock);
        new_btn = findViewById(R.id.add_new);
        //receive bundle from Main
        purchaseHistory = this.getIntent().getParcelableArrayListExtra("history");
        System.out.println(purchaseHistory);
        history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pass bundle to HistoryActivity
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("history",purchaseHistory);
                Intent history_intent = new Intent(getApplicationContext(),HistoryActivity.class);
                history_intent.putExtras(bundle);
                startActivity(history_intent);
            }
        });

    }
}