package com.example.cashregister_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class RestockActivity extends AppCompatActivity {

    EditText inputAmount;
    Button save_btn;
    Button cancel_btn;
    ListView inventoryListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        inputAmount = findViewById(R.id.restock_num);
        save_btn = findViewById(R.id.save_btn);
        cancel_btn = findViewById(R.id.cancle_btn);
        inventoryListview = findViewById(R.id.restock_product_list);

//        int addQnt = inputAmount.getText();

    }
}