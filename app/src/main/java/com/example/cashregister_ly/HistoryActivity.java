package com.example.cashregister_ly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity{
//        implements HistoryAdaptor.historyOnClickListener
    RecyclerView purchaseHistoryListview;
    ArrayList<History> purchaseHistory;
    TextView nohistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        purchaseHistoryListview = findViewById(R.id.history_relist);
        nohistory = findViewById(R.id.no_history);
//        purchaseHistory = ((myApp)getApplication()).getManager().getPurchaseHistory();
//        if (purchaseHistory.size() == 0) {
//            nohistory.setVisibility(View.VISIBLE);
//
//        } else {
        purchaseHistory = this.getIntent().getExtras().getParcelableArrayList("history");
        purchaseHistoryListview.setLayoutManager(new LinearLayoutManager(this));
        HistoryAdaptor adaptor = new HistoryAdaptor(purchaseHistory, this);
        purchaseHistoryListview.setAdapter(adaptor);

            System.out.println(purchaseHistory);

        }
    }

//    @Override
//    public void onItemSelected(History selectedItem) {
//        Intent intent = new Intent();
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("history_detail",selectedItem);
//        startActivity(intent);
//    }
//}