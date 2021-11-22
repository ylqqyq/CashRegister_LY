package com.example.cashregister_ly;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;

public class History extends Product implements Parcelable {

    private String purchaseTime;

    public String toString(){
        return "product: " + getName() + ";quantity: " +getQuantity() + ";price: " +getPrice() +";Time: " +getPurchaseTime();    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public History(String name, int quantity, double price, String purchaseTime) {
        super(name, quantity, price);
        this.purchaseTime = purchaseTime;
    }


    protected History(Parcel in) {
        super(in);
        purchaseTime = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        dest.writeString(purchaseTime);
    }
}
