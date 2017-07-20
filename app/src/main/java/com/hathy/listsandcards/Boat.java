package com.hathy.listsandcards;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Boat {
    int photoId;
    List<String> text;
    List<String> audio;

    Boat(int photoId) {
        this.photoId = photoId;
        text= new ArrayList<>();
        audio= new ArrayList<>();
    }
    public void addText(){
        text.add("Text №"+(text.size()+1));
        Log.d("MyLog","Text №"+text.size()+ " added!");
    }
    public void addAudio(){
        audio.add("Audio №"+(audio.size()+1));
        Log.d("MyLog","Audio №"+audio.size()+ " added!");
    }
}