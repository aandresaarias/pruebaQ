package com.pruebaq;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.pruebaq.Adapters.FilmsAdapter;
import com.pruebaq.Models.Film;

import org.json.JSONArray;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity
{
    RecyclerView recyclerView;
    List<Film> filmList = new ArrayList<>();
    String urlApi = "https://swapi.co/api/films/?format=json";
    String url;
    FilmsAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button sqlBtn = findViewById(R.id.SQLbtn);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        SqlHelper sqlHelper = new SqlHelper(getBaseContext());
        SQLiteDatabase db = sqlHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Bd creada", Toast.LENGTH_LONG).show();

        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(urlApi).build();

        sqlBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(view.getContext(),SqlActivity.class);
                startActivity(intent);

            }
        });

        okHttpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                Toast.makeText(getApplicationContext(),"No API",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                String json = response.body().string();
                JsonArray jsonArray;
                JsonObject jsonObject = new Gson().fromJson(json,(Type) JsonObject.class);
                jsonArray = jsonObject.getAsJsonArray("results");
                Gson gson = new GsonBuilder().create();

                Type list = new TypeToken<List<Film>>(){}.getType();
                filmList = gson.fromJson(jsonArray.toString(),list);

                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        adapter = new FilmsAdapter(getApplicationContext(),filmList);
                        recyclerView.setAdapter(adapter);
                    }
                });
            }
        });

        update();
    }

    public void update()
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run()
            {
                adapter = new FilmsAdapter(getApplicationContext(),filmList);
                adapter.notifyDataSetChanged();
            }
        });
    }


}

