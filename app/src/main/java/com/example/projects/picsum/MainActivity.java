package com.example.projects.picsum;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetDataList service = RetrofitInstance.getRetrofitInstance().create(GetDataList.class);
        Call<List<Data>> call = service.getData();
        call.enqueue(new Callback<List<Data>>() {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong !!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Data> body) {
        RecyclerView rv = findViewById(R.id.rv);
        int noOfColumns = calculateNoOfColumns(getApplicationContext(),120);
        rv.setLayoutManager(new GridLayoutManager(this, noOfColumns));
        rv.setHasFixedSize(true);
        DataAdapter dataAdapter = new DataAdapter(body);
        rv.setAdapter(dataAdapter);

        dataAdapter.notifyDataSetChanged();
    }

    public static int calculateNoOfColumns(Context context, float columnWidthDp) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (screenWidthDp / columnWidthDp + 0.5);
        return noOfColumns;
    }
}