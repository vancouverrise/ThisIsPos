package com.iksmarket.thisispos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.iksmarket.thisispos.ItemForReceipt;
import com.iksmarket.thisispos.R;


import java.util.List;

public class ReceiptAdapter extends RecyclerView.Adapter<ReceiptAdapter.ReceiptViewHolder> {

    public List<ItemForReceipt> items;


    public ReceiptAdapter(List<ItemForReceipt> items){
        this.items = items;
    }

    public class ReceiptViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView itemName;
        TextView itemBarcode;

        ReceiptViewHolder(View receiptView){
            super(receiptView);
            cv = receiptView.findViewById(R.id.cv);
            itemName = receiptView.findViewById(R.id.item_name);
            itemBarcode = receiptView.findViewById(R.id.item_barcode);
            receiptView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            System.out.println(getItem(getAdapterPosition()).barcode);

        }
    }

    @NonNull
    @Override
    public ReceiptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.check_layout, parent, false);
        ReceiptViewHolder receiptViewHolder = new ReceiptViewHolder(v);
        return receiptViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReceiptViewHolder holder, int position) {
       holder.itemName.setText(items.get(position).name);
       holder.itemBarcode.setText(items.get(position).barcode);
    }



    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public ItemForReceipt getItem(int position) {
        return items.get(position);
    }





}
