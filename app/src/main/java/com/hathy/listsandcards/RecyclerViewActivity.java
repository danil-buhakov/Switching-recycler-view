package com.hathy.listsandcards;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends ActionBarActivity {

    private List<Boat> boats;
    private RecyclerView rv;
    private final int STAGE_LIST=0;
    private final int STAGE_TILE=1;


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



        stage =STAGE_LIST;
        llm = new LinearLayoutManager(this);
        glm = new GridLayoutManager(this, 2);
        rv.setLayoutManager(llm);

        initializeData();
        initializeListViewAdapter();
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boats.get(0).addText();
                refreshView();
            }
        });

        btnAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boats.get(0).addAudio();
                refreshView();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_change,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_change:
                changeLayoutManager();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeLayoutManager(){
        if(stage == STAGE_TILE){
            changeToList();
        }
        else
            if(stage==STAGE_LIST){
                changeToTile();
            }
    }

    private void changeToList(){
        initializeListViewAdapter();
        rv.setLayoutManager(llm);
        stage =STAGE_LIST;
    }
    private void changeToTile(){
        initializeTileViewAdapter();
        rv.setLayoutManager(glm);
        stage =STAGE_TILE;
    }

    private void initializeData(){
        boats = new ArrayList<>();
        boats.add(new Boat( R.drawable.boat_long));
        boats.add(new Boat( R.drawable.boat_garden));
        boats.add(new Boat( R.drawable.boat_black));
    }

    private void refreshView(){
        if(stage == 0){
            initializeListViewAdapter();
        }
        else
        if(stage==1){
            initializeTileViewAdapter();
        }
    }
    private void initializeListViewAdapter(){
        ListViewAdapter adapter = new ListViewAdapter(boats);
        rv.setAdapter(adapter);
    }
    private void initializeTileViewAdapter(){
        TileViewAdapter adapter = new TileViewAdapter(boats);
        rv.setAdapter(adapter);
    }
}
