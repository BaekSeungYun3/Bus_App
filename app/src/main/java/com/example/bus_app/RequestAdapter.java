package com.example.bus_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RequestAdapter extends FirestoreRecyclerAdapter<Note, RequestAdapter.RequestViewHolder>  {

    Context context;

    public RequestAdapter(@NonNull FirestoreRecyclerOptions<Note> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull RequestAdapter.RequestViewHolder holder, int position, @NonNull Note note) {
        holder.titleTextView.setText(note.title);
        holder.contentTextView.setText(note.content);
        holder.timespampTextView.setText(Utility.timestampTostring(note.timestamp));


    }

    @NonNull
    @Override
    public RequestAdapter.RequestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_note_item,parent,false);
        return new RequestAdapter.RequestViewHolder(view);
    }

    class RequestViewHolder extends RecyclerView.ViewHolder{

        TextView titleTextView,contentTextView,timespampTextView;

        public RequestViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.notes_title_text_view);
            contentTextView = itemView.findViewById(R.id.notes_content_text_view);
            timespampTextView = itemView.findViewById(R.id.notes_timestamp_text_view);
        }
    }
}

