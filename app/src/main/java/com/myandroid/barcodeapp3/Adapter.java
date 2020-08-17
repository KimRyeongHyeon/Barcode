package com.myandroid.barcodeapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Barcode> barcodes;
    private Context context;

    public Adapter(List<Barcode> barcodes, Context context) {
        this.barcodes = barcodes;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.barcodeText.setText(barcodes.get(position).getBarcode());
        holder.foodText.setText(barcodes.get(position).getFood_name());
        holder.companyText.setText(barcodes.get(position).getCompany_name());
    }

    @Override
    public int getItemCount() {
        return barcodes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView barcodeText, foodText, companyText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            barcodeText = itemView.findViewById(R.id.barcodeText);
            foodText = itemView.findViewById(R.id.foodText);
            companyText = itemView.findViewById(R.id.companyText);
        }
    }
}
