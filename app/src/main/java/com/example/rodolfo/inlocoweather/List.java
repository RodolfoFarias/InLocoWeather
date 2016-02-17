package com.example.rodolfo.inlocoweather;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rodolfo on 2/17/2016.
 */
public class List extends ListActivity {

    Singleton singleton = Singleton.getInstance();
    ArrayList<Cidade> cidades = singleton.arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new MyAdapter());
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(List.this,CidadeDetails.class);
        intent.putExtra("name",cidades.get(position).getNome());
        intent.putExtra("tempMax",cidades.get(position).getTempMax());
        intent.putExtra("tempMin",cidades.get(position).getTempMim());
        intent.putExtra("description",cidades.get(position).getDescricao());
        startActivity(intent);
    }

    class MyAdapter extends BaseAdapter{

        private LayoutInflater inflater;

        @Override
        public int getCount() {
            return cidades.size();
        }

        @Override
        public Object getItem(int position) {
            return cidades.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (convertView == null) {
                if (inflater == null)
                    inflater = (LayoutInflater) List.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.list_layout, parent, false);
            }

            TextView name = (TextView) row.findViewById(R.id.nameView);
            name.setText(cidades.get(position).getNome());
            return row;
        }
    }

}


