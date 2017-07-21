package com.hathy.listsandcards;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Boat {
    int photoId;
    List<String> description;
    int audio_number;
    int text_number;

    Boat(int photoId) {
        this.photoId = photoId;
        description= new ArrayList<>();
        text_number=0;
        audio_number=0;
    }
    public void addText(){
        text_number++;
        description.add("Text №"+(description.size()+1));
        Log.d("MyLog","Text №"+description.size()+ " added!");
    }
    public void addAudio(){
        audio_number++;
        description.add("Audio №"+(description.size()+1));
        Log.d("MyLog","Audio №"+description.size()+ " added!");
    }
}