package com.rajnish.tspschemes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SanchalitYActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Scheme> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanchalit_y);
        list=new ArrayList<>();
        recyclerView=findViewById(R.id.recycview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchScheme();

    }
    private void fetchScheme() {
        StringRequest stringRequest=new StringRequest(1, "http://searchkero.com/Pramod/fetch.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray jarray=jsonObject.getJSONArray("Data");
                    for(int i=0;i<jarray.length();i++){
                        JSONObject job =jarray.getJSONObject(i);
                        String id=job.getString("id");
                        String scheme=job.getString("scheme");
                        list.add(new Scheme(id,scheme));
                    }
                    MyAdapter myAdapter=new MyAdapter(getApplicationContext(),list);
                    recyclerView.setAdapter(myAdapter);

                } catch (JSONException jsonException) {
                        jsonException.printStackTrace();
                    }

            }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(SanchalitYActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();

        }
    });
    RequestQueue requestQueue= Volley.newRequestQueue(SanchalitYActivity.this);
        requestQueue.add(stringRequest);



}}
