package com.iitism.monote;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iitism.monote.db.User;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<User> notesList ;

    public RecyclerViewAdapter(Context context, List<User> notesList) {
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View v= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.notecard,viewGroup,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        User user=notesList.get(position);
        holder.txttitle.setText(user.getTitle());
        holder.txtnote.setText(user.getNote());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txttitle,txtnote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txttitle=itemView.findViewById(R.id.text_title);
            txtnote=itemView.findViewById(R.id.text_note);

        }
    }

}


