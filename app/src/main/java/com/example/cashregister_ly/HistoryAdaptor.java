package com.example.cashregister_ly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdaptor extends RecyclerView.Adapter<HistoryAdaptor.viewHolder> {

    ArrayList<History> purchaseList;
    Context c;

    public HistoryAdaptor(ArrayList<History> purchaseList, Context c) {
        this.purchaseList = purchaseList;
        this.c = c;
    }

    public interface historyOnClickListener {
        void onItemSelected(History selectedItem);
    }

    public historyOnClickListener listener;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.history_cell,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.getPurchase_type().setText(purchaseList.get(position).getName());
        holder.getPurchase_amount().setText(purchaseList.get(position).getQuantity());
        double total = purchaseList.get(position).getPrice() * purchaseList.get(position).getQuantity();
       String totalStr = (String) String.format("%.2f",total);
        holder.getTotal().setText(totalStr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemSelected(purchaseList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return purchaseList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private final TextView purchase_type;
        private final TextView purchase_amount;
        private final TextView total;

        public TextView getPurchase_type() {
            return purchase_type;
        }
        public TextView getPurchase_amount() {
            return purchase_amount;
        }
        public TextView getTotal() {
            return total;
        }

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            purchase_type = itemView.findViewById(R.id.purchase_type);
            purchase_amount = itemView.findViewById(R.id.purchase_amount);
            total = itemView.findViewById(R.id.purchase_total);

        }
    }
}
