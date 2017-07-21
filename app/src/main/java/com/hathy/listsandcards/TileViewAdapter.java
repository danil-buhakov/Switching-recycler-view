package com.hathy.listsandcards;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class TileViewAdapter extends RecyclerView.Adapter<TileViewAdapter.PersonViewHolder> {

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        ImageView personPhoto;
        FrameLayout layoutDescription;

        PersonViewHolder(View itemView) {
            super(itemView);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            layoutDescription = (FrameLayout) itemView.findViewById(R.id.fltDescription);
        }
    }

    List<Boat> boats;

    TileViewAdapter(List<Boat> boats){
        this.boats = boats;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tile, viewGroup, false);
        PersonViewHolder pvh = new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        Boat currBoat = boats.get(i);
        personViewHolder.personPhoto.setImageResource(currBoat.photoId);
        View v = LayoutInflater.from(personViewHolder.layoutDescription.getContext()).inflate(R.layout.description_tile, personViewHolder.layoutDescription, false);
        TextView txtText =((TextView)v.findViewById(R.id.txtText));
        txtText.setText(Integer.toString(currBoat.text_number));
        ((TextView)v.findViewById(R.id.txtAudio)).setText(Integer.toString(currBoat.audio_number));
        personViewHolder.layoutDescription.addView(v);
    }

    @Override
    public int getItemCount() {
        return boats.size();
    }
}
