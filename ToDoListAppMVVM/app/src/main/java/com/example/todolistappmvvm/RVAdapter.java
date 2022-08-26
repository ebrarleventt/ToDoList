package com.example.todolistappmvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.compose.ui.node.ViewAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistappmvvm.databinding.EachRvBinding;

import java.util.List;

import javax.security.auth.callback.Callback;

public class RVAdapter extends ListAdapter<Note, RVAdapter.ViewHolder>{

    public RVAdapter(MainActivity mainActivity){
        super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
            && oldItem.getContent().equals(newItem.getContent());
        }
    };


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Note note = getItem(position);
        holder.eachRvBinding.titleTV.setText(note.getTitle());
        holder.eachRvBinding.contentTV.setText(note.getContent());
    }

    public Note getNote(int position){
        return getItem(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        EachRvBinding eachRvBinding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eachRvBinding = EachRvBinding.bind(itemView);
        }
    }

}
