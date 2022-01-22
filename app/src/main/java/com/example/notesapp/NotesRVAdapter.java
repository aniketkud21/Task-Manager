package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesapp.Activities.MainActivity;

import java.util.List;

public class NotesRVAdapter extends RecyclerView.Adapter<NotesRVAdapter.ViewHolder> {

    OnNoteClick listener;
    List<Note> notes;

    public NotesRVAdapter(List<Note> notes, OnNoteClick listener) {

        this.listener = listener;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnClick(notes.get(viewHolder.getAdapterPosition()));
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.item_title.setText(notes.get(position).title);
        holder.item_subTitle.setText(notes.get(position).subTitle);
        holder.item_note.setText(notes.get(position).note);
        holder.item_date.setText(notes.get(position).Date);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView item_title, item_subTitle, item_note, item_date;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            item_title = itemView.findViewById(R.id.item_title);
            item_subTitle = itemView.findViewById(R.id.item_subTitle);
            item_note = itemView.findViewById(R.id.item_note);
            item_date = itemView.findViewById(R.id.item_date);

        }
    }

    public interface OnNoteClick{
        void OnClick(Note note);
    }
}
