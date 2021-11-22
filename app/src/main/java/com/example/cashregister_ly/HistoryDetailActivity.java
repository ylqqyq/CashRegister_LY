package com.example.cashregister_ly;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

public class HistoryDetailActivity extends AppCompatActivity {
    TextView product_name;
    TextView product_price;
    TextView purchase_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        purchase_date = findViewById(R.id.purchase_date);
        Bundle b = getIntent().getExtras();
        History item = b.getParcelable("history_detail");
        product_name.setText("Product: "+ item.getName());

        double price = item.getPrice();
        String priceStr = (String) String.format("%.2f",price);
        double total2f = Double.parseDouble(priceStr);
        product_price.setText("Price: " + total2f);
        purchase_date.setText("Purchase Date: "+ item.getPurchaseTime());
    }
}