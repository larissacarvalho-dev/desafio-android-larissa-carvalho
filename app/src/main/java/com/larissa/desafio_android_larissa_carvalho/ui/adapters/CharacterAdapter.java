package com.larissa.desafio_android_larissa_carvalho.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.larissa.desafio_android_larissa_carvalho.R;
import com.larissa.desafio_android_larissa_carvalho.databinding.ItemRowBinding;
import com.larissa.desafio_android_larissa_carvalho.model.Character;
import com.larissa.desafio_android_larissa_carvalho.ui.listeners.CharacterListener;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>{

     private List<Character> characterList;
     private LayoutInflater inflater;
     private CharacterListener characterListener;

    public CharacterAdapter(List<Character> characterList, CharacterListener characterListener) {
        this.characterList = characterList;
        this.characterListener = characterListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (inflater == null){
            inflater= LayoutInflater.from(parent.getContext());
        }
        ItemRowBinding itemRowBinding = DataBindingUtil.inflate(inflater, R.layout.item_row, parent, false);
        return new CharacterViewHolder(itemRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bindCharacter(characterList.get(position));
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

     class CharacterViewHolder extends RecyclerView.ViewHolder{

        private ItemRowBinding itemRowBinding;

        public CharacterViewHolder(ItemRowBinding itemRowBinding){
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bindCharacter(Character character){
            itemRowBinding.setCharacter(character);
            itemRowBinding.executePendingBindings();
            itemRowBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    characterListener.onCharacterClicked(character);
                }
            });
        }
    }
}
