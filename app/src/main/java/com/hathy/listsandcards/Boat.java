package com.hathy.listsandcards;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Boat {
    int photoId;
    List<String> description;

    Boat(int photoId) {
        this.photoId = photoId;
        description= new ArrayList<>();
    }
    public void addText(){
        description.add("Text №"+(description.size()+1));
        Log.d("MyLog","Text №"+description.size()+ " added!");
    }
    public void addAudio(){
        description.add("Audio №"+(description.size()+1));
        Log.d("MyLog","Audio №"+description.size()+ " added!");
    }
}