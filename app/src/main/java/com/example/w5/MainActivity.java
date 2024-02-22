package com.example.w5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.w5.adapters.InfoAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView infoRecycler = findViewById(R.id.info_recycler);
        infoRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        TextView selector = findViewById(R.id.selector);

        ArrayList<InfoAdapter.InfoModel> info = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            info.add(new InfoAdapter.InfoModel("https://picsum.photos/200", "Nguyen Van " + i, "123456789" + i));
        }
        InfoAdapter infoAdapter = new InfoAdapter(info, selector);
        infoRecycler.setAdapter(infoAdapter);
    }
}