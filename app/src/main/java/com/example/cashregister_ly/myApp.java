package com.example.cashregister_ly;

import android.app.Application;

import java.util.ArrayList;

public class myApp extends Application {

    private StoreManager manager = new StoreManager();

    public StoreManager getManager() {
        return manager;
    }

//    private HistoryArraylist historyRecord = new HistoryArraylist();
//
//    public HistoryArraylist getHistoryRecord() {
//        return historyRecord;
//    }
}
