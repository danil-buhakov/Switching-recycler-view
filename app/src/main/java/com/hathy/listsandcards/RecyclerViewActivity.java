package com.hathy.listsandcards;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<Boat> boats;
    private RecyclerView rv;
    private Button btnText;
    private Button btnAudio;
    private int stage;
    private LinearLayoutManager llm;
    private GridLayoutManager glm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        rv=(RecyclerView)findViewById(R.id.rv);
        btnText = (Button)findViewById(R.id.btnText);
        btnAudio = (Button)findViewById(R.id.btnAudio);



        stage =0;
        llm = new LinearLayoutManager(this);
        glm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);

        initializeData();
        initializeAdapter();
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boats.get(0).addText();
                initializeAdapter();
                rv.invalidateItemDecorations();
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boats.get(0).addAudio();
                initializeAdapter();
                rv.invalidateItemDecorations();
            }
        });

    }

    private void changeLayoutManager(){
        if(stage == 0){
            rv.setLayoutManager(glm);
            stage =1;
        }
        else{
            rv.setLayoutManager(llm);
            stage =0;
        }
    }

    private void initializeData(){
        boats = new ArrayList<>();
        boats.add(new Boat( R.drawable.boat_long));
        boats.add(new Boat( R.drawable.boat_garden));
        boats.add(new Boat( R.drawable.boat_black));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(boats);
        rv.setAdapter(adapter);
    }
}
