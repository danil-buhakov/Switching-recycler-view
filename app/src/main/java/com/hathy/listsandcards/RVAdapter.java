package com.hathy.listsandcards;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView personPhoto;
        LinearLayout layoutText;
        LinearLayout layoutAudio;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            layoutText = (LinearLayout) itemView.findViewById(R.id.lltText);
            layoutAudio = (LinearLayout) itemView.findViewById(R.id.lltAudio);


        }
    }

    List<Boat> boats;

    RVAdapter(List<Boat> boats){
        this.boats = boats;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Boat currBoat = boats.get(i);
        personViewHolder.personPhoto.setImageResource(currBoat.photoId);
        for(int j =0;j<currBoat.text.size();j++){
            Log.d("MyLog", "Text №" + (j+1) + " showed!");
            View v = LayoutInflater.from(personViewHolder.layoutText.getContext()).inflate(R.layout.text_description, personViewHolder.layoutText, false);
            TextView textView = (TextView) v.findViewById(R.id.txtText);
            textView.setText(currBoat.text.toArray()[j].toString());
            personViewHolder.layoutText.addView(v);
        }
        for(int j =0;j<currBoat.audio.size();j++){
            Log.d("MyLog", "Audio №" + (j+1) + " showed!");
            View v = LayoutInflater.from(personViewHolder.layoutAudio.getContext()).inflate(R.layout.audio_description, personViewHolder.layoutAudio, false);
            TextView textView = (TextView) v.findViewById(R.id.txtAudio);
            textView.setText(currBoat.audio.toArray()[j].toString());
            personViewHolder.layoutAudio.addView(v);
        }
    }

    @Override
    public int getItemCount() {
        return boats.size();
    }
}
