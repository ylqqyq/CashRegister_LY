package com.example.cashregister_ly;

import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView selected_name_txt;
    TextView user_amount_txt;
    TextView total_txt;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button clear_btn;
    Button buy_btn;
    Button manager_btn;
    ListView product_listview;
    static ArrayList<History> purchaseHistoryList;
    StoreManager manager;
    String inputAmountStr = "";
    int selectedIndex = -1;
    int userQnt;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selected_name_txt =findViewById(R.id.product_type);
        user_amount_txt =findViewById(R.id.user_amount);
        total_txt =findViewById(R.id.total_price);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        btn8 = findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        btn9 = findViewById(R.id.btn9);
        btn9.setOnClickListener(this);
        btn0 = findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        clear_btn = findViewById(R.id.btn_clear);
        clear_btn.setOnClickListener(this);
        buy_btn = findViewById(R.id.buy_btn);
        buy_btn.setOnClickListener(this);
        manager_btn = findViewById(R.id.manager_mode);
        manager_btn.setOnClickListener(this);
        product_listview = (ListView) findViewById(R.id.product_list);

        manager = ((myApp)getApplication()).getManager();
        purchaseHistoryList = ((myApp)getApplication()).getManager().purchaseHistory;

        adapter = new ListAdapter(manager.inventory, this);
        product_listview.setAdapter(adapter);
        product_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_name_txt.setText(getString(R.string.selected_product) +manager.inventory.get(position).getName());
                selectedIndex = position;
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == manager_btn) {
           Intent manager_intent = new Intent(getApplicationContext(),ManagerActivity.class);
//           manager_intent.putParcelableArrayListExtra("history",purchaseHistoryList);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("history",purchaseHistoryList);
            manager_intent.putExtras(bundle);
            startActivity(manager_intent);

        } else if (v == clear_btn)
        {   reset();
        } else if (v == buy_btn) {
            if (selectedIndex == -1) {
                Toast.makeText(this, "Please select product",Toast.LENGTH_LONG).show();
            }
            else {
                //BUY BUTTON CLICKED
                if (manager.inStock(manager.inventory.get(selectedIndex),userQnt)) {
                    //update product quantity
                   manager.inventory.get(selectedIndex).setQuantity(manager.inventory.get(selectedIndex).getQuantity() - userQnt);
                   adapter.notifyDataSetChanged();

                   History purchasedItem = manager.newPurchase((manager.inventory.get(selectedIndex).getName()),userQnt,
                           manager.inventory.get(selectedIndex).getPrice(),
                           (new Date().toString()));

                    purchaseHistoryList.add(purchasedItem);
                    reset();
            } else {
                    Toast.makeText(this, "Not In Stock",Toast.LENGTH_LONG).show();
                }
            }
        } else {
            if(selectedIndex == -1)  {
                Toast.makeText(this, "Please select product type",Toast.LENGTH_LONG).show();
            } else {

                //click digits
                inputAmountStr += ((Button) v).getText().toString();
                user_amount_txt.setText(getString(R.string.you_are_purchasing) + inputAmountStr + " " +manager.inventory.get(selectedIndex).getName());
                userQnt = Integer.parseInt(inputAmountStr);
                double total = Integer.parseInt(inputAmountStr) * manager.inventory.get(selectedIndex).getPrice();
                String totalStr = (String) String.format("%.2f",total);
                double total2f = Double.parseDouble(totalStr);
                total_txt.setText(getString(R.string.your_total) + total2f);
            }
        }
    }
    
    void reset(){
        total_txt.setText(null);
        user_amount_txt.setText(null);
        inputAmountStr="";
        selected_name_txt.setText(null);
    }
}