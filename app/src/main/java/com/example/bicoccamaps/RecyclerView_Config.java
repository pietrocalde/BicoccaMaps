package com.example.bicoccamaps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private EdificioAdapter mEdificioAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Edificio> edifici, List<String> keys){
        mContext = context;
        mEdificioAdapter = new EdificioAdapter(edifici, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mEdificioAdapter);
    }

    class EdificioItemView extends RecyclerView.ViewHolder{

        private TextView mNome;
        private TextView mIndirizzo;

        private String key;

        public EdificioItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.edifici_list_item, parent, false));

            mNome = (TextView) itemView.findViewById(R.id.nomeEdificio);
            mIndirizzo = (TextView) itemView.findViewById(R.id.indirizzoEdificio);
        }

        public void bind(Edificio edificio, String key){
            mNome.setText(edificio.getNome());
            mIndirizzo.setText(edificio.getIndirizzo());
            this.key = key;
        }
    }
    class EdificioAdapter extends RecyclerView.Adapter<EdificioItemView>{
        private List<Edificio> mEdificioList;
        private List<String> mKeys;

        public EdificioAdapter(List<Edificio> mEdificioList, List<String> mKeys) {
            this.mEdificioList = mEdificioList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public EdificioItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new EdificioItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull EdificioItemView holder, int position) {
            holder.bind(mEdificioList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mEdificioList.size();
        }
    }
}

