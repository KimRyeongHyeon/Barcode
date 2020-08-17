package com.myandroid.barcodeapp3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("getBarcodes.php")
    Call<List<Barcode>> getBarcode(@Query("barcode") String keyword);
}
