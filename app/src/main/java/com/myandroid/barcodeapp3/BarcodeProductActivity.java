package com.myandroid.barcodeapp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BarcodeProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Barcode> barcodes;
    private Adapter adapter;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_product);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        Intent intent = getIntent();
        String key = intent.getExtras().getString("key");

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Barcode>> call = apiInterface.getBarcode(key);

        call.enqueue(new Callback<List<Barcode>>() {
            @Override
            public void onResponse(Call<List<Barcode>> call, Response<List<Barcode>> response) {
                barcodes = response.body();
                adapter = new Adapter(barcodes, BarcodeProductActivity.this);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Barcode>> call, Throwable t) {
                Toast.makeText(BarcodeProductActivity.this, "Error on : " + t.toString(), Toast.LENGTH_LONG).show();
                System.out.println("Error on : " + t.toString());
            }
        });
    }
}