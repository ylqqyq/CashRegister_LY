package com.example.cashregister_ly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    ArrayList<Product> productList;
    Context myContext;

    ListAdapter(ArrayList<Product> list, Context activity_context) {
        myContext = activity_context;
        productList= list;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(myContext).inflate(R.layout.storelist_cell,null);
        TextView name = convertView.findViewById(R.id.item_name);
        TextView quantity = convertView.findViewById(R.id.item_quantity);
        TextView price = convertView.findViewById(R.id.item_price);

               name.setText(productList.get(position).getName());
               quantity.setText(productList.get(position).getQuantity() + "");
               price.setText(productList.get(position).getPrice() + "");


        return convertView;
    }

    void updateInventory(ArrayList<Product> newInventory) {
        productList = newInventory;
        this.notifyDataSetChanged();

    }
}
